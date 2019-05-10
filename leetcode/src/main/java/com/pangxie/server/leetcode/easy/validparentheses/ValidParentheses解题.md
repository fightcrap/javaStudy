# LeetCode集锦（六） - 第20题 Valid Parentheses

## 问题

```
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid. 

 An input string is valid if: 


 Open brackets must be closed by the same type of brackets. 
 Open brackets must be closed in the correct order. 


 Note that an empty string is also considered valid. 

Example 1: 
    Input: "()"
    Output: true

Example 2: 
    Input: "()[]{}"
    Output: true

Example 3: 
    Input: "(]"
    Output: false

Example 4: 
    Input: "([)]"
    Output: false

Example 5: 
    Input: "{[]}"
    Output: true
```
### 翻译:

> 给定一个只包含字符'('，')'，'{'，'}'，'['和']'的字符串，判断输入字符串是否有效。  
> 输入字符串在下列情况下有效:  
> 1. 开括号必须由相同类型的括号关闭。  
> 2. 开括号必须按正确的顺序关闭。  
> 3. 注意，空字符串也被认为是有效的。  
> 
> 示例1:  
> 输入:“()”  
> 输出:true  
> 示例2:  
> 输入:“()(){}”  
> 输出:true  
> 示例3:  
> 输入:“()”  
> 输出:false  
> 示例4:  
> 输入:“(())”  
> 输出:false  
> 例5:  
> 输入:“{[]}”  
> 输出:true  
---
## 解题思路
本题思路很简单，如果左开符号(类似：(,{,[等),那么不管，或者把对应的压入栈，如果遇到右开，则需要判断离他最近的左开符号是否能成对，不能返回失败，如果能则需要去除，避免下一个判断的影响。
这边提供两类思路方案：  
方案一：不使用额外空间，只用当前数组，我们遇到右开符号，就要向前进行遍历，遇到第一个不为空的字符，判断是否能成对，如果能则继续，不能返回false。如果最终数组都是空字符串，那么符合要求，返回true，不然返回false。

方案二：使用stack数据结构，把左开符号压入栈中，遇到右开符号，则拿出栈，pop一个，判断是否能成对，如果能则继续，不能返回false，如果最终栈是空的，返回true，否则返回false。

## 解题方法
1. 第一种解体方法，按照我们的思路来编辑，代码如下
    ```
        public boolean isValid(String s) {

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char indexItem = chars[i];
            char temp = ' ';
            switch (indexItem) {
                case ']':
                    temp = '[';
                    break;
                case '}':
                    temp = '{';
                    break;
                case ')':
                    temp = '(';
                    break;
                default:
                    temp = ' ';
            }
            if (temp != ' ' && !find(chars, i, temp)) {
                return false;
            }
        }
        return String.valueOf(chars).trim().length() == 0;
    }

    private boolean find(char[] chars, int lastIndex, char target) {

        for (int i = lastIndex - 1; i >= 0; i--) {
            char temp = chars[i];
            if (temp == ' ' || temp == ')' || temp == ']' || temp == '}') {
                continue;
            }
            if (chars[i] != target) {
                return false;
            }
            //两者滞空，
            chars[i] = ' ';
            chars[lastIndex] = ' ';
            return true;
        }
        return false;
    }
    ```
    __时间复杂度__:
    该方案用了循环，循环层数为2(算上向前遍历)，由于第二层判断计数不好记，设为M,外层循环为n,所以f(n)=(n*M)=Mn;所以O(f(n))=O(Mn),即T(n)=O(n^2)

    __空间复杂度__:
    该方案没有使用额外的空间，所以空间复杂度是O(1);

2. 第二种解题方法，按照我们的思路来编辑，代码如下
    ```
    Stack<Character> stack = new Stack<>();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            char indexChar = s.charAt(i);
            switch (indexChar) {
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '(':
                    stack.push(')');
                    break;
                default:
                    if (stack.size() == 0) {
                        return false;
                    } else if (stack.pop() != indexChar) {
                        return false;
                    }
            }

        }
        return stack.size() == 0;
    ```
    __时间复杂度__:
    该方案用了循环，循环层数为1，循环为n,所以f(n)=(n)=n;所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案使用栈作为额外，额外的空间最坏的情况就是全部入栈，为n，所以空间复杂度是O(n);
3. 第三种解题方法，按照我们的思路来编辑，代码如下
    ```
    LinkedList<Character> linkedList=new LinkedList();
        int size = s.length();
        for (int i = 0; i < size; i++) {
            char indexChar = s.charAt(i);
            switch (indexChar) {
                case '{':
                    linkedList.addFirst('}');
                    break;
                case '[':
                    linkedList.addFirst(']');
                    break;
                case '(':
                    linkedList.addFirst(')');
                    break;
                default:
                    if (linkedList.size() == 0) {
                        return false;
                    } else if (linkedList.getFirst() != indexChar) {
                        return false;
                    }
                    linkedList.remove(0);
            }

        }

        return linkedList.size() == 0;
    ```
    __时间复杂度__:
    该方案用了循环，循环层数为1，循环为n,所以f(n)=(n)=n;所以O(f(n))=O(n),即T(n)=O(n)

    __空间复杂度__:
    该方案使用链表作为额外，额外的空间最坏的情况就是全部入链表，为n，所以空间复杂度是O(n);

## 总结
本题的大致解法如上所诉，本题两种思路，三种解题方式，第三种主要是选择的数据结构不同，java自带的Stack是继承Vector，是一个线程安全的，但是在本题不需要考虑安全性，所以加锁的开销是多余的，而且不能一开始就设置Stack的大小，在Vector中使用数组作为存储结构，所以当长度足够长，数组扩容时间和空间损耗会比较大，所以选用LinkedList，没有数组扩容的问题，可以随意增加和删除节点。没有必要线程安全，就没有加锁的额外开销了。