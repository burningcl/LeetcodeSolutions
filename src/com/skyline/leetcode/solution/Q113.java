package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Path Sum II
 * 
 * https://leetcode.com/problems/path-sum-ii/
 * 
 * @author jairus
 *
 */
public class Q113 {
	public void pathSum(TreeNode root, int sum, List<List<Integer>> list, List<Integer> path) {
		if (root == null) {
			return;
		}
		path.add(root.val);
		if (root.val == sum && root.left == null && root.right == null) {
			List<Integer> p = new ArrayList<>();
			p.addAll(path);
			list.add(p);
		}
		sum -= root.val;
		this.pathSum(root.left, sum, list, path);
		this.pathSum(root.right, sum, list, path);
		sum += root.val;
		path.remove(path.size() - 1);
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> path = new ArrayList<>();
		this.pathSum(root, sum, list, path);
		return list;
	}
}
