package com.skyline.leetcode.solution;

/**
 * Wiggle Subsequence
 * 
 * https://leetcode.com/problems/wiggle-subsequence/
 * 
 * @author jairus
 *
 */
public class Q376 {

	public int wiggleMaxLength(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		} else if (nums.length == 1) {
			return 1;
		} else if (nums.length == 2) {
			if (nums[0] == nums[1]) {
				return 1;
			} else {
				return 2;
			}
		}

		int c = 1;
		int num = 1;
		boolean up = false;
		for (; c < nums.length; c++) {
			if (nums[c] != nums[c - 1]) {
				up = nums[c] > nums[c - 1];
				num++;
				break;
			}
		}
		for (int i = c + 1; i < nums.length; i++) {

			if (up) {
				if (nums[i] < nums[c]) {
					num++;
					up = false;
				}
			} else {
				if (nums[i] > nums[c]) {
					num++;
					up = true;
				}
			}
			c = i;
			//System.out.println(i + ", " + up + ", " + num + " , " + c);
		}
		return num;
	}

	public static void main(String... strings) {
		int[] nums = { 1,17,5,10,13,15,10,5,16,8 };
		System.out.println(new Q376().wiggleMaxLength(nums));
	}
}
