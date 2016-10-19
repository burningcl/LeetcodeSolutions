package com.skyline.leetcode.solution;

/**
 * Linked List Cycle II
 * 
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * 
 * @author jairus
 *
 */
public class Q142 {
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode fast = head.next.next;
		ListNode slow = head.next;
		while (fast != slow && fast != null) {
			if (fast.next == null) {
				break;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		if (fast != slow) {
			return null;
		}
		ListNode cur1 = head;
		int cnt1 = 0;
		while (cur1.next != slow) {
			cnt1++;
			cur1 = cur1.next;
		}
		ListNode cur2 = slow.next;
		int cnt2 = 0;
		while (cur2.next != slow) {
			cnt2++;
			cur2 = cur2.next;
		}
		cur1 = head;
		cur2 = slow.next;
		if (cnt1 > cnt2) {
			for (int i = 0; i < cnt1 - cnt2; i++) {
				cur1 = cur1.next;
			}
		} else if (cnt1 < cnt2) {
			for (int i = 0; i < cnt2 - cnt1; i++) {
				cur2 = cur2.next;
			}
		}
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}
}
