package com.skyline.leetcode.solution;

/**
 * Remove Duplicates from Sorted List II
 * 
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * 
 * @author jairus
 *
 */
public class Q82 {

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		int val = head.val - 1;
		int cnt = 0;
		ListNode cur = head;
		ListNode tail = head;
		while (cur != null) {
			if (val != cur.val) {
				if (cnt == 1) {
					tail.val = val;
					tail = tail.next;
				}
				cnt = 1;
				val = cur.val;
			}else{
				cnt++;
			}
			cur = cur.next;
		}
		if (cnt == 1) {
			tail.val = val;
			tail = tail.next;
		}
		if (head == tail) {
			return null;
		}
		cur = head;
		while (cur.next != tail) {
			cur = cur.next;
		}
		cur.next = null;
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
