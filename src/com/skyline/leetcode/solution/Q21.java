package com.skyline.leetcode.solution;

/**
 * Merge Two Sorted Lists
 * 
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 * @author jairus
 *
 */
public class Q21 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode c = null;
		while (l1 != null && l2 != null) {
			ListNode l = l1.val < l2.val ? l1 : l2;
			if (head == null) {
				head = l;
				c = l;
			} else {
				c.next = l;
				c = c.next;
			}
			if (l1 == l)
				l1 = l1.next;
			else
				l2 = l2.next;
		}
		ListNode l = l1 != null ? l1 : l2;
		if (l == null) {
			return head;
		}
		if (head == null) {
			return l;
		}
		c.next = l;
		return head;
	}

	public static void main(String... strings) {
		Q21 q = new Q21();
		int[][] arrays = { null, { 1, 2 }, { 2, 3 }, { 1, 2, 3 } };
		System.out.println(q.mergeTwoLists(ListNode.toList(arrays[0]), ListNode.toList(arrays[1])));
		System.out.println(q.mergeTwoLists(ListNode.toList(arrays[1]), ListNode.toList(arrays[2])));
		System.out.println(q.mergeTwoLists(ListNode.toList(arrays[2]), ListNode.toList(arrays[3])));
	}
}
