package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 
 * @author jairus
 *
 */
public class Q398 {

	public class Solution {

		Map<Integer, List<Integer>> map = null;

		Random ran = new Random();

		public Solution(int[] nums) {
			map = new HashMap<>();
			for (int i = 0; i < nums.length; i++) {
				List<Integer> list = map.get(nums[i]);
				if (list == null) {
					list = new ArrayList<>();
					map.put(nums[i], list);
				}
				list.add(i);
			}
		}

		public int pick(int target) {
			List<Integer> list = map.get(target);
			if (list == null) {
				return -1;
			}
			return list.get(ran.nextInt(list.size()));
		}

	}

	public static void main(String... strings) {

	}
}
