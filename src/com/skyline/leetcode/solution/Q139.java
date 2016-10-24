package com.skyline.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Word Break
 * 
 * 
 * https://leetcode.com/problems/word-break/
 * 
 * @author jairus
 *
 */
public class Q139 {

	public boolean wordBreak(boolean[][] map, int i, int n) {
		if (i >= n) {
			return true;
		}
		for (int j = i; j < n; j++) {
			if (map[i][j]) {
				if (wordBreak(map, j + 1, n)) {
					return true;
				}
				map[i][j] = false;
			}
		}
		return false;
	}

	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s == null || s.length() <= 0) {
			return true;
		}
		if (wordDict == null || wordDict.size() <= 0) {
			return false;
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
		return this.wordBreak(map, 0, s.length());
	}

	private static Set<String> toSet(String[] array) {
		Set<String> set = new HashSet<>();
		for (String str : array) {
			set.add(str);
		}
		return set;
	}

	public static void main(String... strings) {
		Q139 q = new Q139();
		String[] array = { "leet", "code" };
		System.out.println(q.wordBreak("leetcode", toSet(array)));
		System.out.println(q.wordBreak("codeleet", toSet(array)));
		System.out.println(q.wordBreak("codeleetcode", toSet(array)));
		System.out.println(q.wordBreak("codezzleet", toSet(array)));
		System.out.println(q.wordBreak("codeleeft", toSet(array)));
		String[] array1 = { "ab", "a" };
		System.out.println(q.wordBreak("aba", toSet(array1)));

		long t1 = System.currentTimeMillis();
		String[] array2 = { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
				"aaaaaaaaaa" };
		System.out.println(q.wordBreak(
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
				toSet(array2)));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}
