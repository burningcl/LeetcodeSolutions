package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * Scramble String
 * 
 * https://leetcode.com/problems/scramble-string/
 * 
 * @author jairus
 *
 */
public class Q87 {

	// public boolean isScramble(String s1, String s2) {
	// if (s1 == null || s2 == null || s1.length() != s2.length()) {
	// return false;
	// }
	// int len = s1.length();
	// boolean r = this.isScramble(s1, s2, 0, len - 1, 0, len - 1);
	// return r;
	// }
	//
	// public boolean isScramble(String s1, String s2, int start1, int end1, int
	// start2, int end2) {
	// boolean isScramble = false;
	// if (start1 == end1) {
	// isScramble = s1.charAt(start1) == s2.charAt(start2);
	// } else {
	// int size = end1 - start1;
	// for (int i = 0; i < size; i++) {
	// if ((isScramble(s1, s2, start1, start1 + i, start2, start2 + i)
	// && isScramble(s1, s2, start1 + i + 1, end1, start2 + i + 1, end2))
	// || (isScramble(s1, s2, start1, start1 + i, end2 - i, end2)
	// && isScramble(s1, s2, start1 + i + 1, end1, start2, end2 - 1 - i))) {
	// isScramble = true;
	// break;
	// }
	// }
	// }
	// return isScramble;
	// }

	public boolean isScramble(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}
		return this.isScramble(s1, s2, 0, 0, s1.length());
	}

	int[] cnts = new int[128];

	int[] cnts2 = new int[128];

	boolean isValid(String s1, String s2, int start1, int start2, int len) {
		Arrays.fill(cnts, 0);
		for (int i = 0; i < len; i++) {
			cnts[s1.charAt(start1 + i)]++;
			cnts[s2.charAt(start2 + i)]--;
		}
		return Arrays.equals(cnts, cnts2);
	}

	public boolean isScramble(String s1, String s2, int start1, int start2, int len) {
		if (len <= 0) {
			return true;
		} else if (len == 1) {
			return s1.charAt(start1) == s2.charAt(start2);
		} else if (!this.isValid(s1, s2, start1, start2, len)) {
			return false;
		}
		for (int i = 1; i < len; i++) {
			if ((this.isScramble(s1, s2, start1, start2, i) && this.isScramble(s1, s2, start1 + i, start2 + i, len - i))
					|| (this.isScramble(s1, s2, start1, start2 + len - i, i)
							&& this.isScramble(s1, s2, start1 + i, start2, len - i))) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Q87 q = new Q87();
		long t1 = System.currentTimeMillis();
		System.out.println(q.isScramble("npfgmkuleygms", "ygksfmpngumle") == false);
		System.out.println(q.isScramble("great", "rgeat") == true);
		System.out.println(q.isScramble("abc", "cab") == true);
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}

}
