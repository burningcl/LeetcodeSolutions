package com.skyline.leetcode.solution;

/**
 * Ones and Zeroes
 * 
 * https://leetcode.com/problems/ones-and-zeroes/
 * 
 * @author jairus
 *
 */
public class Q474 {

	public int findMaxForm(String[] strs, int m, int n) {
		if (strs == null || strs.length <= 0 || m < 0 || n < 0) {
			return 0;
		}
		int[][] map = new int[m + 1][n + 1];
		int cnt0;
		int cnt1;
		String str = null;

		for (int i = 0; i < strs.length; i++) {

			str = strs[i];
			cnt0 = cnt1 = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '0') {
					cnt0++;
				} else {
					cnt1++;
				}
			}

			for (int j = cnt0; j <= m; j++) {
				for (int k = cnt1; k <= n; k++) {
					map[j][k] = Math.max(map[j - cnt0][k - cnt1] + 1, map[j][k]);
				}
			}
		}
		return map[m][n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
