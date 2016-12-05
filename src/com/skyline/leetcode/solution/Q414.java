package com.skyline.leetcode.solution;

/**
 * Third Maximum Number
 * 
 * https://leetcode.com/problems/third-maximum-number/
 * 
 * @author jairus
 *
 */
public class Q414 {

	public Integer max(int[] nums, int th) {
		if (nums == null || nums.length <= 0) {
			return th;
		}
		Integer max = null;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if ((max == null || num > max) && num < th) {
				max = num;
			}
		}
		return max;
	}

	public int thirdMax(int[] nums) {
		int max = this.max(nums, Integer.MAX_VALUE);
		int maxt = max;
		Integer ret = 0;
		for (int i = 0; i < 2; i++) {
			ret = this.max(nums, maxt);
			if (ret == null) {
				return max;
			}
			maxt = ret;
		}
		return ret;
	}

	public static void main(String[] args) {
		Q414 q = new Q414();
		int[] nums1 = { 3, 2, 1 };
		System.out.println(q.thirdMax(nums1));

		int[] nums2 = { 1, 2 };
		System.out.println(q.thirdMax(nums2));

		int[] nums3 = { 2, 3, 2, 1 };
		System.out.println(q.thirdMax(nums3));

		int[] nums4 = { 2, 3, 2, 1, 5, 6, 7, 8, 9 };
		System.out.println(q.thirdMax(nums4));

		int[] nums5 = { 1, 2, -2147483648 };
		System.out.println(q.thirdMax(nums5));
	}

}
