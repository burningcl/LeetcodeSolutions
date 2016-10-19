package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Combination Sum II
 * 
 * https://leetcode.com/problems/combination-sum-ii/
 * 
 * @author jairus
 *
 */
public class Q40 {
	public List<List<Integer>> combinationSum(final List<Integer> nums, final int target, final int index,
			final Map<Integer, Integer> map) {
		if (index >= nums.size() || nums.get(index) > target) {
			return null;
		}
		List<List<Integer>> list = null;
		if (nums.get(index) == target && map.get(target) > 0) {
			List<Integer> sub = new ArrayList<>();
			sub.add(target);
			if (list == null) {
				list = new ArrayList<>();
			}
			list.add(sub);
		}

		List<List<Integer>> list1 = combinationSum(nums, target, index + 1, map);
		if (list1 != null) {
			if (list == null) {
				list = list1;
			} else {
				list.addAll(list1);
			}
		}

		int num = nums.get(index);
		if (map.get(num) > 0) {
			map.put(num, map.get(num) - 1);
			List<List<Integer>> list2 = combinationSum(nums, target - num, index, map);
			if (list2 != null && list2.size() > 0) {
				if (list == null) {
					list = new ArrayList<>();
				}
				for (List<Integer> sub : list2) {
					if (sub != null && sub.size() > 0) {
						sub.add(0, num);
						list.add(sub);
					}
				}
			}
			map.put(num, map.get(num) + 1);
		}

		return list;
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> list = null;
		if (candidates != null && candidates.length > 0) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int num : candidates) {
				if (map.containsKey(num)) {
					map.put(num, map.get(num) + 1);
				} else {
					map.put(num, 1);
				}
			}
			Set<Integer> set = map.keySet();
			List<Integer> nums = new ArrayList<>();
			for (int num : set) {
				nums.add(num);
			}
			Collections.sort(nums);
			list = combinationSum(nums, target, 0, map);
		}
		if (list == null) {
			list = new ArrayList<>();
		}
		return list;
	}

	public static void main(String... strings) {
		int[] nums = { 1,1 };
		int target = 2;
		Q40 q = new Q40();
		List<List<Integer>> list = q.combinationSum2(nums, target);
		for (List<Integer> s : list) {
			for (int i : s) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}
}
