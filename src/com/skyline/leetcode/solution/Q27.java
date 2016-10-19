package com.skyline.leetcode.solution;

/**
 * Remove Element
 * 
 * https://leetcode.com/problems/remove-element/
 * 
 * @author jairus
 *
 */
public class Q27 {

	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length <= 0) {
			return 0;
		}
		int len = 0;
		int pos = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[pos++] = nums[i];
				len++;
			}
		}
		return len;
	}

	public static void main(String... strings) {
		int[] array = { 1, 1,2,3,4,5,1,2,3 };
		System.out.println(new Q27().removeElement(array, 1));
		for (int num : array) {
			System.out.print(num + "\t");
		}
	}
}
