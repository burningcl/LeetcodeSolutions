package com.skyline.leetcode.solution;

/**
 * Reorder List
 * 
 * https://leetcode.com/problems/reorder-list/
 * 
 * @author jairus
 *
 */
public class Q143 {

	public ListNode reverse(ListNode h) {
		if (h == null || h.next == null) {
			return h;
		}
		ListNode n = h.next;
		ListNode l = n.next;
		h.next = null;
		while (n != null) {
			n.next = h;
			h = n;
			n = l;
			if (l != null)
				l = l.next;
		}
		return h;
	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode t = null;
		ListNode c = head;
		ListNode h2 = head;
		while (c != null) {
			t = h2;
			h2 = h2.next;
			c = c.next;
			if (c != null) {
				c = c.next;
			}
		}
		t.next = null;
		h2 = this.reverse(h2);
		ListNode h1 = head.next;
		t = head;
		while (h2 != null) {
			t.next = h2;
			t = t.next;
			h2 = h2.next;
			
			t.next = h1;
			t = t.next;
			if (h1 != null)
				h1 = h1.next;
		}
	}

	public static void main(String[] args) {
		Q143 q = new Q143();
		int[] array1 = { 1 };
		int[] array2 = { 1, 2 };
		int[] array3 = { 1, 2, 3 };
		int[] array4 = { 1, 2, 3, 4 };
		int[] array5 = { 1, 2, 3, 4, 5 };
		int[] array6 = { 1, 2, 3, 4, 5, 6 };
		int[] array7 = { 1, 2, 3, 4, 5, 6, 7 };
		// System.out.println(q.reverse(ListNode.toList(array1)));
		// System.out.println(q.reverse(ListNode.toList(array2)));
		// System.out.println(q.reverse(ListNode.toList(array3)));
		// System.out.println(q.reverse(ListNode.toList(array4)));
		// System.out.println(q.reverse(ListNode.toList(array5)));

		ListNode l1 = ListNode.toList(array1);
		q.reorderList(l1);
		System.out.println(l1);

		ListNode l2 = ListNode.toList(array2);
		q.reorderList(l2);
		System.out.println(l2);

		ListNode l3 = ListNode.toList(array3);
		q.reorderList(l3);
		System.out.println(l3);

		ListNode l4 = ListNode.toList(array4);
		q.reorderList(l4);
		System.out.println(l4);

		ListNode l5 = ListNode.toList(array5);
		q.reorderList(l5);
		System.out.println(l5);

		ListNode l6 = ListNode.toList(array6);
		q.reorderList(l6);
		System.out.println(l6);

		ListNode l7 = ListNode.toList(array7);
		q.reorderList(l7);
		System.out.println(l7);
	}

}
