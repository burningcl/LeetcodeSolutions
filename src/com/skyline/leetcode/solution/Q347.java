package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Top K Frequent Elements
 * 
 * https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * @author jairus
 *
 */
public class Q347 {
	public List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> list = new ArrayList<>();
		if (nums == null || nums.length <= 0 || k <= 0) {
			return list;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			Integer cnt = map.get(num);
			if (cnt == null) {
				cnt = 0;
			}
			cnt++;
			map.put(num, cnt);
		}
		List<Map.Entry<Integer, Integer>> list1 = new ArrayList<Map.Entry<Integer, Integer>>();
		list1.addAll(map.entrySet());
		list1.sort(new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getValue() - o1.getValue();
			}
		});
		for (int i = 0; i < k; i++) {
			list.add(list1.get(i).getKey());
		}
		return list;
	}
}
