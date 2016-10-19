package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subsets II
 * 
 * https://leetcode.com/problems/subsets-ii/
 * 
 * @author jairus
 *
 */
public class Q90 {

	private List<Integer> toList(int[] array, int end) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i <= end; i++) {
			list.add(array[i]);
		}
		return list;
	}

	public void subsetsWithDup(int[] nums, int start, List<List<Integer>> collection, int[] array, int arrayIndex) {
		for (int i = start; i < nums.length; i++) {
			int num = nums[i];
			if (collection.size() > 0) {
				List<Integer> f = collection.get(collection.size() - 1);
				if (f.size() > arrayIndex&&f.get(arrayIndex)==num) {
					continue;
				}
			}
			array[arrayIndex] = num;
			collection.add(toList(array, arrayIndex));
			subsetsWithDup(nums, i + 1, collection, array, arrayIndex + 1);
		}
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> collection = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		collection.add(list);
		if (nums == null || nums.length <= 0) {
			return collection;
		}
		Arrays.sort(nums);
		subsetsWithDup(nums, 0, collection, new int[nums.length], 0);
		return collection;
	}

	public static void main(String[] args) {
		Q90 q = new Q90();
		int[] nums1 = { 1, 2, 3 };
		System.out.println(q.subsetsWithDup(nums1));
		int[] nums2 = { 1, 2, 2 };
		System.out.println(q.subsetsWithDup(nums2));
		int[] nums3 = { 1 };
		System.out.println(q.subsetsWithDup(nums3));

	}

}
