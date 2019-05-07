package com.pangxie.server.leetcode.easy;

import com.pangxie.server.leetcode.easy.palindromenumber.PalindromeNumberV1;
import com.pangxie.server.leetcode.easy.palindromenumber.PalindromeNumberV2;
import org.junit.Assert;
import org.junit.Test;

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
 * | PalindromeNumberTest
 * |
 * | @author fightingcrap
 **/
public class PalindromeNumberTest {

    @Test
    public void test() {
        PalindromeNumberV1 palindromeNumberV1=new PalindromeNumberV1();
        Assert.assertTrue(palindromeNumberV1.isPalindrome(121));
        Assert.assertTrue(!palindromeNumberV1.isPalindrome(-3));

        PalindromeNumberV2 palindromeNumberV2=new PalindromeNumberV2();
        Assert.assertTrue(palindromeNumberV2.isPalindrome(121));
        Assert.assertTrue(!palindromeNumberV2.isPalindrome(-3));
    }
}
