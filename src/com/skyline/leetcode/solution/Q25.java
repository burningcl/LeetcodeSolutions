package com.skyline.leetcode.solution;

/**
 * Reverse Nodes in k-Group
 * 
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * @author jairus
 *
 */
public class Q25 {
	public ListNode reverseKGroup(ListNode head, int k) {
		if (k <= 1) {
			return head;
		}
		ListNode nHead = null;
		ListNode nTail = null;
		ListNode cur = null;
		ListNode oHead = head;
		boolean left = false;
		while (head != null) {
			cur = head;
			ListNode t = head;
			int i = 0;
			for (; i < k && head != null; i++) {
				head = head.next;
			}
			if (head == null && i < k) {
				left = true;
				break;
			}
			ListNode next = cur.next;
			cur.next = null;
			while (next != head) {
				ListNode third = next.next;
				next.next = cur;
				cur = next;
				next = third;
			}
			if (nHead == null) {
				nHead = cur;
			}
			if (nTail != null) {
				nTail.next = cur;
			}
			nTail = t;
		}
		if (nHead == null) {
			return oHead;
		}
		if (left) {
			nTail.next = cur;
		}
		return nHead;
	}

	public static void main(String... strings) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
		Q25 q = new Q25();
		for (int i = 1; i <= 16; i++) {
			System.out.println(q.reverseKGroup(ListNode.toList(array), i));
		}
	}
}
