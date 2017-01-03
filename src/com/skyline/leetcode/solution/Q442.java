package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Find All Duplicates in an Array
 * 
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * 
 * @author jairus
 *
 */
public class Q442 {

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> list = new ArrayList<>();
		if (nums == null || nums.length <= 1) {
			return list;
		}
		for (int i = 0; i < nums.length; i++) {
			int j = nums[i];
			if (j <= 0) {
				continue;
			}
			int jj = 0;
			while (j > 0) {
				jj = nums[j - 1];
				nums[j - 1] = 0;
				j = jj;
			}
			list.add(jj);
		}
		return list;
	}

	public static void main(String[] args) {
		Q442 q = new Q442();
		int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(q.findDuplicates(nums));
	}

}
