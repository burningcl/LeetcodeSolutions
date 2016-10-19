package com.skyline.leetcode.solution;

/**
 * House Robber II
 * 
 * https://leetcode.com/problems/house-robber-ii/
 * 
 * @author jairus
 *
 */
public class Q213 {

	private boolean rob(int[] nums, int[] array, int start, int end) {
		boolean ret = false;
		array[start] = nums[start];
		array[start + 1] = nums[start + 1] > nums[start] ? nums[start + 1] : nums[start];
		for (int i = start + 2; i < end; i++) {
			array[i] = nums[i] + array[i - 2];
			if (array[i] < array[i - 1]) {
				array[i] = array[i - 1];
			} else {
				if (i == start + 2) {
					ret = true;
				}
				if (i == end - 1) {
					ret &= true;
				}
			}
		}
		return ret;
	}

	public int rob(int[] nums) {
		int len = nums.length;
		if (nums == null || len <= 0) {
			return 0;
		} else if (len == 1) {
			return nums[0];
		}

		int[] array = new int[len];
		boolean ret = rob(nums, array, 0, len);
		if (ret) {
			rob(nums, array, 0, len - 1);
			int v1 = array[len - 2];
			rob(nums, array, 1, len);
			int v2 = array[len - 1];
			return v1 > v2 ? v1 : v2;
		} else {
			return array[len - 1];
		}
	}

	public static void main(String[] args) {
		Q213 q = new Q213();
		int[] nums = { 1, 0, 3, 5, 2, 0, 1, 4, 6, 9, 4, 7, 0, 10, 2, 4, 7, 6, 9, 3, 1, 3, 6, 1, 7, 3, 7, 8, 2, 9, 0, 3,
				6, 2, 1, 6, 7, 8, 9, 3, 5, 3, 6, 3, 7, 5, 6, 2, 8, 0, 1, 2, 3, 5, 2, 4, 7, 3, 6, 3 };
		System.out.println(q.rob(nums));
		int[] nums1 = { 1, 0 };
		System.out.println(q.rob(nums1));
		int[] nums2 = { 1, 0, 2 };
		System.out.println(q.rob(nums2));
	}
}
