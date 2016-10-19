package com.skyline.leetcode.solution;

/**
 * Maximum Subarray
 * 
 * https://leetcode.com/problems/maximum-subarray/
 * 
 * @author jairus
 *
 */
public class Q53 {

	public int maxSubArray(int[] nums) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (sum <= 0) {
				sum = nums[i];
			} else {
				sum += nums[i];
			}
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

	public static void main(String... strings) {
		Q53 q = new Q53();
		int[] nums1 = { -2, -1, -3 };
		System.out.println(q.maxSubArray(nums1));
		int[] nums2 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(q.maxSubArray(nums2));
		int[] nums3 = { 1, 2, 3, 4, 0 };
		System.out.println(q.maxSubArray(nums3));
		int[] nums4 = { 1, 0, 1 };
		System.out.println(q.maxSubArray(nums4));
		int[] nums5 = { 1, -2, 1 };
		System.out.println(q.maxSubArray(nums5));
	}
}
