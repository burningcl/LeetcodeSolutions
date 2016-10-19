package com.skyline.leetcode.solution;

/**
 * Same Tree
 * 
 * https://leetcode.com/problems/same-tree/
 * 
 * @author jairus
 *
 */
public class Q100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p != null && q != null) {
			return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		return p == q;
	}

}
