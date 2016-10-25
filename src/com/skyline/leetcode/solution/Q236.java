package com.skyline.leetcode.solution;

/**
 * Lowest Common Ancestor of a Binary Tree
 * 
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 
 * @author jairus
 *
 */
public class Q236 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		} else if (root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		if (left != null && left != p && left != q) {
			return left;
		}
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left != null && right != null) {
			return root;
		} else if (left != null) {
			return left;
		} else {
			return right;
		}
	}

	public static void main(String... strings) {
		Q236 q = new Q236();
		System.out.println(q.lowestCommonAncestor(null, null, null));
	}

}
