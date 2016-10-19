package com.skyline.leetcode.solution;

/**
 * Remove Duplicates from Sorted Array
 * 
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * 
 * @author jairus
 *
 */
public class Q26 {

	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length <= 1) {
			return nums.length;
		}
		int val = nums[0];
		int cnt = 1;
		int pos = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != val) {
				val = nums[i];
				cnt++;
				nums[pos] = nums[i];
				pos++;
			}
		}
		return cnt;
	}

	public static void main(String... strings) {
		Q26 q = new Q26();
		int[] nums = { 1, 1, 2, 2, 3, 3, 4 };
		System.out.println(q.removeDuplicates(nums));
	}

}
