package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * Distinct Subsequences
 * 
 * https://leetcode.com/problems/distinct-subsequences/
 * 
 * @author jairus
 *
 */
public class Q115 {

	public int numDistinct(String s, String t) {

		if (s == null || t == null || s.length() <= 0 || t.length() <= 0 || s.length() < t.length()) {
			return 0;
		} else if (s.length() == t.length()) {
			return s.equals(t) ? 1 : 0;
		}
		int[][] map = new int[2][s.length() + 1];
		int tLastIndex = t.length() - 1;
		char tLastChar = t.charAt(tLastIndex);
		for (int i = s.length() - 1; i >= tLastIndex; i--) {
			if (s.charAt(i) == tLastChar) {
				map[0][i] = map[0][i + 1] + 1;
			} else {
				map[0][i] = map[0][i + 1];
			}
		}

		if (map[0][tLastIndex] == 0) {
			return 0;
		}

		for (int i = tLastIndex - 1; i >= 0; i--) {
			char ct = t.charAt(i);
			int[] array = map[0];
			map[0] = map[1];
			map[1] = array;
			for (int j = s.length() - 1 - tLastIndex + i; j >= i; j--) {
				if (ct == s.charAt(j)) {
					map[0][j] = map[1][j + 1] + map[0][j + 1];
				} else {
					map[0][j] = map[0][j + 1];
				}
			}
			Arrays.fill(map[1], 0);
		}

		return map[0][0];
	}

	public static void main(String[] args) {
		Q115 q = new Q115();
		System.out.println(q.numDistinct("babaccc", "bacc"));

	}

}
