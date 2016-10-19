package com.skyline.leetcode.solution;

/**
 * Is Subsequence
 * 
 * https://leetcode.com/problems/is-subsequence/
 * 
 * @author jairus
 *
 */
public class Q392 {

	public boolean isSubsequence(String s, String t) {
		if (s == null || t == null || s.length() > t.length()) {
			return false;
		}
		int index = 0;
		for (int i = 0; i < t.length() && index < s.length(); i++) {
			if (s.charAt(index) == t.charAt(i)) {
				index++;
			}
		}
		return index >= s.length();
	}

	public static void main(String[] args) {
		Q392 q = new Q392();
		System.out.println(q.isSubsequence("a", "abc"));
		System.out.println(q.isSubsequence("abc", "a1b1c1"));
		System.out.println(q.isSubsequence("abc", "a1b1e1"));
		System.out.println(q.isSubsequence("abc", "abc"));
	}

}
