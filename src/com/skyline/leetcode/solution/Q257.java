package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 * 
 * Binary Tree Paths
 * 
 * @author jairus
 *
 */
public class Q257 {

	public void binaryTreePaths(TreeNode root, List<String> list, List<Integer> cs) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < cs.size(); i++) {
				sb.append(cs.get(i));
				sb.append("->");
			}
			sb.append(root.val);
			list.add(sb.toString());
			return;
		}
		cs.add(root.val);
		this.binaryTreePaths(root.left, list, cs);
		this.binaryTreePaths(root.right, list, cs);
		cs.remove(cs.size() - 1);
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<>();
		List<Integer> cs = new ArrayList<>();
		this.binaryTreePaths(root, list, cs);
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
