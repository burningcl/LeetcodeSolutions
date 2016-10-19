package com.skyline.leetcode.solution;

/**
 * Search Insert Position
 * 
 * https://leetcode.com/problems/search-insert-position/
 * 
 * @author jairus
 *
 */
public class Q35 {

	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 5, 6 };
		Q35 q = new Q35();
		System.out.println(q.searchInsert(nums, 0));
	}

}
