package com.skyline.leetcode.solution;

/**
 * Linked List Cycle
 * 
 * https://leetcode.com/problems/linked-list-cycle/
 * 
 * @author jairus
 *
 */
public class Q141 {

	public boolean hasCycle(ListNode head) {
		try {
			ListNode slow = head.next;
			ListNode fast = slow.next;
			while (fast != slow) {
				fast = fast.next.next;
				slow = slow.next;
			}
			return fast == slow;
		} catch (Exception e) {
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
