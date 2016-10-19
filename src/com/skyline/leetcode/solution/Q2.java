package com.skyline.leetcode.solution;

/**
 * Add Two Numbers
 * 
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * @author jairus
 *
 */
public class Q2 {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode ret = null;
		ListNode c = ret;
		ListNode c1 = l1;
		ListNode c2 = l2;
		int add = 0;
		while (c1 != null && c2 != null) {
			int sum = c1.val + c2.val + add;
			add = sum / 10;
			sum = sum % 10;
			ListNode cn = new ListNode(sum);
			if (c == null) {
				c = cn;
				ret = cn;
			} else {
				c.next = cn;
				c = cn;
			}
			c1 = c1.next;
			c2 = c2.next;
		}

		ListNode c3 = c1;
		if (c2 != null) {
			c3 = c2;
		}

		while (c3 != null) {
			int sum = c3.val + add;
			add = sum / 10;
			sum = sum % 10;
			ListNode cn = new ListNode(sum);
			if (c == null) {
				c = cn;
				ret = cn;
			} else {
				c.next = cn;
				c = cn;
			}
			c3 = c3.next;
		}

		if (add > 0) {
			ListNode cn = new ListNode(add);
			c.next = cn;
		}

		return ret;
	}

	public static void main(String... strings) {

	}
}
