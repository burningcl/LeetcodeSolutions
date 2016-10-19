package com.skyline.leetcode.solution;

/**
 * Swap Nodes in Pairs
 * 
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * @author jairus
 *
 */
public class Q24 {
	public ListNode swapPairs(ListNode head) {
		ListNode node = head;
		while (node != null) {
			ListNode next = node.next;
			if (next == null) {
				break;
			}
			node.val = node.val ^ next.val;
			next.val = node.val ^ next.val;
			node.val = node.val ^ next.val;
			node = next.next;
		}
		return head;
	}

	public static void main(String... strings) {
		Q24 q=new Q24();
		int[] array={1,2,3,4,5};
		System.out.println(q.swapPairs(ListNode.toList(array)));
	}
}
