package com.skyline.leetcode.solution;

/**
 * Next Permutation
 * 
 * https://leetcode.com/problems/next-permutation/
 * 
 * @author jairus
 *
 */
public class Q31 {

	public void swap(int[] nums, int i, int j) {
		if (nums[i] == nums[j]) {
			return;
		}
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}

	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return;
		}
		if (nums[nums.length - 1] > nums[nums.length - 2]) {
			swap(nums, nums.length - 1, nums.length - 2);
			return;
		}
		int i = nums.length - 2;
		for (; i >= 1 && nums[i] <= nums[i - 1]; i--) {
		}
		if (i > 0) {
			int j = nums.length - 1;
			for (; j >= i && nums[j] <= nums[i - 1]; j--) {
			}
			swap(nums, i - 1, j);
		}
		int j = nums.length - 1;
		while (i < j) {
			swap(nums, i++, j--);
		}
	}

	public static void main(String[] args) {
		int n = 5;
		int total = 1;
		int[] nums = new int[n];
		for (int i = 1; i <= n; i++) {
			nums[i - 1] = i;
			total *= i;
		}
		Q31 q = new Q31();
		for (int i = 0; i < 2 * total; i++) {
			System.out.println(i);
			q.nextPermutation(nums);
			for (int j = 0; j < n; j++) {
				System.out.print(nums[j] + ",\t");
			}
			System.out.println();
		}

	}

}
