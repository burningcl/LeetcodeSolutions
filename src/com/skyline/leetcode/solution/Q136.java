package com.skyline.leetcode.solution;

/**
 * Single Number
 * 
 * https://leetcode.com/problems/single-number/
 * 
 * @author jairus
 *
 */
public class Q136 {
	public int singleNumber(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		int num = 0;
		for (int n : nums) {
			num = num ^ n;
		}
		return num;
	}
}
