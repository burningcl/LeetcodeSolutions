package com.skyline.leetcode.solution;

/**
 * Populating Next Right Pointers in Each Node II
 * 
 * @author jairus
 *
 */
public class Q117 {

	private TreeLinkNode findNextLevel(TreeLinkNode root) {
		while (root != null && root.left == null && root.right == null) {
			root = root.next;
		}
		if (root != null) {
			return root.left != null ? root.left : root.right;
		} else {
			return null;
		}
	}

	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode left = root.left;
		TreeLinkNode right = root.right;
		connect(left);
		connect(right);
		while (left != null && right != null && left != right) {
			// System.out.println("left: " + left.val + ", right: " +
			// right.val);
			TreeLinkNode ll = left;
			while (ll.next != null) {
				ll = ll.next;
			}
			ll.next = right;
			left = this.findNextLevel(left);
			if (left != null)
				right = this.findNextLevel(right);
		}
	}
}
