package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Binary Tree Postorder Traversal
 * 
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * @author jairus
 *
 */
public class Q145 {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			list.add(root.val);
			if (root.left != null) {
				stack.push(root.left);
			}
			if (root.right != null) {
				stack.push(root.right);
			}
		}
		int i = 0, j = list.size() - 1;
		while (i < j) {
			int t = list.get(i);
			list.set(i, list.get(j));
			list.set(j, t);
			i++;
			j--;
		}
		return list;
	}
}
