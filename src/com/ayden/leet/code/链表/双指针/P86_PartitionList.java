//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
//
// Related Topics 链表 双指针 👍 796 👎 0


package com.ayden.leet.code.链表.双指针;

public class P86_PartitionList {
    public static void main(String[] args) {
        Solution solution = new P86_PartitionList().new Solution();
    }
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
        public ListNode partition(ListNode head, int x) {
            // 只要是考双指针，这里定义两个指针，分别存放较小值跟较大值
            // 最终较小值链表+较大值链表即需要的结果
            ListNode smaller = new ListNode();
            ListNode min = smaller;

            ListNode greater = new ListNode();
            ListNode max = greater;
            while (head != null) {
                // 如果值较大，则放入较大的链表中
                if (head.val >= x) {
                    max.next = head;
                    max = max.next; // max = head;
                } else {
                    min.next = head;
                    min = min.next;
                }

                // 这里清空下一个指针，避免计算的时候指针错乱了
                ListNode temp = head.next;
                head.next = null;
                head = temp;
            }

            min.next = greater.next;
            return smaller.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}