package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Palindrome Partitioning
 * 
 * https://leetcode.com/problems/palindrome-partitioning/
 * 
 * @author jairus
 *
 */
public class Q131 {

	private boolean isPalindrome(String str, int i, int j) {
		while (i < j) {
			if (str.charAt(i++) != str.charAt(j--)) {
				return false;
			}
		}
		return true;
	}

	public List<List<String>> partition(String s, int index) {
		if (map.get(index) != null) {
			return map.get(index);
		}
		List<List<String>> list = new ArrayList<>();
		int end = s.length();
		for (int i = index + 1; i <= end; i++) {

			if (!isPalindrome(s, index, i - 1)) {
				continue;
			}
			String first = s.substring(index, i);
			List<List<String>> rest = this.partition(s, i);
			for (List<String> r1 : rest) {
				List<String> sub = new ArrayList<>();
				sub.add(first);
				sub.addAll(r1);
				list.add(sub);
			}
		}
		if (list.size() <= 0) {
			list.add(new ArrayList<>());
		}
		map.put(index, list);
		return list;
	}

	Map<Integer, List<List<String>>> map = null;

	public List<List<String>> partition(String s) {
		if (s == null) {
			s = "";
		}
		map = new HashMap<>();
		return this.partition(s, 0);
	}

	public static void main(String[] args) {
		Q131 q = new Q131();
		System.out.println(q.partition("aaa"));
		System.out.println(q.partition("aba"));
		System.out.println(q.partition("aab"));
		System.out.println(q.partition("aabbccbbaa"));
		System.out.println(q.partition(""));
		System.out.println(q.partition("a"));
	}

}
