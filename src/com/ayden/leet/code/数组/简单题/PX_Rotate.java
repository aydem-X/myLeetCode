/**
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *  
 * <p>
 * 进阶：
 * <p>
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 **/
package com.ayden.leet.code.数组.简单题;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * PX_Rotate
 *
 * @author: xwq
 * @Date: 2023-12-24
 * @description:
 **/
public class PX_Rotate {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        PX_Rotate px_rotate = new PX_Rotate();
        px_rotate.rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 旋转数组
     * 1 2 3 4 5为例，右移2为
     * 首先先从nums[0]即1开始，tmp = 1,1需要放在3的位置，并将tmp=3：
     * 1 2 1 4 5
     * 此时再找3应该放的位置为5，将3放在5，并将tmp=5：
     * 1 2 1 4 3
     * 再找5应该放的位置为2，将5放在2，并将tmp=2:
     * 1 5 1 4 3
     * 找2应该放的位置为4，将2放在4，并将tmp=4:
     * 1 5 1 2 3
     * 找4应该方位位置为1,将4放在1，并将tmp=1:
     * 4 5 1 2 3
     * 此时又回到了1，则应该继续找num[1]
     * 如此往复。
     *
     * 由于这个例子特殊一次遍历交换就已经所有节点都移动过一次了，因此计算结束。
     * 整体的思路：先从0开始，tmp置为nums[0]的值，而后找nums[0]应放的位置p=(0+k)%nums.len
     * 将tmp改为nums[p]的值，将原来tmp的值放在nums[p]中，然后再找现在的tmp应放的位置。如此往复，
     * 直到p回到原点后，再从nums[1]开始继续交换操作。
     * 结束条件：交换的次数==nums.len(即每个元素都成功移动到对应的位置中)
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (k == 0 || nums == null || nums.length == 1) {
            return;
        }
        int swapCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int p = i;
            int temp = nums[i];
            do {
                p = (p + k) % nums.length;
                int swap = nums[p];
                nums[p] = temp;
                temp = swap;
                swapCount++;
            } while (p != i);
            if (swapCount == nums.length) {
                return;
            }
        }
    }
}
