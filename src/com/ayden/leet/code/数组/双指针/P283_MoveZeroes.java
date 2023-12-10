package com.ayden.leet.code.数组.双指针;//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1,0,3,12]
//输出: [1,3,12,0,0]
// 
//
// 示例 2: 
//
// 
//输入: nums = [0]
//输出: [0] 
//
// 
//
// 提示: 
// 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能尽量减少完成的操作次数吗？ 
//
// Related Topics 数组 双指针 👍 2255 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class P283_MoveZeroes {
    /**
     * 1.双指针,一个放开头,一个放结尾,移动结尾的元素,如果遇到非0的则把左边的元素跟右边的交换,并左移开头指针
     * ,若右边的指针遇到0则往左移动指针,直到左右指针相遇
     *
     * 2.双指针,两个指针都放开头,则p负责移动,当遇到非0时就与p1交换,同时p与p1加都移动一位,这样得到的最终结果
     * 就是符合题目要求的.
     *
     * 方法1的方式可能交换次数会比方法2的交换次数少一点.但是方法1不满足题目要求,因为要保证相对顺序
     * 因此采用方法2
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                slow++;
            }
        }
    }


    public void method1(int[] nums) {
        int left = 0;
        int right = nums.length;

        while (left != right) {
            if (nums[right] == 0) {
                right--;
            } else {
                swap(nums, left, right);
                left++;
            }
        }
    }

    public void swap(int[] nums, int index, int target) {
        int tmp = nums[index];
        nums[index] = nums[target];
        nums[target] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
