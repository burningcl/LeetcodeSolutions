package com.skyline.leetcode.solution;

/**
 * Reverse Linked List
 * 
 * https://leetcode.com/problems/reverse-linked-list/
 * 
 * @author jairus
 *
 */
public class Q206 {
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode cur = head;
		ListNode next = cur.next;
		cur.next = null;
		while (next != null) {
			ListNode t = next.next;
			next.next = cur;
			cur = next;
			next = t;
		}
		return cur;
	}

	public static void main(String[] args) {
		Q206 q = new Q206();

		int[] array = { 0 };
		System.out.println(q.reverseList(ListNode.toList(array)));

		int[] array1 = { 0, 1 };
		System.out.println(q.reverseList(ListNode.toList(array1)));

		int[] array2 = { 0, 1, 2 };
		System.out.println(q.reverseList(ListNode.toList(array2)));

		int[] array3 = { 0, 1, 2, 3 };
		System.out.println(q.reverseList(ListNode.toList(array3)));

	}

}
