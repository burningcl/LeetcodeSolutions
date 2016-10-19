package com.skyline.leetcode.solution;

/**
 * Partition List
 * 
 * https://leetcode.com/problems/partition-list/
 * 
 * @author jairus
 *
 */
public class Q86 {

	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode lHead = null;
		ListNode lTail = null;
		ListNode gHead = null;
		ListNode gTail = null;

		ListNode cur = head;
		while (cur != null) {
			if (cur.val < x) {
				if (lHead == null) {
					lHead = cur;
					lTail = cur;
				} else {
					lTail.next = cur;
					lTail = cur;
				}
			} else {
				if (gHead == null) {
					gHead = cur;
					gTail = cur;
				} else {
					gTail.next = cur;
					gTail = cur;
				}
			}
			cur = cur.next;
		}

		if (lHead == null) {
			return gHead;
		} else if (gHead == null) {
			return lHead;
		}

		gTail.next = null;
		lTail.next = gHead;

		return lHead;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
