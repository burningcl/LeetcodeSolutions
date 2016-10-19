package com.skyline.leetcode.solution;

/**
 * Validate Binary Search Tree
 * 
 * https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * @author jairus
 *
 */
public class Q98 {

	TreeNode f = null;

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (!isValidBST(root.left))
			return false;
		if (f != null && f.val >= root.val)
			return false;
		f = root;
		return isValidBST(root.right);
	}
}
