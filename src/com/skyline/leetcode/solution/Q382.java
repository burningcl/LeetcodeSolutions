package com.skyline.leetcode.solution;

import java.util.Random;

/**
 * Linked List Random Node
 * 
 * https://leetcode.com/problems/linked-list-random-node/
 * 
 * @author jairus
 *
 */
public class Q382 {

	public class ListNode {
		ListNode next;
		int val;
	}

	public class Solution {

		int length;

		ListNode head;

		Random rand;

		/**
		 * @param head
		 *            The linked list's head. Note that the head is guanranteed
		 *            to be not null, so it contains at least one node.
		 */
		public Solution(ListNode head) {
			this.rand = new Random();
			this.head = head;
		}

		/** Returns a random node's value. */
		public int getRandom() {
			int randVal = 0;
			ListNode p = head;
			if (length > 0) {
				randVal = rand.nextInt(length);
			} else {
				randVal = rand.nextInt(Integer.MAX_VALUE);
				for (int i = 0; i < randVal; i++) {
					p = p.next;
					if (p == null) {
						length = i + 1;
						randVal = randVal % length;
						break;
					}
				}
				if (p != null) {
					return p.val;
				}
			}
			p = head;
			for (int i = 0; i < randVal; i++) {
				p = p.next;
			}
			return p.val;
		}
	}

	public static void main(String... strings) {
		System.out.println(new Random().nextInt(Integer.MAX_VALUE) % 1);
	}

}
