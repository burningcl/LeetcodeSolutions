package com.skyline.leetcode.solution;

/**
 * Sum Root to Leaf Numbers
 * 
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * 
 * @author jairus
 *
 */
public class Q129 {

	private int sumNumbers(TreeNode root, int val) {
		if (root == null) {
			return 0;
		}
		val = val * 10 + root.val;
		if (root.left == null && root.right == null) {
			return val;
		}
		int left = this.sumNumbers(root.left, val);
		int right = this.sumNumbers(root.right, val);
		return left + right;
	}

	public int sumNumbers(TreeNode root) {
		return this.sumNumbers(root, 0);
	}
}
