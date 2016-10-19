package com.skyline.leetcode.solution;

/**
 * Populating Next Right Pointers in Each Node
 * 
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 
 * @author jairus
 *
 */
public class Q116 {

	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		TreeLinkNode left = root.left;
		TreeLinkNode right = root.right;
		connect(left);
		connect(right);
		while (left != null && right != null) {
			left.next = right;
			left = left.right;
			right = right.left;
		}
	}

	public static void main(String[] args) {

	}

}
