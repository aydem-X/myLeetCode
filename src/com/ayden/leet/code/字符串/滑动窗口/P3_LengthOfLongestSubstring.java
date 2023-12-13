//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 字符串 滑动窗口
// 👍 7868 👎 0

package com.ayden.leet.code.字符串.滑动窗口;

import java.util.HashMap;
import java.util.Map;

/**
 * P3_LengthOfLongestSubstring
 *
 * @author: xwq
 * @Date: 2023-12-12
 * @description:
 **/
public class P3_LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "abba";
        P3_LengthOfLongestSubstring p = new P3_LengthOfLongestSubstring();
        System.out.println(p.lengthOfLongestSubstring(s));
        System.out.println(p.lengthOfLongestSubstringWithMap(s));
    }

    /**
     * 暴力算法
     * 不依赖散列表
     * <p>
     * 类似滑动窗口，i遍历整个数组，start记录为不重复字符的起始位置，当遇到字符重复的时候，
     * 则重置start为遇到这个字符的下一个index,计算此时的长度，与已有的长度最大值比较取较大者
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }

        int length = 0;

        int start = 0;
        for (int i = 1; i < s.length(); i++) {

            char currentChar = s.charAt(i);

            int subLength = 1;
            for (int j = start; j < i; j++) {
                if (s.charAt(j) == currentChar) {
                    start = j + 1;
                    subLength = (i - start + 1);
                    break;
                }
                subLength++;
            }
            length = Math.max(length, subLength);
        }

        return length;
    }


    /**
     * 使用hashMap优化,用map存储字符跟其下标，遇到一样的后再调整下标，逻辑跟暴力算法的是一样的
     * 滑动窗口+hashMap
     *
     * a b b a滑动窗示例：
     *
     * [a] b b a
     * [a b] b a
     * a b [b] a
     * a b [b a]
     * 最长为2
     *
     * p w w k e w 滑动窗口示例：
     * [p] w w k e w
     * [p w] w k e w
     * p w [w] k e w
     * p w [w k] e w
     * p w [w k e] w
     * p w w [k e w]
     * 最长为3
     */
    public int lengthOfLongestSubstringWithMap(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int length = 0;
        int start = 0;

        Map<Character, Integer> keys = new HashMap<>(s.length(), 1);

        for (int i = 0; i < s.length(); i++) {

            char currentChar = s.charAt(i);
            // 如果包含这个key则说明这个子串要变成在这个重复节点的下一个下标开始一直到当前节点的位置
            if (keys.containsKey(currentChar)) {
                // 这里要注意，如果重复的字符位置比start位置还小，则这个字符是不作数的
                // abba,start已经到2了，最后一个a的时候keys.get(a)是0，这个a是不作数的
                Integer index = keys.get(currentChar);
                if (index >= start) {
                    start = index + 1;
                }
            }
            length = Math.max(length, i - start + 1);
            keys.put(currentChar, i);
        }

        return length;
    }
}
