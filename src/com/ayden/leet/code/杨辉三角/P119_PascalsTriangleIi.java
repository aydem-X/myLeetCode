//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
//
// Related Topics 数组 动态规划 👍 523 👎 0


package com.ayden.leet.code.杨辉三角;

import java.util.ArrayList;
import java.util.List;

public class P119_PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new P119_PascalsTriangleIi().new Solution();
        System.out.println(solution.getRow(5));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 按公式生成
         *          1
         *        1   1
         *      1   2   1
         *    1   3   3   1
         *  1   4   6   4   1
         *
         *  4:
         *  i = 1时， 1 * （4 - 1 + 1）/ 1 = 4
         *  i = 2时， 4 * (4 - 2 + 1) / 2 = 6
         * @param rowIndex
         * @return
         */
        public List<Integer> getRow(int rowIndex) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int i = 1; i <= rowIndex; ++i) {
                row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
            }
            return row;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}