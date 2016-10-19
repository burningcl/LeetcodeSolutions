package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains Duplicate II
 * 
 * https://leetcode.com/problems/contains-duplicate-ii/
 * 
 * @author jairus
 *
 */
public class Q219 {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || nums.length <= 1 || k <= 0) {
			return false;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (map.containsKey(num) && i - map.get(num) <= k) {
				return true;
			}
			map.put(num, i);
		}
		return false;
	}
}
