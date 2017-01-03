package com.skyline.leetcode.solution;

/**
 * Remove Duplicates from Sorted List
 * 
 * 
 * @author jairus
 *
 */
public class Q83 {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode cur = head;
		ListNode next = null;
		while (cur != null) {
			for (next = cur.next; next != null && next.val == cur.val; next = cur.next) {
				cur.next = next.next;
				next.next = null;
			}
			cur = cur.next;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
