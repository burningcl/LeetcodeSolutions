package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Permutations II
 * 
 * https://leetcode.com/problems/permutations-ii/
 * 
 * @author jairus
 *
 */
public class Q47 {

	public void swap(int[] nums, int i, int j) {
		if (i == j) {
			return;
		}
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}

	public void permute(int[] nums, int index, Map<Integer, Object> map, List<List<Integer>> list) {
		if (index == nums.length - 1) {
			List<Integer> sub = new ArrayList<>();
			for (int num : nums) {
				sub.add(num);
			}
			list.add(sub);
			return;
		}

		for (int i = index; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				continue;
			}
			Map<Integer, Object> sub = new HashMap<>();
			map.put(nums[i], sub);
			swap(nums, index, i);
			permute(nums, index + 1, sub, list);
			swap(nums, index, i);
		}
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Map<Integer, Object> map = new HashMap<>();
		permute(nums, 0, map, list);
		return list;
	}

	public static void main(String... strings) {
		Q47 q = new Q47();
		int[] nums = { 1, 1, 2, 2 };
		List<List<Integer>> list = q.permuteUnique(nums);
		for (List<Integer> sub : list) {
			for (int i : sub) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}

}
