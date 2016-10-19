package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Combinations
 * 
 * https://leetcode.com/problems/combinations/
 * 
 * @author jairus
 *
 */
public class Q77 {

	public void combine(final int n, final int start, final int level, final int k, int[] array,
			List<List<Integer>> list) {
		if (level >= k) {
			List<Integer> subList = new ArrayList<>();
			for (int i = 0; i < k; i++) {
				subList.add(array[i]);
			}
			list.add(subList);
			return;
		}
		int end = n - (k - level) + 1;
		for (int i = start; i <= end; i++) {
			array[level] = i;
			combine(n, i + 1, level + 1, k, array, list);
		}
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<>();
		combine(n, 1, 0, k, new int[k], list);
		return list;
	}

	public static void main(String... strings) {
		Q77 q = new Q77();
		System.out.println(q.combine(6, 2));
	}
}
