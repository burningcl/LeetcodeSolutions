package com.skyline.leetcode.solution;

/**
 * Plus One Linked List
 * https://leetcode.com/problems/plus-one-linked-list/?tab=Description
 * Created by chenliang on 2017/2/28.
 */
public class Q369 {

    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        ListNode p = null;
        while (cur != null) {
            if (cur.val < 9) {
                p = cur;
            }
            cur = cur.next;
        }

        if (p == null) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            cur = head;
            while (cur != null) {
                cur.val = 0;
                cur = cur.next;
            }
            return newHead;
        }

        p.val += 1;
        cur = p.next;
        while (cur != null) {
            cur.val = 0;
            cur = cur.next;
        }
        return head;
    }

}
