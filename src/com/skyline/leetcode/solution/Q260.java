package com.skyline.leetcode.solution;

/**
 * Single Number III
 * 
 * https://leetcode.com/problems/single-number-iii/
 * 
 * @author jairus
 *
 */
public class Q260 {

	public int[] singleNumber(int[] nums) {
		if (nums.length <= 1) {
			return nums;
		}
		int[] ret = new int[2];
		int total = 0;
		for (int i = 0; i < nums.length; i++) {
			total = total ^ nums[i];
		}
		int mask = 1;
		while ((mask & total) == 0) {
			mask = mask << 1;
		}
		//System.out.println(mask);
		int total1 = 0;
		int total2 = 0;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if ((num & mask) == 0) {
				total1 = total1 ^ num;
			} else {
				total2 = total2 ^ num;
			}
		}
		ret[0] = total1;
		ret[1] = total2;
		return ret;
	}

	public static void main(String... strings) {
		Q260 q = new Q260();
		int[] nums = { 1, 2, 1, 3, 2, 5 };
		int[] ret = q.singleNumber(nums);
		System.out.println(ret[0] + ", " + ret[1]);
	}
}
