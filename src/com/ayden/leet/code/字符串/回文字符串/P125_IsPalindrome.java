//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
//
// 字母和数字都属于字母数字字符。
//
// 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入: s = "A man, a plan, a canal: Panama"
//输出：true
//解释："amanaplanacanalpanama" 是回文串。
//
//
// 示例 2：
//
//
//输入：s = "race a car"
//输出：false
//解释："raceacar" 不是回文串。
//
//
// 示例 3：
//
//
//输入：s = " "
//输出：true
//解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
//由于空字符串正着反着读都一样，所以是回文串。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 2 * 10⁵
// s 仅由可打印的 ASCII 字符组成
//
//
// Related Topics 双指针 字符串 👍 721 👎 0

package com.ayden.leet.code.字符串.回文字符串;

/**
 * P125_IsPalindrome
 *
 * @author: xwq
 * @Date: 2023-12-13
 * @description:
 **/
public class P125_IsPalindrome {

    public static void main(String[] args) {
        String s = "race a car";
        P125_IsPalindrome p125_isPalindrome = new P125_IsPalindrome();
        System.out.println(p125_isPalindrome.isPalindrome(s));
    }


    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isLetterOrDigit(c)) {
                builder.append(Character.toLowerCase(c));
            }
        }

        s = builder.toString();
        if (s.isEmpty()) {
            return true;
        }

        // 回文判断，左右相等，或者中间开始计算到左右两边都一致，为了不考虑长度是奇数还是偶数问题直接两边开始
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
