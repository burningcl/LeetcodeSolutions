package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4Sum
 * 
 * https://leetcode.com/problems/4sum/
 * 
 * @author jairus
 *
 */
public class Q18 {

	// int time = 0;
	//
	// public List<List<Integer>> sum(int[] nums, int level, final int
	// totalLevel, int startPos, int target, int[] path,
	// Map<Integer, Integer> map) {
	// //System.out.println(++time + ", " + level);
	// List<List<Integer>> list = null;
	// if (startPos >= nums.length) {
	// return null;
	// } else if (level >= totalLevel) {
	// Integer cnt = map.get(target);
	// if (cnt != null && cnt > 0) {
	// list = new ArrayList<>();
	// List<Integer> subList = new ArrayList<>();
	// for (int i = 0; i < totalLevel; i++) {
	// subList.add(path[i]);
	// }
	// subList.add(target);
	// list.add(subList);
	// }
	// } else {
	// for (int i = startPos; i < nums.length; i++) {
	// map.put(nums[i], map.get(nums[i]) - 1);
	// if (i > startPos && nums[i] == nums[i - 1]) {
	// continue;
	// }
	// path[level] = nums[i];
	// List<List<Integer>> subList = sum(nums, level + 1, totalLevel, i + 1,
	// target - nums[i], path, map);
	// if (subList != null && subList.size() > 0) {
	// if (list == null)
	// list = new ArrayList<>();
	// list.addAll(subList);
	// }
	// }
	// }
	// return list;
	// }
	//
	// public List<List<Integer>> fourSum(int[] nums, int target) {
	// List<List<Integer>> list = new ArrayList<>();
	// if (nums == null || nums.length < 4) {
	// return list;
	// }
	// Arrays.sort(nums);
	// Map<Integer, Integer> map = new HashMap<>();
	// for (int num : nums) {
	// Integer cnt = map.get(num);
	// if (cnt == null) {
	// cnt = 0;
	// }
	// cnt++;
	// map.put(num, cnt);
	// }
	// List<List<Integer>> ret = sum(nums, 0, 3, 0, target, new int[4], map);
	// if (ret == null) {
	// return list;
	// } else {
	// return ret;
	// }
	// }

	public List<List<Integer>> sum(int[] nums, int level, int totalLevel, int startPos, int target, int[] path) {
		List<List<Integer>> list = null;
		if (startPos >= nums.length) {
			return list;
		} else if (level >= totalLevel) {
			int low = startPos;
			int high = nums.length - 1;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (nums[mid] == target) {
					list = new ArrayList<>();
					List<Integer> subList = new ArrayList<>();
					for (int i = 0; i < totalLevel; i++) {
						subList.add(path[i]);
					}
					subList.add(nums[mid]);
					list.add(subList);
					break;
				} else if (nums[mid] < target) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		} else {
			for (int i = startPos; i < nums.length; i++) {
				if (i > startPos && nums[i] == nums[i - 1]) {
					continue;
				}
				path[level] = nums[i];
				List<List<Integer>> subList = sum(nums, level + 1, totalLevel, i + 1, target - nums[i], path);
				if (subList != null && subList.size() > 0) {
					if (list == null)
						list = new ArrayList<>();
					list.addAll(subList);
				}
			}
		}
		return list;
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		if (nums == null || nums.length < 4) {
			return list;
		}
		Arrays.sort(nums);
		List<List<Integer>> ret = sum(nums, 0, 3, 0, target, new int[4]);
		return ret == null ? list : ret;
	}

	public static void main(String... strings) {
		// Q18 q = new Q18();
		// int[] nums = { -497, -488, -488, -484, -463, -463, -442, -402, -397,
		// -394, -384, -380, -361, -358, -355, -350,
		// -344, -338, -333, -330, -328, -325, -305, -301, -292, -290, -272,
		// -262, -220, -202, -189, -172, -166,
		// -162, -137, -133, -121, -90, -69, -68, -55, -51, -50, -44, -44, -38,
		// -36, -14, -4, 15, 22, 38, 75, 91,
		// 110, 148, 155, 157, 160, 166, 170, 191, 205, 215, 219, 223, 223, 235,
		// 255, 267, 277, 280, 282, 300, 314,
		// 315, 330, 361, 393, 412, 419, 461, 478, 497 };
		// long t1 = System.currentTimeMillis();
		// List<List<Integer>> list = q.fourSum(nums, 2873);
		// long t2 = System.currentTimeMillis();
		// System.out.println(nums.length + "\t" + list.size() + "\t" + (t2 -
		// t1));
		// for (List<Integer> subList : list) {
		// for (Integer i : subList) {
		// System.out.print(i + "\t");
		// }
		// System.out.println();
		// }

		Q18 q = new Q18();
		int[] nums = { 1, -2, -5, -4, -3, 3, 3, 5 };
		long t1 = System.currentTimeMillis();
		List<List<Integer>> list = q.fourSum(nums, -11);
		long t2 = System.currentTimeMillis();
		System.out.println(nums.length + "\t" + list.size() + "\t" + (t2 - t1));
		for (List<Integer> subList : list) {
			for (Integer i : subList) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}
}
