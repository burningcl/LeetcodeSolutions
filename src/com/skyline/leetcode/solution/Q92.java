package com.skyline.leetcode.solution;

/**
 * Reverse Linked List II
 * 
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * 
 * @author jairus
 *
 */
public class Q92 {

	public ListNode reverseBetween(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode f = null;
		ListNode c = head;
		ListNode n = head.next;
		while (n != null) {
			c.next = f;
			f = c;
			c = n;
			n = n.next;
		}
		c.next = f;
		return c;
	}

	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m >= n || head == null) {
			return head;
		}
		ListNode fTail = null;
		ListNode cHead = null;
		ListNode cTail = null;
		ListNode lHead = null;
		ListNode c = head;
		for (int i = 1; i <= n + 1 && c != null; i++) {
			if (i == m - 1) {
				fTail = c;
			} else if (i == m) {
				cHead = c;
			} else if (i == n) {
				cTail = c;
			} else if (i == n + 1) {
				lHead = c;
			}
			c = c.next;
		}
		if (cTail == null || cHead == null) {

			return head;
		}
		cTail.next = null;
		//System.out.println(cTail + ", " + cHead);
		cHead = reverseBetween(cHead);
		//System.out.println("cHead: " + cHead);
		//System.out.println("lHead: " + lHead);
		if (fTail != null) {
			fTail.next = cHead;
		}
		if (lHead != null) {
			c = cHead;
			while (c.next != null) {
				c = c.next;
			}
			//System.out.println(c);
			c.next = lHead;
		}
		return fTail != null ? head : cHead;
	}

	public static void main(String... strings) {
		Q92 q = new Q92();
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(q.reverseBetween(ListNode.toList(nums)));
		System.out.println(q.reverseBetween(ListNode.toList(nums), 1, 9));
		System.out.println(q.reverseBetween(ListNode.toList(nums), 2, 9));
		System.out.println(q.reverseBetween(ListNode.toList(nums), 1, 8));
		System.out.println(q.reverseBetween(ListNode.toList(nums), 2, 8));
	}
}
