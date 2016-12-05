package com.skyline.leetcode.solution;

/**
 * Minimum Moves to Equal Array Elements
 * 
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 * 
 * @author jairus
 *
 */
public class Q453 {

	public int minMoves(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return 0;
		}
		int total = 0;
		int min = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			if (num >= min) {
				total += (num - min);
			} else {
				total += (min - num) * i;
				min = num;
			}

		}
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
