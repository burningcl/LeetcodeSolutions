package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Right Side View
 * 
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * 
 * @author jairus
 *
 */
public class Q199 {

	int maxDepth = 0;

	public void rightSideView(TreeNode root, List<Integer> list, int depth) {
		if (root == null) {
			return;
		}
		if (depth > maxDepth) {
			maxDepth = depth;
			list.add(root.val);
		}
		this.rightSideView(root.right, list, depth + 1);
		this.rightSideView(root.left, list, depth + 1);
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		this.rightSideView(root, list, 1);
		return list;
	}
}
