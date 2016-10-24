package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Word Break II
 * 
 * https://leetcode.com/problems/word-break-ii/
 * 
 * @author jairus
 *
 */
public class Q140 {

	public boolean wordBreak(String s, boolean[][] map, int i, List<String> list, List<Integer> indexes,
			Set<Integer> failedSet) {
		if (failedSet.contains(i)) {
			return false;
		}
		if (i >= s.length()) {
			int start = 0;
			StringBuilder sb = new StringBuilder();
			for (int end : indexes) {
				sb.append(s.substring(start, end));
				if (end < s.length())
					sb.append(" ");
				start = end;
			}
			return list.add(sb.toString());
		}
		boolean success = false;
		for (int j = i; j < s.length(); j++) {
			if (map[i][j]) {
				indexes.add(j + 1);
				if (wordBreak(s, map, j + 1, list, indexes, failedSet)) {
					success = true;
				}
				indexes.remove(indexes.size() - 1);
			}
		}
		if (!success) {
			failedSet.add(i);
		}
		return success;
	}

	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> list = new ArrayList<>();
		if (s == null || s.length() <= 0) {
			return list;
		}
		if (wordDict == null || wordDict.size() <= 0) {
			return list;
		}
		int minLen = Integer.MAX_VALUE;
		int maxLen = Integer.MIN_VALUE;
		for (String word : wordDict) {
			if (word.length() > maxLen) {
				maxLen = word.length();
			}
			if (word.length() < minLen) {
				minLen = word.length();
			}
		}
		boolean[][] map = new boolean[s.length()][s.length()];
		for (int i = 0; i <= s.length() - minLen; i++) {
			for (int j = i + minLen; j <= i + maxLen && j <= s.length(); j++) {
				String str = s.substring(i, j);
				if (wordDict.contains(str)) {
					map[i][j - 1] = true;
				}
			}
		}
		List<Integer> indexes = new ArrayList<>();
		Set<Integer> failedSet = new HashSet<>();
		this.wordBreak(s, map, 0, list, indexes, failedSet);
		return list;
	}

	private static Set<String> toSet(String[] array) {
		Set<String> set = new HashSet<>();
		for (String str : array) {
			set.add(str);
		}
		return set;
	}

	public static void main(String[] args) {
		Q140 q = new Q140();
		String[] array = { "leet", "code" };
		System.out.println(q.wordBreak("leetcode", toSet(array)));
		System.out.println(q.wordBreak("codeleetleetcode", toSet(array)));

		String[] array1 = { "cat", "cats", "and", "sand", "dog" };
		System.out.println(q.wordBreak("catsanddog", toSet(array1)));

		String[] array2 = { "cat", "cats", "and", "sand", "dog", "dogs", "s" };
		System.out.println(q.wordBreak("catsanddogs", toSet(array2)));

		String[] array3 = { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
				"aaaaaaaaaa" };
		System.out.println(q.wordBreak(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				toSet(array3)));
		
		String[] array4 = { "abc" };
		System.out.println(q.wordBreak("abc", toSet(array4)));

	}

}
