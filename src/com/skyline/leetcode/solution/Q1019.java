package com.skyline.leetcode.solution;

import java.util.ArrayDeque;

/**
 * @author huasong.cl
 */
public class Q1019 {

    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        int[] ret = new int[size];

        ArrayDeque<Integer> valStack = new ArrayDeque<>();
        ArrayDeque<Integer> indexStack = new ArrayDeque<>();
        cur = head;
        int index = 0;
        while (cur != null) {
            int val = cur.val;
            while (!valStack.isEmpty() && valStack.peek() < val) {
                valStack.pop();
                ret[indexStack.pop()] = val;
            }
            valStack.push(val);
            indexStack.push(index++);
            cur = cur.next;
        }

        return ret;
    }

}
