package com.pangxie.server.leetcode.easy.besttimetobuyandsellstockII;

/**
 * Create By fightingcrap On 2019/06/25
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
 * | BestTimeToBuyAndSellStockIIV1
 * |
 * | @author fightingcrap
 **/
public class BestTimeToBuyAndSellStockIIV1 {

    public int maxProfit(int[] prices) {
        if(prices.length<=0){
            return 0;
        }
        int result = 0;
        int temp = prices[0];
        int index = 0;

        for (int i = 1; i < prices.length; i++) {

            index = Math.max(prices[i] - temp, index);
            if (prices[i] < prices[i - 1]) {
                result += index;
                temp = prices[i];
                index = 0;
            }
        }

        return result+index;

    }
}
