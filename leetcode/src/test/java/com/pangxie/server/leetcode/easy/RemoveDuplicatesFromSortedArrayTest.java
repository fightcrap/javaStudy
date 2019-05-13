package com.pangxie.server.leetcode.easy;

import com.pangxie.server.leetcode.easy.removeduplicatesfromsortedarray.RemoveDuplicatesFromSortedArrayV1;
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
 * | RemoveDuplicatesFromSortedArray
 * |
 * | @author fightingcrap
 **/
public class RemoveDuplicatesFromSortedArrayTest {

    @Test
    public void test() {
        int[] test1 = new int[]{1, 1, 2};
        int[] test2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        RemoveDuplicatesFromSortedArrayV1 removeDuplicatesFromSortedArrayV1 = new RemoveDuplicatesFromSortedArrayV1();
        Assert.assertEquals(removeDuplicatesFromSortedArrayV1.removeDuplicates(test1), 2);
        Assert.assertEquals(removeDuplicatesFromSortedArrayV1.removeDuplicates(test2), 5);

    }
}
