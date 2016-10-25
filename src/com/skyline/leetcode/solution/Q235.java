package com.skyline.leetcode.solution;

/**
 * Lowest Common Ancestor of a Binary Search Tree
 * 
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 
 * @author jairus
 *
 */
public class Q235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		} else if (root == p || root == q) {
			return root;
		}
		TreeNode left = this.lowestCommonAncestor(root.left, p, q);
		if (left != null && left != p && left != q) {
			//在左子树发现LCA
			return left;
		}
		TreeNode right = this.lowestCommonAncestor(root.right, p, q);
		if (right != null && right != p && right != q) {
			//在右子树发现LCA
			return right;
		}
		
		if ((left == p || left == q) && (right == p || right == q)) {
			//在左子树发现某一节点，在右子树发现另一个节点，当前节点为LCA
			return root;
		} else if (left == p || left == q) {
			//在左子树发现某一节点，在右子树没有发现另一个节点，当前节点不是LCA
			return left;
		} else if (right == p || right == q) {
			//在左子树没有发现某一节点，在右子树发现另一个节点，当前节点不是LCA
			return right;
		} else {
			//当在前树上没有发现p与q
			return null;
		}
	}
}
