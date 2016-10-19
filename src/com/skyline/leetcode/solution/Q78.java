package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subsets
 * 
 * https://leetcode.com/problems/subsets/
 * 
 * @author jairus
 *
 */
public class Q78 {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		ret.add(new ArrayList<>());
		if (nums == null || nums.length <= 0) {
			return ret;
		}
		Arrays.sort(nums);
		List<List<Integer>> former = new ArrayList<>();
		former.add(new ArrayList<>());
		for (int i = 0; i < nums.length; i++) {
			List<List<Integer>> cur = new ArrayList<>();
			for (List<Integer> fs : former) {
				for (int j = i; j < nums.length; j++) {
					if (fs.isEmpty() || fs.get(fs.size() - 1) < nums[j]) {
						List<Integer> cl = new ArrayList<>();
						cl.addAll(fs);
						cl.add(nums[j]);
						ret.add(cl);
						cur.add(cl);
					}
				}
			}
			former = cur;
		}
		return ret;
	}

	public static void main(String[] args) {
		Q78 q = new Q78();
		int[] nums = { 1, 2, 3,4 };
		 List<List<Integer>> subsets=q.subsets(nums) ;
		 System.out.println(subsets);
	}

}
