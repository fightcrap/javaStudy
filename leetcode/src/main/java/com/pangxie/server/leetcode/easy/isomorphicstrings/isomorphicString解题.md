# LeetCode 集锦（五十） - 第 205 题 isomorphic string

## 问题

```
Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 Example 1:


Input: s = "egg", t = "add"
Output: true


 Example 2:


Input: s = "foo", t = "bar"
Output: false

 Example 3:


Input: s = "paper", t = "title"
Output: true

 Note:
You may assume both s and t have the same length.
```

### 翻译:
>给出两个字符串s和t，判断它们是否同构。  
>  
>如果可以将s中的字符替换为t，则两个字符串是同构的。  
>  
>所有出现的字符都必须替换为另一个字符，同时保留字符的顺序。没有两个字符可以映射到同一个字符，但是一个字符可以映射到它自己。  
>   
>示例1:  
>  
>输入:s = "egg"， t = "add"  
>输出:true  
> 示例2:  
>  
>输入:s = "foo"， t = "bar"  
>输出:false  
>  
>示例3:  
>  
>输入:s = "paper"， t = "title"  
>输出:true  
>注意:  
>你可以假设s和t的长度相等。  

---

## 解题思路

本题是判断两个string 是否结构相同，我们无非是记录两者字符的关系，并判断是否出现过，就能解决结构问题

## 解题方法

1. 按照思路来：

   ```
   if (s.length() != t.length()) {
               return false;
           }
           Map<Character, Character> map = new HashMap<>();
   
           for (int i = 0; i < s.length(); i++) {
               char c = s.charAt(i);
               char tc = t.charAt(i);
               if (!map.containsKey(c) && !map.containsValue(tc)) {
                   map.put(c, tc);
                   continue;
               }
               if (!Objects.equals(map.get(c), tc)) {
                   return false;
               }
           }
           return true;
   ```

   **时间复杂度**:
   本方案中使用了循环n次，所以时间复杂度为O(n)

   **空间复杂度**:
   该方案中了map标记，所以空间复杂度是O(n)

## 总结

本题的大致解法如上所诉。

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
