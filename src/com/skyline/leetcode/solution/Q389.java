package com.skyline.leetcode.solution;

/**
 * Find the Difference
 * 
 * https://leetcode.com/problems/find-the-difference/
 * 
 * @author jairus
 *
 */
public class Q389 {
	public char findTheDifference(String s, String t) {
		int[] cnts = new int[26];
		if (s != null) {
			for (int i = 0; i < s.length(); i++) {
				cnts[s.charAt(i) - 'a']++;
			}
		}
		if (t != null) {
			for (int i = 0; i < t.length(); i++) {
				cnts[t.charAt(i) - 'a']--;
			}
		}
		for (int i = 0; i < 26; i++) {
			if (cnts[i] != 0) {
				return (char) (i + 'a');
			}
		}
		return 'a';
	}
}
