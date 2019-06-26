# LeetCode 集锦（三十三） - 第 125 题 Valid Palindrome

## 问题

```
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases. 

 Note: For the purpose of this problem, we define empty string as valid palindrome. 

 Example 1: 


Input: "A man, a plan, a canal: Panama"
Output: true


 Example 2: 

Input: "race a car"
Output: false
```

### 翻译:
> 给定一个字符串，判断它是否是回文，只考虑字母数字字符而忽略大小写。
> 注意:为了解决这个问题，我们将空字符串定义为有效的回文。
> 示例1:
> 输入:“A man, a plan, a canal: Panama”
> 输出:true
> 示例2:
> 输入:“race a car”
> 输出:false
---

## 解题思路

本题是判断一个字符串是否是回文，之前就也做过类似，但是不同的是，这边需要移除非数字和字母的字符，并且不区分大小写来判断是否回文，所以这边利用遍历的方式可以进行解题

## 解题方法

1. 按照思路来编写结果

   ```
   public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        int equals = 'a' - 'A';

        int index = 0;
        int end = s.length() - 1;
        while (index < end) {
            char left = getLowerChar(s.charAt(index));
            if (!isUseFullChar(left)) {
                index++;
                continue;
            }
            char right = getLowerChar(s.charAt(end));
            if (!isUseFullChar(right)) {
                end--;
                continue;
            }

            int temp = left - right;
            if (temp == 0 || temp == equals || temp == -equals) {
                index++;
                end--;
                continue;
            }
            return false;

        }
        return true;

    }

    private static boolean isUseFullChar(char c) {

        return (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z');
    }

    private static char getLowerChar(char c) {

        if (c >= 'A' && c <= 'Z') {
            return (char) (c - 'A'+'a');
        }
        return c;
    }
   ```

   **时间复杂度**:
   该方案用了双向遍历的方式，但是还是遍历n，所以为O(n)=O(n)

   **空间复杂度**:
   该方案并没有使用额外空间来遍历，所以空间复杂度O(n)=O(1)


## 总结

本题的大致解法如上所诉，本题没有多余的复杂性，就是要多出很多判断，过滤条件

[欢迎关注我的博客-FightCrap](https://fightcrap.github.io/)
