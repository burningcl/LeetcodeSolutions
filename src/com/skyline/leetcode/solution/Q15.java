package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3Sum
 * 
 * https://leetcode.com/problems/3sum/
 * 
 * @author jairus
 *
 */
public class Q15 {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		if (nums == null || nums.length < 3) {
			return list;
		}
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 1; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int target = 0 - nums[i] - nums[j];
				int low = j + 1;
				int high = nums.length - 1;
				while (low <= high) {
					int mid = (low + high) / 2;
					if (nums[mid] == target) {
						List<Integer> subList = new ArrayList<>();
						subList.add(nums[i]);
						subList.add(nums[j]);
						subList.add(nums[mid]);
						list.add(subList);
						break;
					} else if (nums[mid] < target) {
						low = mid + 1;
					} else {
						high = mid - 1;
					}
				}
			}
		}
		return list;
	}

	public static void main(String... strings) {
		Q15 q = new Q15();
		int[] nums = { -1, 0, 1, 2, -1, 0, 0,2, -4 };
		List<List<Integer>> list = q.threeSum(nums);
		System.out.println(list.size());
		for (List<Integer> subList : list) {
			for (Integer i : subList) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}
}
