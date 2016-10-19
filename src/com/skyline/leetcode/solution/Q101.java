package com.skyline.leetcode.solution;

/**
 * Symmetric Tree
 * 
 * https://leetcode.com/problems/symmetric-tree/
 * 
 * 
 * @author jairus
 *
 */
public class Q101 {

	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left != null && right != null)
			return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
		return left == right;
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetric(root.left, root.right);
	}
}
