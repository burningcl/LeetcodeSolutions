package com.skyline.leetcode.solution;

/**
 * Isomorphic Strings
 * 
 * https://leetcode.com/problems/isomorphic-strings/
 * 
 * @author jairus
 *
 */
public class Q205 {

	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}
		int ns = 0;
		int nt = 0;
		int[] arrays = new int[128];
		int[] arrayt = new int[128];
		for (int i = 0; i < s.length(); i++) {
			char cs = s.charAt(i);
			char ct = t.charAt(i);
			if (arrays[cs] == 0) {
				arrays[cs] = ++ns;
			}
			if (arrayt[ct] == 0) {
				arrayt[ct] = ++nt;
			}
			if (arrays[cs] != arrayt[ct]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Q205 q = new Q205();
//		System.out.println(q.isIsomorphic("AAB", "CCD"));
//		System.out.println(q.isIsomorphic("paper", "title"));
//		System.out.println(q.isIsomorphic("paper1", "title1"));
//		System.out.println(q.isIsomorphic("bar", "foo"));
		System.out.println(q.isIsomorphic("aa", "ab"));
	}

}
