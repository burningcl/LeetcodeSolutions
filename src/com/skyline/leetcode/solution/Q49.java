package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Group Anagrams
 * 
 * https://leetcode.com/problems/anagrams/
 * 
 * @author jairus
 *
 */
public class Q49 {

	public String sort(String str) {
		char[] array = str.toCharArray();
		Arrays.sort(array);
		return String.valueOf(array);
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			String key = sort(str);
			List<String> sub = map.get(key);
			if (sub == null) {
				sub = new ArrayList<>();
				map.put(key, sub);
			}
			sub.add(str);
		}
		for (String key : map.keySet()) {
			list.add(map.get(key));
		}
		return list;
	}
}
