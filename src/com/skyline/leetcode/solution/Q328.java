package com.skyline.leetcode.solution;

/**
 * Odd Even Linked List
 * 
 * https://leetcode.com/problems/odd-even-linked-list/
 * 
 * @author jairus
 *
 */
public class Q328 {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode oddEvenList(ListNode head) {
		ListNode oddHeader = null;
		ListNode oddTail = null;
		ListNode evenHeader = null;
		ListNode evenTail = null;
		int i = 1;
		while (head != null) {
			if (i % 2 == 1) {
				if (oddHeader == null) {
					oddHeader = head;
					oddTail = head;
				} else {
					oddTail.next = head;
					oddTail = head;
				}
			} else {
				if (evenHeader == null) {
					evenHeader = head;
					evenTail = head;
				} else {
					evenTail.next = head;
					evenTail = head;
				}
			}
			head = head.next;
			i++;
		}
		if (evenHeader == null) {
			return oddHeader;
		} else {
			oddTail.next = evenHeader;
			evenTail.next = null;
			return oddHeader;
		}
	}
}
