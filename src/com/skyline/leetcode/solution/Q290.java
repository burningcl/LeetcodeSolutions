package com.skyline.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Word Pattern
 * 
 * https://leetcode.com/problems/word-pattern/
 * 
 * @author jairus
 *
 */
public class Q290 {

	public boolean wordPattern(String pattern, String str) {
		if (pattern == null || str == null) {
			return false;
		}
		String[] map = new String[26];
		Set<String> set = new HashSet<>();
		char[] pcs = pattern.toCharArray();
		String[] strs = str.split(" ");
		if (pcs.length != strs.length) {
			return false;
		}
		for (int i = 0; i < pcs.length; i++) {
			char c = pcs[i];
			int index = c - 'a';
			String s = strs[i];
			if (map[index] == null) {
				if (set.contains(s)) {
					return false;
				}
				map[index] = s;
				set.add(s);
			} else if (!map[index].equals(s)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new Q290().wordPattern("abba", "dog cat cat dog"));
		System.out.println(new Q290().wordPattern("abba", "dog cat cat fish"));
		System.out.println(new Q290().wordPattern("abba", "dog dog dog dog"));
	}

}
