package com.skyline.leetcode.solution;

/**
 * Unique Substrings in Wraparound String
 * 
 * https://leetcode.com/contest/leetcode-weekly-contest-11/problems/unique-substrings-in-wraparound-string/
 * 
 * @author jairus
 *
 */
public class Q467 {

	public int findSubstringInWraproundString(String p) {
		if (p == null || p.length() <= 0) {
			return 0;
		}
		int cnt = 0;
		int[] array = new int[26];
		for (int i = 0; i < p.length();) {
			int j = i + 1;
			for (; j < p.length(); j++) {
				if (p.charAt(j) - 'a' != (p.charAt(j - 1) - 'a' + 27) % 26) {
					break;
				}
			}
		//	System.out.println(i+", "+j);
			for (int k = i; k < j; k++) {
				int index = p.charAt(k) - 'a';
				int size = j - k ;
				if (size<=array[index]) {
					continue;
				}
				cnt += size - array[index];
				array[index] = size;
			}
			i = j;
		}
		return cnt;
	}

	public static void main(String[] args) {
		Q467 q = new Q467();
		System.out.println(q.findSubstringInWraproundString("a"));
		System.out.println(q.findSubstringInWraproundString("aa"));
		System.out.println(q.findSubstringInWraproundString("ab"));
		System.out.println(q.findSubstringInWraproundString("ac"));
		System.out.println(q.findSubstringInWraproundString("za"));
		System.out.println(q.findSubstringInWraproundString("zab"));
		System.out.println(q.findSubstringInWraproundString("zabad"));
		System.out.println(q.findSubstringInWraproundString("zabade"));
	}

}
