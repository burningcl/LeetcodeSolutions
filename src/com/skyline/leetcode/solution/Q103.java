package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Binary Tree Zigzag Level Order Traversal
 * 
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 
 * @author jairus
 *
 */
public class Q103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> queue1 = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();
		queue1.offer(root);
		int level = 0;
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
			if (level++ % 2 == 0) {
				list.add(subList);
			} else {
				List<Integer> subList2 = new ArrayList<>();
				for (int i = subList.size() - 1; i >= 0; i--) {
					subList2.add(subList.get(i));
				}
				list.add(subList2);
			}
			Queue<TreeNode> t = queue1;
			queue1 = queue2;
			queue2 = t;
		}
		return list;
	}
}
