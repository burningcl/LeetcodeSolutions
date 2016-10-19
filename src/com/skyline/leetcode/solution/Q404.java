package com.skyline.leetcode.solution;

/**
 * Sum of Left Leaves
 * 
 * https://leetcode.com/problems/sum-of-left-leaves/
 * 
 * @author jairus
 *
 */
public class Q404 {

	public int sumOfLeftLeaves(TreeNode root, boolean left) {
		if (root == null) {
			return 0;
		} else if (left && root.left == null && root.right == null) {
			return root.val;
		} else {
			return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
		}
	}

	public int sumOfLeftLeaves(TreeNode root) {
		return sumOfLeftLeaves(root, false);
	}

	public static void main(String... strings) {
		// [1,2,3,4,5]
	}
}
