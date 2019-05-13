package com.pangxie.server.leetcode.easy;

import com.pangxie.server.leetcode.easy.removeelement.RemoveElementV1;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create By fightingcrap On 2019/05/13
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
 * | RemoveElementTest
 * |
 * | @author fightingcrap
 **/
public class RemoveElementTest {

    @Test
    public void test() {

        int[] test1 = new int[]{3, 2, 2, 3};
        int[] test2 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};

        RemoveElementV1 removeElementV1 = new RemoveElementV1();
        Assert.assertEquals(removeElementV1.removeElement(test1,2),2);
        Assert.assertEquals(removeElementV1.removeElement(test2,2),5);
    }
}
