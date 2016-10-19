package com.skyline.leetcode.solution;

/**
 * Unique Paths
 * 
 * https://leetcode.com/problems/unique-paths/
 * 
 * @author jairus
 *
 */
public class Q62 {
	public int uniquePaths(int m, int n) {
		if (m <= 1 || n <= 1) {
			return 1;
		}
		int[][] map = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					map[i][j] = 1;
				} else {
					map[i][j] = map[i - 1][j] + map[i][j - 1];
				}
			}
		}
		return map[m - 1][n - 1];
	}

	public static void main(String[] args) {
		Q62 q = new Q62();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.println(i + "," + j + ":\t" + q.uniquePaths(i, j));
			}
		}
	}

}
