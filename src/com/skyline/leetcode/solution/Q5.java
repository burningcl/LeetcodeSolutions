package com.skyline.leetcode.solution;

/**
 * Longest Palindromic Substring
 * 
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 
 * @author jairus
 *
 */
public class Q5 {

	public String longestPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		int start = 0;
		int end = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < s.length(); i++) {
			boolean validOdd = true;
			boolean validEven = true;
			for (int j = 0; (validOdd || validEven) && j <= i && i + j < s.length(); j++) {
				if (validOdd && i + j < s.length()) {
					if (s.charAt(i - j) == s.charAt(i + j)) {
						if (2 * j + 1 > max) {
							max = 2 * j + 1;
							start = i - j;
							end = i + j;
						}
					} else {
						validOdd = false;
					}
				}
				if (validEven && i + j + 1 < s.length()) {
					if (s.charAt(i - j) == s.charAt(i + j + 1)) {
						if (2 * j + 2 > max) {
							max = 2 * j + 2;
							start = i - j;
							end = i + j + 1;
						}
					} else {
						validEven = false;
					}
				}
			}
		}
		return s.substring(start, end + 1);
	}

	public static void main(String... strings) {
		Q5 q = new Q5();
		System.out.println(q.longestPalindrome("kkabcball"));
		System.out.println(q.longestPalindrome("kkabball"));
		System.out.println(q.longestPalindrome("a"));
		System.out.println(q.longestPalindrome("ab"));
		System.out.println(q.longestPalindrome("aba"));
		System.out.println(q.longestPalindrome("aa"));
		System.out.println(q.longestPalindrome("aaabaaaa"));
	}
}
