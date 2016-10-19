package com.skyline.leetcode.solution;

/**
 * Longest Common Prefix
 * 
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * @author jairus
 *
 */
public class Q14 {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length <= 0) {
			return "";
		} else if (strs.length == 1) {
			return strs[0];
		}
		int i = -1;
		char c = 'a';
		boolean match = true;
		while (match) {
			i++;
			for (int j = 0; j < strs.length; j++) {
				String str = strs[j];
				if (i >= str.length()) {
					match = false;
					break;
				} else if (j == 0) {
					c = str.charAt(i);
				} else if (c != str.charAt(i)) {
					match = false;
					break;
				}
			}
		}
		System.out.println(i);
		return strs[0].substring(0, i);
	}

	public static void main(String... strings) {
		String[] strs = { "", "ab", "abd" };
		System.out.println(new Q14().longestCommonPrefix(strs));
	}
}
