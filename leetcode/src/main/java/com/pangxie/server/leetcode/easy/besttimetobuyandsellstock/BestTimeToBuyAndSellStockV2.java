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
 * | BestTimeToBuyAndSellStockV2
 * |
 * | @author fightingcrap
 **/
public class BestTimeToBuyAndSellStockV2 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        int temp = prices[0];
        int result = 0;
        for (int i = 1; i < prices.length; i++) {

            result = Math.max(prices[i] - temp, result);

            if (prices[i] < temp) {
                temp = prices[i];
            }
        }
        return result;
    }
}
