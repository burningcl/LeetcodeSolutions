package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * Patching Array
 * 
 * https://leetcode.com/problems/patching-array/
 * 
 * @author jairus
 *
 */
// public class Q330 {
//
// private boolean found(Map<Integer, Integer> map, int target) {
// Set<Integer> set = map.keySet();
// if (map.get(target) != null && map.get(target) > 0) {
// return true;
// }
// for (int a : set) {
// if (target < a) {
// continue;
// }
// int cnt = map.get(a);
// if (cnt == 0) {
// continue;
// }
// if (a == target) {
// return true;
// }
// map.put(a, cnt - 1);
// boolean found = found(map, target - a);
// map.put(a, cnt);
// if (found) {
// return true;
// }
// }
// return false;
// }
//
// public int minPatches(int[] nums, int n) {
// int patch = 0;
// Map<Integer, Integer> map = new HashMap<>();
// int max = 0;
// for (int num : nums) {
// Integer cnt = map.get(num);
// if (cnt == null) {
// cnt = 0;
// }
// cnt++;
// map.put(num, cnt);
// max += num;
// }
// for (int i = 1; i <= max && i <= n; i++) {
// boolean found = found(map, i);
// if (!found) {
// //System.out.println(i);
// map.put(i, 1);
// patch++;
// max += i;
// i = 2 * i - 1;
// }
// //System.out.println(i + ", " + found);
// }
// while (max < n && max >= 0) {
// System.out.println(max);
// max = 2 * max + 1;
// patch++;
// }
// return patch;
// }
//
// public static void main(String... strings) {
// int[] nums =
// {2,3,3,4,6,8,8,10,10,10,12,13,13,14,15,15,16,17,19,20,20,21,21,21,23,23,24,25,26,27,27,28,28,29,29,30,30,31,31,32,32,32,36,36,38,41,41,41,43,44,46,46,46,48,48,49,50,51,51,52,52,53,54,55,56,56,58,58,58,59,60,60,60,61,63,63,66,66,70,70,73,74,74,75,78,80,81,83,85,87,87,89,89,89,90,90,92,92,96,98};
// int n = 60844;
// System.out.println(new Q330().minPatches(nums, n));
// }
// }

public class Q330 {

	public int minPatches(int[] nums, int n) {
		Arrays.sort(nums);
		int sum = 0;
		int index = 0;
		int patch = 0;
		while (sum >= 0 && sum < n) {
			// System.out.println(sum);
			if (index >= nums.length) {
				sum = sum * 2 + 1;
				patch++;
			} else if (sum < nums[index]) {
				if (sum < nums[index] - 1) {
					sum = sum * 2 + 1;
					patch++;
				} else {
					sum += nums[index];
					index++;
				}
			} else if (sum == nums[index]) {
				sum += nums[index];
				index++;
			} else {
				while (index < nums.length && nums[index] < sum) {
					sum += nums[index];
					index++;
				}
			}
		}
		return patch;
	}

	public static void main(String... strings) {
		int[] nums = { 1, 3 };
		int n = 6;
		System.out.println(new Q330().minPatches(nums, n) == 1);
		int[] nums1 = {};
		int n1 = Integer.MAX_VALUE;
		System.out.println(new Q330().minPatches(nums1, n1) == 31);
		int[] nums2 = { 1, 5, 10 };
		int n2 = 20;
		System.out.println(new Q330().minPatches(nums2, n2) == 2);
		int[] nums3 = { 1, 2, 2 };
		int n3 = 5;
		System.out.println(new Q330().minPatches(nums3, n3) == 0);
	}
}
