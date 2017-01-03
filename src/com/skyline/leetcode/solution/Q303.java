package com.skyline.leetcode.solution;

/**
 * Range Sum Query - Immutable
 * 
 * https://leetcode.com/problems/range-sum-query-immutable/
 * 
 * @author jairus
 *
 */
public class Q303 {

	public static class NumArray {

		int[] cache;
		
		int len;

		public NumArray(int[] nums) {
			if (nums == null || nums.length <= 0) {
				len = 0;
				return;
			}
			len = nums.length;
			cache = new int[len + 1];
			for (int i = 0; i < len; i++) {
				cache[i + 1] = cache[i] + nums[i];
			}
		}

		public int sumRange(int i, int j) {
			if (i < 0 || j < i || j >= len) {
				return 0;
			} else {
				return cache[j + 1] - cache[i];
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = { -2, 0, 3, -5, 2, -1 };
		NumArray q = new NumArray(nums);
		System.out.println(q.sumRange(0, 2));
		System.out.println(q.sumRange(2, 5));
		System.out.println(q.sumRange(0, 5));
		System.out.println(q.sumRange(1, 3));
	}

}
