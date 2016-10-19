package com.skyline.leetcode.solution;

/**
 * Remove Nth Node From End of List
 * 
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * 
 * @author jairus
 *
 */
public class Q19 {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null || n <= 0) {
			return head;
		}
		ListNode toDel = null;
		ListNode node = head;
		for (int i = 1; i < n && node != null; i++) {
			node = node.next;
		}
		if (node == null) {
			return head;
		}
		toDel = head;
		while (node.next != null) {
			node = node.next;
			toDel = toDel.next;
		}
		if (toDel == head) {
			head = head.next;
			toDel.next = null;
		} else if (toDel.next == null) {
			node = head;
			while (node.next != toDel) {
				node = node.next;
			}
			node.next = null;
		} else {
			node = toDel.next;
			toDel.val = node.val;
			toDel.next = node.next;
			node.next = null;
		}
		return head;
	}

	public static void main(String... strings) {
		Q19 q = new Q19();
		int[][] arrays = { { 1, 2, 3, 4, 5 }, { 1 } };
		System.out.println(q.removeNthFromEnd(ListNode.toList(arrays[0]), 0));
		System.out.println(q.removeNthFromEnd(ListNode.toList(arrays[0]), 1));
		System.out.println(q.removeNthFromEnd(ListNode.toList(arrays[0]), 2));
		System.out.println(q.removeNthFromEnd(ListNode.toList(arrays[0]), 3));
		System.out.println(q.removeNthFromEnd(ListNode.toList(arrays[0]), 4));
		System.out.println(q.removeNthFromEnd(ListNode.toList(arrays[0]), 5));
		System.out.println(q.removeNthFromEnd(ListNode.toList(arrays[0]), 6));
		System.out.println(q.removeNthFromEnd(ListNode.toList(arrays[1]), 0));
		System.out.println(q.removeNthFromEnd(ListNode.toList(arrays[1]), 1));
		System.out.println(q.removeNthFromEnd(ListNode.toList(arrays[1]), 2));
	}
}
