package com.skyline.leetcode.solution;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}

	public static ListNode toList(int[] array) {
		if (array == null || array.length <= 0) {
			return null;
		}
		ListNode head = null;
		ListNode node = null;
		for (int num : array) {
			ListNode next = new ListNode(num);
			if (head == null) {
				head = next;
				node = next;
			} else {
				node.next = next;
				node = next;
			}
		}
		return head;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		ListNode node = this;
		while (node != null) {
			sb.append(node.val);
			if (node.next != null) {
				sb.append(" -> ");
			}
			node = node.next;
		}
		return sb.toString();
	}
}
