package com.skyline.leetcode.solution;

/**
 * Insertion Sort List
 * 
 * https://leetcode.com/problems/insertion-sort-list/
 * 
 * @author jairus
 * 
 */
public class Q147 {

	public ListNode insertionSortList(ListNode head) {
		ListNode nHead = null;
		ListNode nTail = null;

		while (head != null) {
			ListNode cur = head;
			ListNode minNode = head;
			while (cur != null) {
				if (cur.val < minNode.val) {
					minNode = cur;
				}
				cur = cur.next;
			}
			if (nHead == null) {
				nHead = nTail = minNode;
			} else {
				nTail.next = minNode;
				nTail = nTail.next;
			}
			if (minNode != head) {
				// ��һ��Ԫ�ؾ�����СԪ��,��ʲôҲ����
				ListNode pre = head;
				while (pre.next != minNode) {
					pre = pre.next;
				}
				pre.next = minNode.next;
				minNode.next = head;
			} else {
				head = head.next;
			}

		}
		return nHead;
	}

	public static void main(String... strings) {
		ListNode head = null;
		ListNode cur = null;
		for (int i = 10; i >= 0; i--) {
			ListNode t = new ListNode(i);
			if (head == null) {
				head = t;
			} else {
				cur.next = t;
			}
			cur = cur.next;
		}
		head = new Q147().insertionSortList(head);
		// while (head != null) {
		// System.out.println(head.val);
		// head = head.next;
		// }
	}
}
