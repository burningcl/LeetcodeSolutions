package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum
 * 
 * https://leetcode.com/problems/combination-sum/
 * 
 * @author jairus
 *
 */
public class Q39 {

	public List<List<Integer>> combinationSum(final int[] candidates, final int target, final int low, final int high) {
		//System.out.println(low + ", " + high + ", target: " + target);
		if (low > high || candidates[low] > target) {
			return null;
		}
		List<List<Integer>> list = null;
		if (candidates[low] == target) {
			List<Integer> sub = new ArrayList<>();
			sub.add(target);
			list = new ArrayList<>();
			list.add(sub);
		}

		List<List<Integer>> subList1 = combinationSum(candidates, target, low + 1, high);
		if (subList1 != null && subList1.size() > 0) {
			if (list == null)
				list = subList1;
			else
				list.addAll(subList1);
		}
		List<List<Integer>> subList2 = combinationSum(candidates, target - candidates[low], low, high);
		if (subList2 != null && subList2.size() > 0) {
			if (list == null) {
				list = new ArrayList<>();
			}
			for (List<Integer> lList : subList2) {
				lList.add(0, candidates[low]);
			}
			list.addAll(subList2);
		}

		return list;
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> list = null;
		if (candidates != null && candidates.length > 0) {
			Arrays.sort(candidates);
			list = combinationSum(candidates, target, 0, candidates.length - 1);
		}
		if (list == null)
			list = new ArrayList<>();

		return list;
	}

	public static void main(String... strings) {
		int[] nums = { 1,2,3,4,5,6,7};
		int target = 7;
		Q39 q = new Q39();
		List<List<Integer>> list = q.combinationSum(nums, target);
		for (List<Integer> s : list) {
			for (int i : s) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}

}
