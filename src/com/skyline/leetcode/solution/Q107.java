package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Level Order Traversal II
 * 
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * 
 * @author jairus
 *
 */
public class Q107 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();

		q1.offer(root);
		while (!q1.isEmpty()) {
			List<Integer> sub = new ArrayList<>();
			while (!q1.isEmpty()) {
				TreeNode node = q1.poll();
				sub.add(node.val);
				if (node.left != null) {
					q2.offer(node.left);
				}
				if (node.right != null) {
					q2.offer(node.right);
				}
			}
			list.add(0, sub);
			Queue<TreeNode> q=q1;
			q1=q2;
			q2=q;
		}
		return list;
	}
}
