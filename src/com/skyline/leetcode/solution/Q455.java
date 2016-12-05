package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * Assign Cookies
 * 
 * https://leetcode.com/problems/assign-cookies/
 * 
 * @author jairus
 *
 */
public class Q455 {
	public int findContentChildren(int[] g, int[] s) {
		if (g == null || g.length <= 0 || s == null || s.length <= 0)
			return 0;
		Arrays.sort(g);
		Arrays.sort(s);
		int cnt = 0;
		for (int i = g.length - 1, j = s.length - 1; i >= 0 && j >= 0;) {
			if (s[j] >= g[i]) {
				j--;
				cnt++;
			}
			i--;

		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
