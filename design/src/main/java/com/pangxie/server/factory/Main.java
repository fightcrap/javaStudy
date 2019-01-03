package com.pangxie.server.factory;

import com.pangxie.server.factory.surname.ZhaoSurname;
import com.pangxie.server.factory.surname.ZhengSurname;

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
 * | Main
 * |
 * | @author fightingcrap
 **/
public class Main {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        AbsrractFactory absrractFactory=new NameFactiry();
        absrractFactory.buildName(ZhengSurname.class);
        absrractFactory.buildName(ZhaoSurname.class);
    }
}
