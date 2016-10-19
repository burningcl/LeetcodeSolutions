package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree Inorder Traversal
 * 
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * @author jairus
 *
 */
public class Q94 {

	public void inorderTraversal(TreeNode root, List<Integer> list) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left, list);
		list.add(root.val);
		inorderTraversal(root.right, list);
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		inorderTraversal(root, list);
		return list;
	}
}
