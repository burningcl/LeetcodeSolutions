package com.skyline.leetcode.solution;

/**
 * Path Sum
 * 
 * https://leetcode.com/problems/path-sum/
 * 
 * @author jairus
 *
 */
public class Q112 {

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		else if (root.val == sum && root.left == null && root.right == null)
			return true;
		if (hasPathSum(root.left, sum - root.val))
			return true;
		return hasPathSum(root.right, sum - root.val);
	}
}
