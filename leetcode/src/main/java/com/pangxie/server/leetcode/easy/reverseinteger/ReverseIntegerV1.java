package com.pangxie.server.leetcode.easy.reverseinteger;

/**
 * Create By fightingcrap On 2019/05/06
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
 * | ReverseInteger
 * |
 * | @author fightingcrap
 **/
public class ReverseIntegerV1 {

    public int reverse(int x) {
        //首先把0特殊去掉
        if (x == 0) {
            return 0;
        }
        //如果是负数，则变化成正数
        int temp = x;
        boolean isMinus = false;
        if (x < 0) {
            temp = -temp;
            isMinus = true;
        }
        //翻转,
        StringBuilder stringBuilder = new StringBuilder(temp+"").reverse();
        //除去前面的0
        int zoreCount = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '0') {
                zoreCount++;
            } else {
                break;

            }
        }
        if(zoreCount>0){
            stringBuilder.delete(0,zoreCount);
        }
        try{
            return Integer.valueOf(isMinus?"-"+stringBuilder.toString():stringBuilder.toString());
        }catch (Exception e){
            return 0;
        }


    }
}
