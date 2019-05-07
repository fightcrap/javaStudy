package com.pangxie.server.leetcode.easy.palindromenumber;

/**
 * Create By fightingcrap On 2019/05/07
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
 * | PalindromeNumberV1 -- 回文数字，对应leetcode第9题。测试见test文件
 * |
 * | @author fightingcrap
 **/
public class PalindromeNumberV1 {

    public boolean isPalindrome(int x) {
        //负数直接不符合要求
        if (x < 0) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder(x + "");
        return stringBuilder.toString().equals(stringBuilder.reverse().toString());
    }
}
