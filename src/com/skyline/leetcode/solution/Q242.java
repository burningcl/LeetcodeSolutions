package com.skyline.leetcode.solution;

/**
 * Valid Anagram
 * 
 * https://leetcode.com/problems/valid-anagram/
 * 
 * @author jairus
 *
 */
public class Q242 {

	public boolean isAnagram(String s, String t) {
		if (s == null && t == null) {
			return true;
		} else if (s == null || t == null) {
			return false;
		} else if (s.length() != t.length()) {
			return false;
		}
		int[] sc = new int[26];
		int[] tc = new int[26];
		for (int i = 0; i < s.length(); i++) {
			sc[s.charAt(i) - 'a']++;
			tc[t.charAt(i) - 'a']++;
		}
		for (int i = 0; i < 26; i++) {
			if (sc[i] != tc[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Q242 q = new Q242();
		System.out.println(q.isAnagram("tbag", "bagg"));

	}

}
