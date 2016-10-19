package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Permutations
 * 
 * https://leetcode.com/problems/permutations/
 * 
 * @author jairus
 *
 */
public class Q46 {

	public void swap(int[] nums, int i, int j) {
		if (i == j) {
			return;
		}
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}

	public void permute(int[] nums, int index, List<List<Integer>> list) {
		if (index == nums.length - 1) {
			List<Integer> sub = new ArrayList<>();
			for (int num : nums) {
				sub.add(num);
			}
			list.add(sub);
			return;
		}
		for (int i = index; i < nums.length; i++) {
			swap(nums, index, i);
			permute(nums, index + 1, list);
			swap(nums, index, i);
		}
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		permute(nums, 0, list);
		return list;
	}

	public static void main(String... strings) {
		Q46 q = new Q46();
		int[] nums = { 1,2,3,4};
		List<List<Integer>> list = q.permute(nums);
		for (List<Integer> sub : list) {
			for (int i : sub) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}

}
