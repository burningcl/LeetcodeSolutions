package com.skyline.leetcode.solution;

/**
 * House Robber
 * 
 * https://leetcode.com/problems/house-robber/
 * 
 * @author jairus
 *
 */
public class Q198 {

	public int rob(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return 0;
		} else if (nums.length == 1) {
			return nums[0];
		}
		nums[1] = nums[1] > nums[0] ? nums[1] : nums[0];
		for (int i = 2; i < nums.length; i++) {
			nums[i] += nums[i - 2];
			if (nums[i] < nums[i - 1]) {
				nums[i] = nums[i - 1];
			}
		}
		return nums[nums.length - 1];
	}

	// []
	public static void main(String[] args) {
		Q198 q=new Q198();
		int[] nums={1,0,3,5,2,0,1,4,6,9,4,7,0,10,2,4,7,6,9,3,1,3,6,1,7,3,7,8,2,9,0,3,6,2,1,6,7,8,9,3,5,3,6,3,7,5,6,2,8,0,1,2,3,5,2,4,7,3,6,3,5};
		System.out.println(q.rob(nums));
	}

}
