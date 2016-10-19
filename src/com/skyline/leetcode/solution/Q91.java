package com.skyline.leetcode.solution;

/**
 * Decode Ways
 * 
 * https://leetcode.com/problems/decode-ways/
 * 
 * @author jairus
 *
 */
public class Q91 {
	public int numDecodings(String s) {
		if (s == null || s.length() <= 0) {
			return 0;
		}
		int s0 = 0;
		int s1 = 1;
		int f = 0;
		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i) - '0';
			int v = f * 10 + c;
			f = c;
			if (v >= 1 && v <= 26) {
				if (c != 0) {
					if (i % 2 == 0) {
						s0 += s1;
					} else {
						s1 += s0;
					}
				} else {
					if (i % 2 == 0) {
						s1 = 0;
					} else {
						s0 = 0;
					}
				}
			} else if (v <= 0) {
				return 0;
			} else {
				if (c == 0) {
					return 0;
				}
				if (i % 2 == 0) {
					s0 = s1;
				} else {
					s1 = s0;
				}
			}
		}
		return s.length() % 2 == 0 ? s1 : s0;
	}

	public static void main(String[] args) {
		Q91 q = new Q91();
		System.out.println(q.numDecodings("0"));
		System.out.println(q.numDecodings("1"));
		System.out.println(q.numDecodings("12"));
		System.out.println(q.numDecodings("123"));
		System.out.println(q.numDecodings("1454514114541561561321321321321320") == 7776);
		System.out.println(q.numDecodings("14545141145415615613213213213213020") == 0);
		System.out.println(q.numDecodings("1454514114541506156132132132") == 0);
		System.out.println(q.numDecodings("101") == 1);
	}

}
