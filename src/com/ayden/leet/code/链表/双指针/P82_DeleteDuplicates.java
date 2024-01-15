//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
//
//
// 示例 2：
//
//
//输入：head = [1,1,1,2,3]
//输出：[2,3]
//
//
//
//
// 提示：
//
//
// 链表中节点数目在范围 [0, 300] 内
// -100 <= Node.val <= 100
// 题目数据保证链表已经按升序 排列
//
//
// Related Topics 链表 双指针 👍 1258 👎 0
package com.ayden.leet.code.链表.双指针;
/**
 * P82_DeleteDuplicates
 *
 * @author: xwq
 * @Date: 2024-01-15
 * @description:
 **/
public class P82_DeleteDuplicates {

    public static void main(String[] args) {

    }

    /**
     * 双指针的应用
     *
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return head;
        }

        // 虚拟头结点
        ListNode dummy = new ListNode(0, head);

        ListNode cur = dummy;

        // 由于如果本节点跟下一个节点值一致则需要删除本节点跟下一个节点
        // 因此这里需要判断next跟next的next避免边缘问题
        while (cur.next != null && cur.next.next != null) {
            // 如果本节点跟下一个节点相等则一直往后找直到不相等为止
            if(cur.next.val == cur.next.next.val) {
                // 记录本次相同的节点值
                int tmp = cur.next.val;
                // 一直移动节点,需要剔除相同的节点，包括自己
                while (cur.next != null && cur.next.val == tmp) {
                    cur.next = cur.next.next;
                }
            } else {
                // 不相等则直接移动
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
