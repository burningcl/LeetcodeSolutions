package com.skyline.leetcode.solution;

/**
 * Product of Array Except Self
 * 
 * https://leetcode.com/problems/product-of-array-except-self/
 * 
 * @author jairus
 *
 */
public class Q238 {

	public int[] productExceptSelf(int[] nums) {
		if (nums == null ) {
			return null;
		}else if(nums.length <= 0){
			return new int[0];
		}
		int[] ret = new int[nums.length];
		ret[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			ret[i] = ret[i - 1] * nums[i - 1];
		}
		for (int i = nums.length - 1; i >= 1; i--) {
			ret[0] *= nums[i];
			if (i > 1)
				ret[i - 1] *= ret[0];
		}
		return ret;
	}
}
