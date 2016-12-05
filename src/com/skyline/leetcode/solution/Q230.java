package com.skyline.leetcode.solution;

/**
 * Kth Smallest Element in a BST
 * 
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 * @author jairus
 *
 */
public class Q230 {

	TreeNode kth = null;

	TreeNode smallest = null;

	int th = 0;

	int k = 0;

	private void t(TreeNode root) {
		if (root == null || kth != null) {
			return;
		}
		t(root.left);
		if (kth != null) {
			return;
		}
		if (root.left == null && smallest == null) {
			smallest = root;
			th = 1;
		} else if (smallest != null) {
			th++;
		}
		if (th == k) {
			kth = root;
			return;
		}
		t(root.right);
	}

	public int kthSmallest(TreeNode root, int k) {
		this.k = k;
		this.t(root);
		return kth!=null?kth.val:0;
	}

}
