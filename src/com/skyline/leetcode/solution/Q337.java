package com.skyline.leetcode.solution;

/**
 * House Robber III
 * 
 * https://leetcode.com/problems/house-robber-iii/
 * 
 * @author jairus
 *
 */
public class Q337 {

	public int rob(TreeNode root) {
		int[] ret= r( root);
		return ret[0]>ret[1]?ret[0]:ret[1];
	}

	private int[] r(TreeNode root) {
		int[] ret = new int[2];
		if (root == null) {
			return ret;
		}
		int[] r1 = r(root.left);
		int[] r2 = r(root.right);
		ret[0] = root.val + r1[1] + r2[1];
		ret[1] = r1[0] + r2[0];
		if(ret[0]<ret[1]){
			ret[0]=ret[1];
		}
		return ret;
	}
}
