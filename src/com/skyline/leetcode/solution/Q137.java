package com.skyline.leetcode.solution;

/**
 * Single Number II
 * 
 * https://leetcode.com/problems/single-number-ii/
 * 
 * @author jairus
 *
 */
public class Q137 {

	public int singleNumber(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		int ret = 0;
		for (int i = 0; i < 32; i++) {
			int mask = 1 << i;
			int cnt = 0;
			for (int num : nums) {
				if ((num & mask) != 0) {
					cnt++;
				}
			}
			if (cnt % 3 == 1) {
				ret += mask;
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		Q137 q = new Q137();

		int[] nums = { 1 };
		System.out.println(q.singleNumber(nums));

	}

}
