//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母组成
//
//
// Related Topics 字符串 动态规划 👍 6966 👎 0

package com.ayden.leet.code.字符串.回文字符串;

/**
 * P5_LongestPalindromicSubstring
 *
 * @author: xwq
 * @Date: 2023-12-13
 * @description:
 **/
public class P5_LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "cbbd";
        P5_LongestPalindromicSubstring p = new P5_LongestPalindromicSubstring();
        System.out.println(p.longestPalindrome(s));
    }

    /**
     * 寻找最长回文子串的问题
     * 回文串双指针方式：
     * 1. 两个指针左右相向而行，左右字符一直相等则认定为回文串
     * 2. 两个指针从字符串中间相背而行，左右一直相等则认定为回文串
     * <p>
     * 本题思路：找中间点，从中间点相背而行。中间点需要考虑回文串是奇数还是偶数的情况
     * a b b a  --> 中间点：1 2
     * a b a  --> 中间点：1
     * <p>
     * 遍历整个字符串，把每个节点都认为是中间节点。而这个节点可以是奇数的节点，也可以是偶数的节点
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String maxPalindromeStr = "";
        for (int i = 0; i < s.length(); i++) {
            String str1 = palindromicLen(s, i, i);
            String str2 = palindromicLen(s, i, i + 1);

            maxPalindromeStr = maxPalindromeStr.length() > str1.length() ? maxPalindromeStr : str1;
            maxPalindromeStr = maxPalindromeStr.length() > str2.length() ? maxPalindromeStr : str2;
        }
        return maxPalindromeStr;
    }

    /**
     * 从中间节点计算回文串的长度
     *
     * @param s
     * @param left
     * @param right
     * @return
     */
    public String palindromicLen(String s, int left, int right) {
        int start = 0;
        int end = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            start = left--;
            end = right++;
        }
        return s.substring(start, end + 1);
    }
}
