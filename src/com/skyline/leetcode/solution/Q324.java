package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * Wiggle Sort II
 * 
 * https://leetcode.com/problems/wiggle-sort-ii/
 * 
 * @author jairus
 *
 */
public class Q324 {

	public void wiggleSort(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		Arrays.sort(nums);
		int[] t = new int[nums.length];
		int mid = nums.length / 2;
		if (nums.length % 2 == 1) {
			mid++;
		}
		for (int i = 0; i < mid; i++) {
			t[i * 2] = nums[mid - i - 1];
			if (i * 2 + 1 <nums.length)
				t[i * 2 + 1] = nums[nums.length - i - 1];
		}
		for(int i=0;i<nums.length;i++){
			nums[i]=t[i];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
