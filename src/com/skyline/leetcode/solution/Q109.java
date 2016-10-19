package com.skyline.leetcode.solution;

/**
 * Convert Sorted List to Binary Search Tree
 * 
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * 
 * @author jairus
 * 
 */
public class Q109 {

	private TreeNode sortedListToBST(TreeNode tHead, TreeNode tTail) {
		TreeNode cHead = tHead;
		TreeNode cTail = tTail;
		while (cHead != cTail && cHead.right != cTail) {
			cHead = cHead.right;
			cTail = cTail.left;
		}
		TreeNode root = cHead;
		root.left = cHead != tHead ? sortedListToBST(tHead, cHead.left) : null;
		root.right = cHead != tTail ? sortedListToBST(cHead.right, tTail) : null;
		return root;
	}

	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}
		TreeNode tHead = new TreeNode(head.val);
		TreeNode tTail = tHead;
		head = head.next;
		while (head != null) {
			TreeNode t = new TreeNode(head.val);
			tTail.right = t;
			t.left = tTail;
			tTail = t;
			head = head.next;
		}
		return this.sortedListToBST(tHead, tTail);
	}
}
