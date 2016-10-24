package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum III
 * 
 * https://leetcode.com/problems/combination-sum-iii/
 * 
 * @author jairus
 *
 */
public class Q216 {
	public void combinationSum3(int k, int target, int start, List<Integer> list, List<List<Integer>> ret) {
		if (k <= 0 || start > 9) {
			return;
		}
		if (k == 1) {
			if (target >= start && target <= 9) {
				List<Integer> list2 = new ArrayList<>();
				list2.addAll(list);
				list2.add(target);
				ret.add(list2);
			}
			return;
		}
		for (int i = start; i <= 9 - k + 1; i++) {
			list.add(i);
			this.combinationSum3(k - 1, target - i, i + 1, list, ret);
			list.remove(list.size() - 1);
		}
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> list = new ArrayList<>();
		this.combinationSum3(k, n, 1, new ArrayList<>(), list);
		return list;
	}

	public static void main(String[] args) {
		Q216 q = new Q216();
		System.out.println(q.combinationSum3(3, 12));

	}

}
