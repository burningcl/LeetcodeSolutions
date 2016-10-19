package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 * 
 * https://leetcode.com/problems/two-sum/
 * 
 * @author jairus
 *
 */
public class Q1 {

	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		int[] ret = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];
			int b = target - a;
			
			if (map.containsKey(b)) {
				if (i == map.get(b)) {
					continue;
				}
				ret[0] = i;
				ret[1] = map.get(b);
				return ret;
			}
		}
		return ret;
	}

	public static void main(String... strings) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		System.out.println(new Q1().twoSum(nums, target)[1]);
	}
}
