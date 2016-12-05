package com.skyline.leetcode.solution;

/**
 * Longest Palindrome
 * 
 * https://leetcode.com/problems/longest-palindrome/
 * 
 * @author jairus
 *
 */
public class Q409 {

	public int longestPalindrome(String s) {
		if (s == null) {
			return 0;
		} else if (s.length() <= 1) {
			return s.length();
		}
		int[] array = new int[128];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			array[c]++;
		}
		int oddNum = 0;
		int maxLen = 0;
		for (int i = 0; i < array.length; i++) {
			int cnt = array[i];
			if (cnt % 2 == 0) {
				maxLen += cnt;
			} else {
				maxLen += cnt - 1;
				oddNum++;
			}
		}
		if (oddNum > 0) {
			maxLen+=1;
		}
		return maxLen;
	}

	public static void main(String[] args) {
		Q409 q=new Q409();
		System.out.println(q.longestPalindrome("abccccddh"));

	}

}
