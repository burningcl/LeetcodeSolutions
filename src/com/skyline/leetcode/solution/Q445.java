package com.skyline.leetcode.solution;

import java.util.ArrayDeque;

/**
 * Add Two Numbers II
 * <p>
 * https://leetcode.com/problems/add-two-numbers-ii/
 * <p>
 * Created by jairus on 2016/12/29.
 */
public class Q445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;
        ListNode cur = null;
        int sum = 0;
        int add = 0;
        int v1 = 0;
        int v2 = 0;

        while (!stack1.isEmpty() || !stack2.isEmpty() || add > 0) {
            v1 = stack1.isEmpty() ? 0 : stack1.pop();
            v2 = stack2.isEmpty() ? 0 : stack2.pop();
            sum = v1 + v2 + add;
            add = sum / 10;
            cur = new ListNode(sum % 10);
            cur.next = head;
            head = cur;
        }


        return head;
    }

}
