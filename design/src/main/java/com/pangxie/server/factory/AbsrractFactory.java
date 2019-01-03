package com.pangxie.server.factory;



import com.pangxie.server.factory.surname.SurnameInterface;

import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * Create By fightingcrap On 2019/01/02
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
 * | AbsrractFactory --定义一个工厂类
 * |
 * | @author fightingcrap
 **/
public abstract class AbsrractFactory {

    abstract String buildName(Class<? extends SurnameInterface> clas) throws IllegalAccessException, InstantiationException;

     public static String getChinese() {
        String str = null;
        int highPos, lowPos;
        Random random = new Random();
         //区码，0xA0打头，从第16区开始，即0xB0=11*16=176,16~55一级汉字，56~87二级汉字
        highPos = (176 + Math.abs(random.nextInt(71)));
        random=new Random();
         //位码，0xA0打头，范围第1~94列
        lowPos = 161 + Math.abs(random.nextInt(94));

        byte[] bArr = new byte[2];
        bArr[0] = (new Integer(highPos)).byteValue();
        bArr[1] = (new Integer(lowPos)).byteValue();
        try {
            //区位码组合成汉字
            str = new String(bArr, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

}
