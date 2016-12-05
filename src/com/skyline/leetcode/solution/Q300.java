package com.skyline.leetcode.solution;

import java.util.Map;
import java.util.TreeMap;

/**
 * Longest Increasing Subsequence
 * 
 * @author jairus
 *
 */
public class Q300 {

	/**
	 * 解决方案1 o(n*n)
	 * 
	 * @param nums
	 * @return
	 */
	public int lengthOfLIS(int[] nums) {
		if (nums == null) {
			return 0;
		} else if (nums.length <= 1) {
			return nums.length;
		}
		int[] maxLen = new int[nums.length];
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int curMax = 0;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && maxLen[j] > curMax) {
					curMax = maxLen[j];
				}
			}
			maxLen[i] = ++curMax;
			if (curMax > max) {
				max = curMax;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Q300 q = new Q300();
		int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(q.lengthOfLIS(nums));

		int[] nums1 = { 1, 2, 3, 4, 2, 3, 1, 4, 100, 5, 6 };
		System.out.println(q.lengthOfLIS(nums1));

		int[] nums2 = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(q.lengthOfLIS(nums2));
	}

}
