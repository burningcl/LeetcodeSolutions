package com.skyline.leetcode.solution;

/**
 * Maximal Rectangle
 * 
 * https://leetcode.com/problems/maximal-rectangle/
 * 
 * @author jairus
 *
 */
public class Q85 {

	// public int maximalRectangle(char[][] matrix) {
	// if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
	// return 0;
	// }
	// int n = matrix.length;
	// int m = matrix[0].length;
	// int[][][] dp = new int[n][m][2];
	// int max = 0;
	// int[] p;
	// for (int i = 1; i <= n; i++) {
	// for (int j = 1; j <= m; j++) {
	// p = dp[i][j];
	// if (matrix[i - 1][j - 1] != '0') {
	// int i1 = i - 1;
	// int j1 = j - 1;
	//
	// max = Math.max(max, (i - p[0] + 1) * (j - p[1] + 1));
	// }
	// System.out.print("[" + p[0] + ", " + p[1] + "] ");
	// }
	// System.out.println();
	// }
	// return max;
	// }

	static final int LEN_X = 0;

	static final int LEN_Y = 1;

	public int getDpVal(int[][][] matrix, int x, int y, int index) {
		if (x < 0 || y < 0)
			return 0;
		return matrix[x][y][index];
	}

	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
			return 0;
		}
		int n = matrix.length;
		int m = matrix[0].length;
		int[][][] dp = new int[n][m][2];

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] != '1') {
					continue;
				}
				dp[i][j][LEN_X] = getDpVal(dp, i - 1, j, LEN_X) + 1;
				dp[i][j][LEN_Y] = getDpVal(dp, i, j - 1, LEN_Y) + 1;
				int min = Integer.MAX_VALUE;
				int area = 0;
				for (int ii = i; ii >= i - dp[i][j][LEN_X] + 1; ii--) {
					if (dp[ii][j][LEN_Y] < min) {
						min = dp[ii][j][LEN_Y];
						if (min * dp[i][j][LEN_X] <= max) {
							break;
						}
					}
					area = min * (i - ii + 1);
					max = Math.max(area, max);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {

	}

}
