package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Level Order Traversal
 * 
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 * @author jairus
 *
 */
public class Q102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> queue1 = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();
		queue1.offer(root);
		while (!queue1.isEmpty()) {
			List<Integer> subList = new ArrayList<>();
			while (!queue1.isEmpty()) {
				TreeNode node = queue1.poll();
				subList.add(node.val);
				if (node.left != null)
					queue2.offer(node.left);
				if (node.right != null)
					queue2.offer(node.right);
			}
			list.add(subList);
			Queue<TreeNode> t = queue1;
			queue1 = queue2;
			queue2 = t;
		}
		return list;
	}
}
