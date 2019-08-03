# LeetCode 集锦（三十八） - 第 167 题 two sum II -input array is sorted

## 问题

```
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time. 

 push(x) -- Push element x onto stack. 
 pop() -- Removes the element on top of the stack. 
 top() -- Get the top element. 
 getMin() -- Retrieve the minimum element in the stack. 

 Example: 

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

```

### 翻译:
>设计一个栈，支持push、pop、top和在常量时间内检索最小元素。  
>push(x)——将元素x推入堆栈。  
>pop()——删除堆栈顶部的元素。  
>top()——获取top元素。  
>getMin()——检索堆栈中的最小元素。  
>例子:  
>MinStack = new MinStack();  
>minStack.push (2);  
>minStack.push (0);  
>minStack.push (3);  
>minStack.getMin ();- - >返回3。  
>minStack.pop ();  
>minStack.top ();- - >返回0。  
>minStack.getMin ();- - >返回2。  
---

## 解题思路

本题是编写一个栈，但是对于栈的功能而言，多一个查询里面最小值的方法。栈的特点在于先进后出，我们可以用链表来实现。但是要获取最小值，
1. 第一想到的就是可以通过遍历的方式来获取最小值，每次新进来一个对比一下就好。但是该方式在pop的时候就要重新定位最小值，还是比较耗性能的。
2. 由于栈的特性，早先进去的值不会先被pop掉，所以在新增一个值，判断出最小值的时候，就是这一栈中最小的，即便被pop掉了，下一个节点的最小值是前面入栈中最小值，所以我们可以把最小值存入节点中。这样做就不需要遍历了

## 解题方法

1. 按照遍历的方式：

   ```
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
   ```

   **时间复杂度**:
   该方案用中，每一次的pop方式都需要遍历，所以为O(n)=O(n)

   **空间复杂度**:
   无

2. 链表的方式实现：

   ```
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
   ```

   **时间复杂度**:
   该方案用中，每一次的pop方式都需要遍历，所以为O(n)=O(1)

   **空间复杂度**:
   无

## 总结

本题的大致解法如上所诉，熟悉数据结构的特点，才能更好的编写代码。利用栈的先进后出保证前面的最小值不会因为pop而变化，如果是队列，那就不能用这种方式了。

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
