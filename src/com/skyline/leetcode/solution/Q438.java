package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Find All Anagrams in a String
 * 
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 
 * @author jairus
 *
 */
public class Q438 {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();
		if (s == null || s.length() <= 0 || p == null || p.length() <= 0 || p.length() > s.length()) {
			return list;
		}
		int[] parray = new int[26];
		int[] sarray = new int[26];
		for (int i = 0; i < p.length(); i++) {
			parray[p.charAt(i) - 'a']++;
			sarray[s.charAt(i) - 'a']++;
		}

		for (int i = p.length(); i <= s.length(); i++) {
			int j = 0;
			for (; j < 26; j++) {
				if (parray[j] != sarray[j]) {
					break;
				}
			}
			if (j == 26) {
				list.add(i - p.length());
			}
			if (i >= s.length()) {
				break;
			}
			sarray[s.charAt(i - p.length()) - 'a']--;
			sarray[s.charAt(i) - 'a']++;
		}
		return list;
	}

	public static void main(String[] args) {
		Q438 q = new Q438();
		System.out.println(q.findAnagrams("cbaebabacd", "abc"));
		System.out.println(q.findAnagrams("abab", "ab"));
	}

}
