package com.pangxie.server.leetcode.easy.besttimetobuyandsellstock;

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
 * | BestTimeToBuyAndSellStockV1
 * |
 * | @author fightingcrap
 **/
public class BestTimeToBuyAndSellStockV1 {

    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int m = i + 1; m < prices.length; m++) {
                result = Math.max(prices[m] - prices[i], result);
            }
        }

        return result;
    }
}
