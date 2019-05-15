package com.pangxie.server.leetcode.easy;

import com.pangxie.server.leetcode.easy.searchinsertposition.SearchInsertPositionV1;
import com.pangxie.server.leetcode.easy.searchinsertposition.SearchInsertPositionV2;
import com.pangxie.server.leetcode.easy.searchinsertposition.SearchInsertPositionV3;
import org.junit.Assert;
import org.junit.Test;

/**
 * Create By fightingcrap On 2019/05/15
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
 * | SearchInsertPositionTest
 * |
 * | @author fightingcrap
 **/
public class SearchInsertPositionTest {

    @Test
    public void test(){

        int[] test1=new int[]{1,3,5,6};

        SearchInsertPositionV1 searchInsertPositionV1=new SearchInsertPositionV1();

        Assert.assertEquals(searchInsertPositionV1.searchInsert(test1,5),2);
        Assert.assertEquals(searchInsertPositionV1.searchInsert(test1,2),1);
        Assert.assertEquals(searchInsertPositionV1.searchInsert(test1,7),4);
        Assert.assertEquals(searchInsertPositionV1.searchInsert(test1,0),0);

        SearchInsertPositionV2 searchInsertPositionV2=new SearchInsertPositionV2();

        Assert.assertEquals(searchInsertPositionV2.searchInsert(test1,5),2);
        Assert.assertEquals(searchInsertPositionV2.searchInsert(test1,2),1);
        Assert.assertEquals(searchInsertPositionV2.searchInsert(test1,7),4);
        Assert.assertEquals(searchInsertPositionV2.searchInsert(test1,0),0);

        SearchInsertPositionV3 searchInsertPositionV3=new SearchInsertPositionV3();

        Assert.assertEquals(searchInsertPositionV3.searchInsert(test1,5),2);
        Assert.assertEquals(searchInsertPositionV3.searchInsert(test1,2),1);
        Assert.assertEquals(searchInsertPositionV3.searchInsert(test1,7),4);
        Assert.assertEquals(searchInsertPositionV3.searchInsert(test1,0),0);
    }
}
