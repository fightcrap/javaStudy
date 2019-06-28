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
 * | MinStackV2
 * |
 * | @author fightingcrap
 **/
public class MinStackV2 {

    class MinStack {


        private Node indexNode;

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            Node node = new Node(x, x);

            if (indexNode != null) {
                //比较最小
                if (indexNode.min < x) {
                    node.setMin(indexNode.min);
                }
            }
            node.next = indexNode;
            indexNode = node;

        }

        public void pop() {
            indexNode = indexNode.next;

        }

        public int top() {
            return indexNode.var;

        }

        public int getMin() {
            return indexNode.min;
        }


    }

    protected class Node {
        private int var;

        private int min;

        private Node next;

        public Node(int var, int min) {
            this.var = var;
            this.min = min;
        }

        public int getVar() {
            return var;
        }

        public void setVar(int var) {
            this.var = var;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
