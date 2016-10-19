package com.skyline.leetcode.solution;

/**
 * Rotate List
 * 
 * https://leetcode.com/problems/rotate-list/
 * 
 * @author jairus
 *
 */
public class Q61 {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k <= 0) {
			return head;
		}
		ListNode cur = head;
		int listSize = 0;
		for (int i = 0; i < k; i++) {
			if (cur.next == null) {
				cur = head;
				listSize = i + 1;
				i = (k / listSize) * listSize - 1;
			} else {
				cur = cur.next;
			}
		}
		if (cur == head) {
			return head;
		}
		ListNode tail = head;
		while (cur.next != null) {
			cur = cur.next;
			tail = tail.next;
		}
		ListNode nHead = tail.next;
		tail.next = null;
		cur.next = head;
		return nHead;
	}

	public static void main(String... strings) {
		Q61 q = new Q61();
		int[] array = new int[10];
		for (int i = 0; i < 10; i++) {
			array[i] = i;
		}
		for (int i = 0; i < 100; i++) {
			ListNode head = ListNode.toList(array);
			System.out.println(i + ":\t" + q.rotateRight(head, i).toString());
		}
	}
}
