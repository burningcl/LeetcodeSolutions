package com.skyline.leetcode.solution;

/**
 * Remove Linked List Elements
 * 
 * https://leetcode.com/problems/remove-linked-list-elements/
 * 
 * @author jairus
 *
 */
public class Q203 {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		ListNode cur = head;
		boolean delLast = false;
		while (cur != null) {
			if (cur.val == val) {
				ListNode next = cur.next;
				if (next == null) {
					delLast = true;
					break;
				}
				cur.val = next.val;
				cur.next = next.next;
				next.next = null;
			}
			if (cur.val != val) {
				cur = cur.next;
			}
		}
		if (!delLast) {
			return head;
		}
		if (head.next == null) {
			return null;
		}
		cur = head;
		while (cur.next.next != null) {
			cur = cur.next;
		}
		cur.next = null;
		return head;
	}

	public static void main(String... strings) {
		Q203 q = new Q203();
		int[] array = { 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6 };
		ListNode head = ListNode.toList(array);
		System.out.println(q.removeElements(head, 6));
		System.out.println(q.removeElements(head, 1));
		System.out.println(q.removeElements(head, 2));

		int[] array2 = { 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 1 };
		ListNode head2 = ListNode.toList(array2);
		System.out.println(q.removeElements(head2, 6));

		int[] array3 = { 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 1, 1, 1, 1, 1, 1 };
		ListNode head3 = ListNode.toList(array3);
		System.out.println(q.removeElements(head3, 1));
		
		int[] array4 = { 1 };
		ListNode head4 = ListNode.toList(array4);
		System.out.println(q.removeElements(head4, 1));

	}
}
