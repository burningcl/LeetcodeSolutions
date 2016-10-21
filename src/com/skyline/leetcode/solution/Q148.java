package com.skyline.leetcode.solution;

/**
 * Sort List
 * 
 * https://leetcode.com/problems/sort-list/
 * 
 * merge sort
 * 
 * @author jairus
 *
 */
public class Q148 {

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode c = head;
		ListNode h1 = head;
		ListNode h2 = head;
		ListNode t = null;

		while (c != null) {
			t = h2;
			h2 = h2.next;
			c = c.next;
			if (c != null) {
				c = c.next;
			}
		}
		t.next = null;
		if (h2 == null) {
			return sortList(h1);
		}
		h1 = this.sortList(h1);
		h2 = this.sortList(h2);
		head = null;
		t = null;
		while (h1 != null && h2 != null) {
			if (h1.val < h2.val) {
				if (t == null) {
					head = t = h1;
				} else {
					t.next = h1;
					t = t.next;
				}
				h1 = h1.next;
			} else {
				if (t == null) {
					head = t = h2;
				} else {
					t.next = h2;
					t = t.next;
				}
				h2 = h2.next;
			}
		}
		t.next = h1 != null ? h1 : h2;

		return head;
	}

	// public ListNode sortList(ListNode head, int len) {
	// ListNode h = null;
	// ListNode t = null;
	// ListNode h1 = head;
	// ListNode h2 = head;
	// while (h1 != null && h2 != null) {
	// ListNode t1 = h1;
	// for (int i = 0; i < len && h2 != null; i++) {
	// t1 = h2;
	// h2 = h2.next;
	// }
	// if (h2 == null) {
	// break;
	// }
	// t1.next = null;
	// ListNode t2 = h2;
	// ListNode h3 = h2;
	// for (int i = 0; i < len && h3 != null; i++) {
	// t2 = h3;
	// h3 = h3.next;
	// }
	// t2.next = null;
	// while (h1 != null && h2 != null) {
	// ListNode c = h1.val < h2.val ? h1 : h2;
	// if (h == null && t == null) {
	// h = t = c;
	// } else {
	// t.next = c;
	// t = t.next;
	// }
	// if (c == h1) {
	// h1 = h1.next;
	// } else {
	// h2 = h2.next;
	// }
	// }
	// if (h1 != null) {
	// t.next = h1;
	// t = t1;
	// } else {
	// t.next = h2;
	// t = t2;
	// }
	// h1 = h2 = h3;
	// }
	// ListNode c = h1 != null ? h1 : h2;
	// if (h == null && t == null) {
	// h = c;
	// } else {
	// t.next = c;
	// }
	//
	// return h;
	// }
	//
	// public ListNode sortList(ListNode head) {
	// if (head == null || head.next == null) {
	// return head;
	// }
	// ListNode c = head;
	// int len = 1;
	// while (c != null) {
	// c = c.next;
	// len++;
	// }
	// for (int i = 1; i < len; i = i << 1) {
	// head = this.sortList(head, i);
	// }
	// return head;
	// }

	public static void main(String... strings) {
		Q148 q = new Q148();
		int[] array = { 3, 4, 6, 5, 8, 1, 3, 2, 9 };
		ListNode head = ListNode.toList(array);
		System.out.println(q.sortList(head));
	}
}
