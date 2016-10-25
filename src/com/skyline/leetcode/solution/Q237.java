package com.skyline.leetcode.solution;

/**
 * Delete Node in a Linked List
 * 
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * 
 * @author jairus
 *
 */
public class Q237 {

	public void deleteNode(ListNode node) {
		if (node == null) {
			return;
		}
		ListNode next = node.next;
		if (next == null) {
			// this is the tail
			return;
		}
		node.val = next.val;
		node.next = next.next;
		next.next = null;
	}
}
