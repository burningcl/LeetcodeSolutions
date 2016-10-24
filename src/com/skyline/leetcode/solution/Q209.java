package com.skyline.leetcode.solution;

/**
 * Minimum Size Subarray Sum
 * 
 * https://leetcode.com/problems/minimum-size-subarray-sum/
 * 
 * @author jairus
 *
 */
public class Q209 {

	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int sum = 0;
		int len = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > s) {
				return 1;
			}
			sum += nums[i];
			len++;
			if (sum >= s) {
				if (len < min) {
					min = len;
				}
				for (int j = i - len + 1; j < i; j++) {
					sum -= nums[j];
					len--;
					if (sum >= s) {
						if (len < min) {
							min = len;
						}
					} else {
						break;
					}
				}
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	public static void main(String[] args) {
		Q209 q = new Q209();
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		System.out.println(q.minSubArrayLen(8, nums));

		System.out.println(q.minSubArrayLen(100, nums));
	}

}
