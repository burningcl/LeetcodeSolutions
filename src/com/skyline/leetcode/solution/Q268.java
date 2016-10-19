package com.skyline.leetcode.solution;

/**
 * Missing Number
 * 
 * https://leetcode.com/problems/missing-number/
 * 
 * @author jairus
 *
 */
public class Q268 {

	public int missingNumber(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == i) {
				continue;
			}
			int k = nums[i];
			while (k < nums.length && nums[k] != k) {
				int t = nums[k];
				nums[k] = k;
				k = t;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i) {
				return i;
			}
		}
		return nums.length;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
