package com.skyline.leetcode.solution;

/**
 * Convert Sorted Array to Binary Search Tree
 * 
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * 
 * @author jairus
 * 
 */
public class Q108 {

	private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
		int mid = (start + end) / 2;
		TreeNode t = new TreeNode(nums[mid]);
		if (mid  > start) {
			t.left = sortedArrayToBST(nums, start, mid - 1);
		}
		if (mid  < end) {
			t.right = sortedArrayToBST(nums, mid + 1, end);
		}
		return t;
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return null;
		}
		return this.sortedArrayToBST(nums, 0, nums.length - 1);
	}
}
