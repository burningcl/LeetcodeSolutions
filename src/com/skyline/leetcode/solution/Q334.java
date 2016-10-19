package com.skyline.leetcode.solution;

/**
 * Increasing Triplet Subsequence
 * 
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 * 
 * @author jairus
 *
 */
public class Q334 {
	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 3) {
			return false;
		}
		int[] array = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int max = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && array[j] > max) {
					max = array[j];
					if (max >= 2) {
						return true;
					}
				}
			}
			array[i] = max + 1;
		}
		return false;

	}
}
