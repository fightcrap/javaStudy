# LeetCode集锦-medium（十） - 第17题 Letter Combinations Of A Phone Number

## 问题

```
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:

Input: "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
```
### 翻译:
>给定一个包含从2-9开始的数字的字符串，返回该数字可以表示的所有可能的字母组合。  
>下面给出了数字到字母的映射(就像电话按钮一样)。注意，1不映射到任何字母。  
> 例子:  
>输入:“23” 输出:["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].  
>注意:  
>尽管上面的答案是按字典顺序排列的，但你的答案可以是你想要的任何顺序。  
---
## 解题思路
本题本题题意是模拟我们手机的键盘位，根据输入的按键顺序，输出可能出现的字符集，明确的就是排列组合。可以用遍历的方式来实现。正常来说遍历一次就要在情况会多n倍，
但是又是需要依赖上一次循环的结果，我们可以把这个放在list里面，并更新。
## 解题方法
1. 按照题意方式
    ```
     private static String[] list = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
     
     
         public List<String> letterCombinations(String digits) {
             if (digits == null || digits.length() == 0) {
                 return new ArrayList<>();
             }
     
             List<String> result = new LinkedList<>();
             for (char c : digits.toCharArray()) {
                 int index = c - '2';
                 if (result.isEmpty()) {
                     insertAndReplace(result, list[index].toCharArray());
                     continue;
                 }
                 insertAndReplace(result, list[index].toCharArray());
     
     
             }
             return result;
     
         }
     
     
         private boolean insertAndReplace(List<String> list, char[] chars) {
     
             if (list.isEmpty()) {
                 for (char c1 : chars) {
                     list.add(c1 + "");
                 }
                 return true;
             }
             int len = list.size();
             for (int i = 0; i < len; i++) {
                 for (char s : chars) {
                     list.add(list.get(i) + s);
                 }
             }
             for (int i = 0; i < len; i++) {
                 list.remove(0);
             }
     
             return true;
     
         }
    ```
    __时间复杂度__:
    该方案用了n层循环，相当于遍历

    __空间复杂度__:
    该方案没有使用额外空间，O(f(n))=1


## 总结
本题的大致解法如上所诉,主要是要解决和上一层的依赖关系，这边采用新增在后边，并移除上一层关系的方式。


[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)