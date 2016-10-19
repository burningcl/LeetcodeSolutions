package com.skyline.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 * 
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * @author jairus
 *
 */
public class Q3 {
	public int lengthOfLongestSubstring(String s) {
		if (s == null) {
			return 0;
		} else if (s.length() <= 1) {
			return s.length();
		}

		int max = 0;
		char[] cs = s.toCharArray();
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < cs.length; i++) {
			set.clear();
			for (int j = i; j < cs.length; j++) {
				char c = cs[j];
				if (set.contains(c)) {
					break;
				} else {
					set.add(c);
				}
			}
			if (max < set.size()) {
				max = set.size();
			}
		}
		return max;
	}

	public static void main(String... strings) {
		System.out.println(new Q3().lengthOfLongestSubstring("pwwkew"));
	}
}
