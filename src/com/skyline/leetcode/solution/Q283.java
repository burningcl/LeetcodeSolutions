package com.skyline.leetcode.solution;

/**
 * Move Zeroes
 * 
 * https://leetcode.com/problems/move-zeroes/
 * 
 * @author jairus
 *
 */
public class Q283 {

	public void moveZeroes(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				continue;
			}
			nums[j] = nums[i];
			j++;
		}
		for (; j < nums.length; j++) {
			nums[j] = 0;
		}
	}

	public static void main(String[] args) {
		Q283 q=new Q283();
		int[] nums={3, 1, 4, 3, 12};
		q.moveZeroes(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
	}

}
