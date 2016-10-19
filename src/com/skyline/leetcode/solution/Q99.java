package com.skyline.leetcode.solution;

/**
 * Recover Binary Search Tree
 * 
 * https://leetcode.com/problems/recover-binary-search-tree/
 * 
 * @author jairus
 *
 */
public class Q99 {

	TreeNode f = null;

	TreeNode[][] map = new TreeNode[2][2];

	int mapSize = 0;

	private void recoverTreeInternal(TreeNode root) {
		if (root == null || mapSize >= 2) {
			return;
		}
		recoverTreeInternal(root.left);
		if (f != null && f.val > root.val) {
			map[mapSize][0] = f;
			map[mapSize][1] = root;
			mapSize++;
		}
		f = root;
		recoverTreeInternal(root.right);
	}

	private void swap(TreeNode t1, TreeNode t2) {
		int t = t1.val;
		t1.val = t2.val;
		t2.val = t;
	}

	public void recoverTree(TreeNode root) {
		recoverTreeInternal(root);
		if (mapSize == 1) {
			swap(map[0][0], map[0][1]);
		} else if (mapSize == 2) {
			TreeNode t1 = map[0][0].val > map[0][1].val ? map[0][0] : map[0][1];
			TreeNode t2 = map[1][0].val < map[1][1].val ? map[1][0] : map[1][1];
			swap(t1, t2);
		}
	}

	public static void main(String[] args) {

	}

}
