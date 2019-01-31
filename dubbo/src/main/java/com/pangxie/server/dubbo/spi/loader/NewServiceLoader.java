package com.pangxie.server.dubbo.spi.loader;

import com.sun.deploy.util.StringUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.util.*;
import java.util.function.Consumer;

/**
 * Create By fightingcrap On 2019/01/31
 * |  .--,       .--,
 * |( (  \.---./  ) )
 * | '.__/o   o\__.'
 * |    {=  ^  =}
 * |     >  -  <
 * |    /       \
 * |   //       \\
 * |  //|   .   |\\
 * |  "'\       /'"_.-~^`'-.
 * |     \  _  /--'         `
 * |   ___)( )(___
 * |  (((__) (__)))    程序镇压神兽，排查一切bug。
 * |
 * |
 * | NewServiceLoader
 * |
 * | @author fightingcrap
 **/
public class NewServiceLoader<S> {
    private static final String PREFIX = "META-INF/services/";

    private String prefix = "META-INF/services/";

    /**
     * 接口的class
     */
    private final Class<S> service;

    /**
     * 类加载器
     */
    private final ClassLoader loader;

    /**
     * 权限上下文
     */
    private final AccessControlContext acc;

    /**
     * 提供者列表
     */
    private LinkedHashMap<String, S> providers = new LinkedHashMap<>();

    private HashSet<String> providersName = new HashSet<>();


    private NewServiceLoader(Class<S> svc, String prefix, ClassLoader cl) {
        service = Objects.requireNonNull(svc, "Service interface cannot be null");
        loader = (cl == null) ? ClassLoader.getSystemClassLoader() : cl;
        acc = (System.getSecurityManager() != null) ? AccessController.getContext() : null;
        this.prefix = prefix;
        reload();
    }

    public static <S> NewServiceLoader<S> load(Class<S> sClass, String urlFix) {
        return new NewServiceLoader<S>(sClass, urlFix, null);
    }

    public static <S> NewServiceLoader<S> load(Class<S> sClass) {
        return new NewServiceLoader<S>(sClass, PREFIX, null);
    }

    public static <S> NewServiceLoader<S> load(Class<S> sClass, ClassLoader classLoader) {
        return new NewServiceLoader<S>(sClass, PREFIX, classLoader);
    }


    public LinkedHashMap<String, S> getProviders() {
        //如果两者长度不一致，说明没有加载全实例，需要加载实例
        if (providers.size() != providersName.size()) {
            instanceClass(providersName, providers, service);
        }
        return providers;
    }

    public void setProviders(LinkedHashMap<String, S> providers) {
        this.providers = providers;
    }

    /**
     * 重新加载
     */
    private void reload() {
        //清除一下，然后解析url文件
        providers.clear();
        providersName.clear();
        parse();
    }

    /**
     * 解析文件内容
     */
    private void parse() {
        //加载远程的或者当前的url
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(getUrlInfo()));
            String line=null;
            while ((line=bufferedReader.readLine())!=null) {
                providersName.add(line);
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 获取路径文件的资源
     * @return
     * @throws IOException
     */
    private InputStream getUrlInfo() throws IOException {
        //如果不是http开头的，那么是类文件路径啦～
        if (!prefix.startsWith("http")) {
            return getClass().getClassLoader().getResource(prefix + service.getName()).openStream();

        }
        // TODO 区分本地机器文件
        URL url = new URL(prefix + service.getName());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5 * 1000);
        InputStream inStream = conn.getInputStream();
        return inStream;

    }


    /**
     * 实例化变量
     *
     * @param providersName
     * @param providers
     * @param sClass
     */
    private void instanceClass(HashSet<String> providersName, LinkedHashMap<String, S> providers, Class<S> sClass) {
        for (String className : providersName) {
            Class c = null;
            Object instance = null;
            try {
                c = Class.forName(className);
                instance = c.newInstance();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }

            //转化类对象
            S s = sClass.cast(instance);
            providers.put(className, s);
        }
    }

}
