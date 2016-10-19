package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Unique Binary Search Trees II
 * 
 * https://leetcode.com/problems/unique-binary-search-trees-ii/
 * 
 * @author jairus
 *
 */
public class Q95 {

	Object[][] cache = null;

	@SuppressWarnings("unchecked")
	public List<TreeNode> generateTrees(int start, int end) {
		if (cache[start][end] != null) {
			return (List<TreeNode>) cache[start][end];
		}
		List<TreeNode> list = new ArrayList<>();
		if (start > end) {
			list.add(null);
			cache[start][end] = list;
			return list;
		}
		for (int i = start; i <= end; i++) {
			List<TreeNode> left = generateTrees(start, i - 1);
			List<TreeNode> right = generateTrees(i + 1, end);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode t = new TreeNode(i);
					t.left = l;
					t.right = r;
					list.add(t);
				}
			}
		}
		cache[start][end] = list;
		return list;
	}

	public List<TreeNode> generateTrees(int n) {
		if (n <= 0) {
			return new ArrayList<>();
		}
		cache = new Object[n + 2][n + 2];
		return generateTrees(1, n);
	}
}
