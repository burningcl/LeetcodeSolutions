package com.skyline.leetcode.solution;

import java.util.Map;
import java.util.TreeMap;

/**
 * 132 Pattern
 * 
 * https://leetcode.com/problems/132-pattern/
 * 
 * @author jairus
 *
 */
public class Q456 {
	// public boolean find132pattern(int[] nums) {
	// if (nums == null || nums.length < 3) {
	// return false;
	// }
	// TreeMap<Integer, Integer> leftMap = new TreeMap<>();
	// TreeMap<Integer, Integer> rightMap = new TreeMap<>();
	// for (int i = 0; i < nums.length; i++) {
	// Integer cnt = rightMap.get(nums[i]);
	// if (cnt == null) {
	// cnt = 1;
	// } else {
	// cnt++;
	// }
	// rightMap.put(nums[i], cnt);
	// }
	// for (int i = 0; i < nums.length; i++) {
	// int num = nums[i];
	// Integer rightMax = rightMap.lowerKey(num);
	// if (rightMax != null) {
	// Integer leftMax = leftMap.lowerKey(rightMax);
	// if (leftMax != null) {
	// return true;
	// }
	// }
	// Integer cnt = rightMap.get(num);
	// if (cnt <= 1) {
	// rightMap.remove(num);
	// } else {
	// rightMap.put(num, cnt - 1);
	// }
	// cnt = leftMap.get(num);
	// if (cnt == null) {
	// cnt = 1;
	// } else {
	// cnt++;
	// }
	// leftMap.put(nums[i], cnt);
	// }
	// return false;
	// }

	public boolean find132pattern(int[] nums) {
		if (nums == null || nums.length < 3) {
			return false;
		}
		TreeMap<Integer, Integer> rightMap = new TreeMap<>();
		int leftMin = nums[0];
		for (int i = 1; i < nums.length; i++) {
			Integer cnt = rightMap.get(nums[i]);
			rightMap.put(nums[i], cnt == null ? 1 : cnt + 1);
		}
		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			Integer rightMax = rightMap.lowerKey(num);
			if (rightMax != null && leftMin < rightMax) {
				return true;
			}
			Integer cnt = rightMap.get(num);
			if (cnt <= 1) {
				rightMap.remove(num);
			} else {
				rightMap.put(num, cnt - 1);
			}
			if (leftMin > num) {
				leftMin = num;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Q456 q = new Q456();
		int[] nums1 = { 1, 2, 3, 4 };
		System.out.println(q.find132pattern(nums1));
		int[] nums2 = { 3, 1, 4, 2 };
		System.out.println(q.find132pattern(nums2));
		int[] nums3 = { -1, 3, 2, 0 };
		System.out.println(q.find132pattern(nums3));
		int[] nums4 = { -2, 1, 2, -2, 1, 2 };
		System.out.println(q.find132pattern(nums4));
		int[] nums5 = { 4, 1, 3, 2 };
		System.out.println(q.find132pattern(nums5));
	}

}
