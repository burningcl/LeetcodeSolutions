package com.skyline.leetcode.solution;

/**
 * Invert Binary Tree
 * 
 * https://leetcode.com/problems/invert-binary-tree/
 * 
 * @author jairus
 *
 */
public class Q226 {
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return root;
		TreeNode t = root.left;
		root.left = root.right;
		root.right = t;
		this.invertTree(root.left);
		this.invertTree(root.right);
		return root;
	}
}
