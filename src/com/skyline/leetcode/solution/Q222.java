package com.skyline.leetcode.solution;

/**
 * Count Complete Tree Nodes
 * 
 * https://leetcode.com/problems/count-complete-tree-nodes/
 * 
 * @author jairus
 *
 */
public class Q222 {

	private int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return depth(root.left) + 1;
	}

	private int countNodes(TreeNode root, int dLeft) {
		if (root == null) {
			return 0;
		}
		if (dLeft == 0) {
			dLeft = depth(root.left);
		}
		int dRight = depth(root.right);
		if (dLeft == dRight) {
			return (1 << dLeft) + countNodes(root.right, dRight - 1);
		} else {
			return (1 << dRight) + countNodes(root.left, dLeft - 1);
		}
	}

	public int countNodes(TreeNode root) {
		return this.countNodes(root, 0);
	}

}
