package com.skyline.leetcode.solution;

/**
 * Reverse String
 * 
 * https://leetcode.com/problems/reverse-string/
 * 
 * @author jairus
 *
 */
public class Q344 {
	public String reverseString(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		char[] cs = s.toCharArray();
		int i = 0;
		int j = cs.length - 1;

		while (i < j) {
			char c = cs[i];
			cs[i] = cs[j];
			cs[j] = c;
			i++;
			j--;
		}
		return String.valueOf(cs);
	}
}
