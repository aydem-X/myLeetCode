//给你一个整数数组 nums ，请计算数组的 中心下标 。
//
// 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
//
// 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
//
// 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1, 7, 3, 6, 5, 6]
//输出：3
//解释：
//中心下标是 3 。
//左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
//右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
//
//
// 示例 2：
//
//
//输入：nums = [1, 2, 3]
//输出：-1
//解释：
//数组中不存在满足此条件的中心下标。
//
// 示例 3：
//
//
//输入：nums = [2, 1, -1]
//输出：0
//解释：
//中心下标是 0 。
//左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
//右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// -1000 <= nums[i] <= 1000
//
//
//
//
// 注意：本题与主站 1991 题相同：https://leetcode-cn.com/problems/find-the-middle-index-in-
//array/
//
// Related Topics 数组 前缀和 👍 601 👎 0

package com.ayden.leet.code.数组.前缀和;

/**
 * P726_FindPivotIndex
 *
 * @author: xwq
 * @Date: 2024-01-06
 * @description:
 **/
public class P726_FindPivotIndex {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 3, 6, 5, 6};
        P726_FindPivotIndex p726_findPivotIndex = new P726_FindPivotIndex();
        System.out.println(p726_findPivotIndex.pivotIndex(nums));
    }

    /**
     * 找前后和相等的中间点：
     * 方法一：暴力解法
     * 中点位置从1开始，计算前缀跟后缀的和是否一致。依次遍历直到找到前后缀一致的；
     *
     * 方法二：
     * 需要明确的是，如果存在此类数组结构，那么整个数组的总和应该是：前缀+后缀+中间点
     * 即总和为：2*前缀+中间点
     * 因此，只要计算出总和，然后找到满足：`总和 - 前缀和 - 中间点 = 前缀` 这个条件
     * 的中间点，所以只要计算前缀即可找到中间点。
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        if (nums == null) {
            return -1;
        }
        if(nums.length == 1){
            return 0;
        }

        int count = 0;
        for (int num : nums) {
            count += num;
        }

        int preCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (preCount == count - nums[i] - preCount) {
                return i;
            }
            preCount += nums[i];
        }
        return -1;
    }
}
