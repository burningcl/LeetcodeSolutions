package com.skyline.leetcode.solution;

/**
 * Combination Sum IV
 * 
 * https://leetcode.com/problems/combination-sum-iv/
 * 
 * @author jairus
 *
 */
public class Q377 {

	int[] cache;

	public int combinationSum4(int[] nums, int target) {
		if (nums == null || nums.length <= 0 || target < 0) {
			return 0;
		}

		cache = new int[target + 1];
		for (int i = 0; i < target + 1; i++) {
			cache[i] = -1;
		}
		cache[0] = 1;
		return count(nums, target);
	}

	private int count(int[] nums, int target) {
		if (target < 0) {
			return 0;
		} else if (cache[target] >= 0) {
			return cache[target];
		}

		int total = 0;
		for (int num : nums) {
			total += count(nums, target - num);
		}
		cache[target] = total;
		return total;
	}

	public static void main(String... strings) {
		int[] nums = { 1, 2, 3 };
		int target = 32;
		System.out.println(new Q377().combinationSum4(nums, target));
	}

}
