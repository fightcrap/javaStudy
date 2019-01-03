package com.pangxie.server.factory;


import com.pangxie.server.factory.surname.SurnameInterface;

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
 * | NameFactiry --姓名构建工厂
 * |
 * | @author fightingcrap
 **/
public class NameFactiry extends AbsrractFactory{


    @Override
    String buildName(Class<? extends SurnameInterface> clas) throws IllegalAccessException, InstantiationException {
        SurnameInterface surnameInterface=clas.newInstance();
        String surname=surnameInterface.getSurname();
        String name=surname+getChinese();
        System.out.println(name);
        return name;
    }
}
