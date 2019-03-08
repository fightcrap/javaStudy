package com.pangxie.server;

import static org.junit.Assert.assertTrue;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.pangxie.server.dubbo.dubbo.spi.api.SayWord;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public  void main() {
        ExtensionLoader<SayWord> loader = ExtensionLoader.getExtensionLoader(SayWord.class);
        SayWord sayWord=loader.getAdaptiveExtension();
        URL url = URL.valueOf("test://localhost/test?.saySomething=cn");
        System.out.println(sayWord.saySomething("d", url));
    }
}
