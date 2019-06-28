package com.pangxie.server.leetcode.easy.minstack;

import java.util.ArrayList;
import java.util.List;

/**
 * Create By fightingcrap On 2019/06/28
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
 * | MinStackV1
 * |
 * | @author fightingcrap
 **/
public class MinStackV1 {

    class MinStack {

        private List<Integer> list = new ArrayList<>();

        private Integer min = Integer.MAX_VALUE;

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            list.add(x);
            if (x < min) {
                min = x;
            }

        }

        public void pop() {
            if (list.size() <= 0) {
                return;
            }
            Integer integer = list.remove(list.size() - 1);
            if (integer.equals(min)) {
                //重新遍历获取最小值
                int min = Integer.MAX_VALUE;
                for (Integer integer1 : list) {
                    if (min > integer1) {
                        min = integer1;
                    }
                }
                this.min = min;
            }

        }

        public int top() {
            if (list.size() <= 0) {
                return 0;
            }
            return list.get(list.size() - 1);
        }

        public int getMin() {
            return min;
        }
    }
}
