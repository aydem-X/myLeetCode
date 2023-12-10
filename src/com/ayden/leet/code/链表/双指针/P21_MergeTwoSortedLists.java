//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 2803 👎 0


package com.ayden.leet.code.链表.双指针;

/**
 * merge-two-sorted-lists
 *
 * @Id 21
 * @date 2022-11-23 16:41:56
 */
class P21_MergeTwoSortedLists {
    public static void main(String[] args) {
        //测试代码
        Solution solution = new P21_MergeTwoSortedLists().new Solution();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
//
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        //public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //	if (list1 == null || list2 == null) {
        //		return list1 == null ? list2 : list1;
        //	}
        //	// 先得到根节点
        //	ListNode root = list1.val <= list2.val ? list1 : list2;
        //
        //	ListNode prev = null;
        //	while (true) {
        //		// 以list1为基准，将list2添加到list1中
        //		if (list1.val >= list2.val) {
        //			ListNode temp = list2.next;
        //			list2.next = list1;
        //			if (prev != null) {
        //				prev.next = list2;
        //				// prev先后移，预防list1.val = list2.val的情况
        //				prev = prev.next;
        //			}
        //			if (temp == null) {
        //				// list2向后移动，如果后一位为空，则可以直接返回了
        //				break;
        //			}
        //			list2 = temp;
        //		} else {
        //			prev = list1;
        //			ListNode next = list1.next;
        //			if (next == null) {
        //				list1.next = list2;
        //				break;
        //			}
        //			list1 = list1.next;
        //		}
        //	}
        //	return root;
        //}
        //}

        /**
         * 优化写法
         *
         * @param list1
         * @param list2
         * @return
         */
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null && list2 == null) {
                return null;
            }

            ListNode root = new ListNode();

            ListNode prev = root;
            while (list1 != null && list2 != null) {
                // 以list1为准
                if (list1.val >= list2.val) {
                    prev.next = list2;
                    list2 = list2.next;
                } else {
                    prev.next = list1;
                    list1 = list1.next;
                }
                prev = prev.next;
            }
            prev.next = list1 == null ? list2 : list1;

            return root.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
