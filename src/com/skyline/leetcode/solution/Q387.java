package com.skyline.leetcode.solution;

/**
 * First Unique Character in a String
 * 
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 * 
 * @author jairus
 *
 */
public class Q387 {

	public int firstUniqChar(String s) {
		int pos = -1;
		if (s == null || s.length() <= 0) {
			return pos;
		}
		int[] cnt = new int[26];
		for (int i = 0; i < s.length(); i++) {
			cnt[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < s.length(); i++) {
			if (cnt[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
		return pos;
	}

	public static void main(String[] args) {
		Q387 q=new Q387();
		System.out.println(q.firstUniqChar("leetcodeltdoc"));
		System.out.println(q.firstUniqChar("loveleetcode"));
	}

}
