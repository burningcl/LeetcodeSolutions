package com.skyline.leetcode.solution;

public class ArrayUtil {

	public static void print(int[] nums) {
		if (nums == null)
			return;
		for (int num : nums) {
			System.out.print(num + "\t");
		}
		System.out.println();
	}
}
