package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * 3Sum Closest
 * 
 * https://leetcode.com/problems/3sum-closest/
 * 
 * @author jairus
 *
 */
public class Q16 {

	public int threeSumClosest(int[] nums, int target) {
		int sum = 0;
		if (nums == null || nums.length < 3) {
			return sum;
		}
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int l = target - nums[i] - nums[j];
				int low = j + 1;
				int high = nums.length - 1;
				int mid = 0;
				while (low <= high) {
					mid = (low + high) / 2;
					if (nums[mid] == l) {
						return target;
					} else if (nums[mid] < l) {
						low = mid + 1;
					} else {
						high = mid - 1;
					}
				}
				for (int k = mid - 1; k <= mid + 1; k++) {
					if (k < 0 || k >= nums.length || k == i || k == j) {
						continue;
					}
					int d = l - nums[k];
					if (d < 0) {
						d = -d;
					}
					if (d < min) {
						min = d;
						sum = nums[i] + nums[j] + nums[k];
					}
				}
			}
		}
		return sum;
	}

	public static void main(String... strings) {
		Q16 q = new Q16();
		int[] nums = { 0, 1, 2 };
		for (int i = 0; i < 20; i++) {
			System.out.println(q.threeSumClosest(nums, i - 10));
		}
	}
}
