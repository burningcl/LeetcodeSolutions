package com.skyline.leetcode.solution;

/**
 * Maximum Depth of Binary Tree
 * 
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * @author jairus
 *
 */
public class Q104 {

	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
