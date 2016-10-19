package com.skyline.leetcode.solution;

import java.util.Random;

/**
 * Sort Colors
 * 
 * https://leetcode.com/problems/sort-colors/
 * 
 * 就是荷兰国旗问题
 * 
 * @author jairus
 *
 */
public class Q75 {

	private void swap(int[] nums, int i, int j) {
		if (nums[i] == nums[j])
			return;
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}

	public void sortColors(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return;
		}
		int low = 0;
		int high = nums.length - 1;

		int index = low;
		while (index <= high && low < high) {
			if (nums[index] == 0) {
				swap(nums, low, index);
			} else if (nums[index] == 2) {
				swap(nums, high, index);
			} else {
				index++;
			}
			while (low < nums.length && nums[low] == 0) {
				low++;
			}
			if (index < low)
				index = low;
			while (high >= 0 && nums[high] == 2) {
				high--;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = new int[100];
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			nums[i] = rand.nextInt(3);
		}
		// int[] nums = { 0,0 };
		Q75 q = new Q75();
		q.sortColors(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + "\t");
		}
		System.out.println();
	}

}
