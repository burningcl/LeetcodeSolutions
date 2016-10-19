package com.skyline.leetcode.solution;

/**
 * Flatten Binary Tree to Linked List
 * 
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * 
 * @author jairus
 * 
 */
public class Q114 {

	private TreeNode flattenInTernal(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode lTail = flattenInTernal(root.left);
		TreeNode rTail = flattenInTernal(root.right);
		if (lTail != null) {
			lTail.right = root.right;
			root.right = root.left;
		}
		root.left = null;
		return rTail != null ? rTail : lTail != null ? lTail : root;
	}

	public void flatten(TreeNode root) {
		flattenInTernal(root);
	}

	public static void main(String... strings) {
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		long t1 = System.currentTimeMillis();
		new Q114().flatten(root);
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
		while (root != null) {
			System.out.println(root.val);
			System.out.println(root.left);
			System.out.println(root.right);
			root = root.right;
		}
	}
}
