# LeetCode集锦-medium（十三） - 第22题 Generate Parentheses 

## 问题

```
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```
### 翻译:
>给定一个链表，从链表的末尾删除第n个节点并返回它的头。  
>例子:  
>给定n对括号，编写一个函数来生成所有形式良好的括号组合。  
>例如，给定n = 3，解集为:  
>[
 ”((()))”,
 ”(()())”,
 ”(())()”,
 “()(())”,
 ”()()()”
] 
---
## 解题思路
本题题意是给定一个数字，给出有多少种闭合的（）组合，我们知道，这个是个排列组合的问题，每一个位置都是有两个选择（或者），但是这个需要是闭环，所以
在添加的时候需要关注前一个是否满足闭环，不能随便添加），所以需要依赖上一个组合，所以我们可以用遍历/递归的方式
## 解题方法
1. 遍历，依赖上一层的变化
    ```
      if (n <= 0) {
                 return new ArrayList<>();
             }
     
             List<String> result = new ArrayList<>(n * 2);
             result.add("(");
             for (int j = 1; j < n * 2; j++) {
                 int len = result.size();
                 for (int i = 0; i < len; i++) {
                     String value = result.get(i);
                     int count = 0;
                     int temp = 0;
                     for (char c : value.toCharArray()) {
                         if ('(' == c) {
                             count++;
                             temp++;
                         } else {
                             count--;
                         }
                     }
                     if (count!=0) {
                         result.add(value + ")");
                     }
                     if(temp<n){
                         result.add(value + "(");
                     }
                 }
                 result = result.subList(len, result.size());
             }
     
             return result;
    ```
    __时间复杂度__:
    该方案用了1层循环，相当于遍历，O(f(mn))=O(n);

    __空间复杂度__:
    该方案没有使用额外空间，O(f(n))=1
 
2. 递归调用，确保最后一层才保存
    ```
     public List<String> generateParenthesis(int n) {
     
             if (n <= 0) {
                 return new ArrayList<>();
             }
     
             List<String> result = new ArrayList<>(n * 2);
     
             addChar("(", 1, 0, n, result);
             return result;
         }
     
         private void addChar(String s, int left, int right, int n, List<String> list) {
             if (left == right && left == n) {
                 list.add(s);
             }
     
             if (left < n) {
                 addChar(s + "(", left + 1, right, n, list);
             }
             if (right < n && left > right) {
                 addChar(s + ")", left, right + 1, n, list);
             }
     
         }
    ```
    __时间复杂度__:
    该方案用了递归，;

    __空间复杂度__:
    该方案没有使用额外空间，O(f(n))=1


## 总结
本题的大致解法如上所诉,使用递归，或者遍历的方式来获取最终结果，按照规则来


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)