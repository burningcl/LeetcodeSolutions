package com.skyline.leetcode.solution;

/**
 * Balanced Binary Tree
 * 
 * https://leetcode.com/problems/balanced-binary-tree/
 * 
 * @author jairus
 *
 */
public class Q110 {
	boolean isBalanced = true;

	public int height(TreeNode root) {
		if (!isBalanced) {
			return 0;
		}
		if (root == null) {
			return 0;
		}
		int bleft = height(root.left);
		if (!isBalanced) {
			return 0;
		}
		int bright = height(root.right);
		if (!isBalanced) {
			return 0;
		}
		if (Math.abs(bleft - bright) > 1) {
			isBalanced = false;
		}
		return Math.max(bleft, bright) + 1;
	}

	public boolean isBalanced(TreeNode root) {
		height(root);
		return isBalanced;
	}
}
