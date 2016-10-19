package com.skyline.leetcode.solution;

/**
 * First Missing Positive
 * 
 * https://leetcode.com/problems/first-missing-positive/
 * 
 * @author jairus
 *
 */
public class Q41 {
	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			while (num > 0 && num <= nums.length && nums[num - 1] != num) {
				int t = nums[num - 1];
				nums[num - 1] = num;
				num = t;
			}
		}
		int i = 0;
		for (; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return i + 1;
	}

	public static void main(String[] args) {
		Q41 q = new Q41();
		int[] nums1 = { 1, 2, 0 };
		System.out.println(q.firstMissingPositive(nums1));
		int[] nums2 = {};
		System.out.println(q.firstMissingPositive(nums2));
		int[] nums3 = { 2, 5, 4, 1 };
		System.out.println(q.firstMissingPositive(nums3));
		int[] nums4 = { 1, 1, 1, 1 };
		System.out.println(q.firstMissingPositive(nums4));
		int[] nums5 = { 3, 4, -1, 1 };
		System.out.println(q.firstMissingPositive(nums5));
		int[] nums6 = { 1, 2, 3 };
		System.out.println(q.firstMissingPositive(nums6));
	}

}
