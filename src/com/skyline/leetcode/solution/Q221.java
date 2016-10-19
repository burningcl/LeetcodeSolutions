package com.skyline.leetcode.solution;

/**
 * Maximal Square
 * 
 * https://leetcode.com/problems/maximal-square/
 * 
 * @author jairus
 *
 */
public class Q221 {

	public int maximalSquare(char[][] matrix) {
		if (matrix == null) {
			return 0;
		}
		int n = matrix.length;
		if (n <= 0) {
			return 0;
		}
		int m = matrix[0].length;
		if (m < 0) {
			return 0;
		}
		int[][] map = new int[n][m];
		int max = 0;
		for (int i = 0; i < n; i++) {
			if (matrix[i][0] == '1') {
				map[i][0] = 1;
				max = 1;
			}
		}
		for (int i = 1; i < m; i++) {
			if (matrix[0][i] == '1') {
				map[0][i] = 1;
				max = 1;
			}
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				if (matrix[i][j] == '0') {
					map[i][j] = 0;
				} else {
					int cm = map[i - 1][j] > map[i][j - 1] ? map[i - 1][j] : map[i][j - 1];
					cm = cm > map[i - 1][j - 1] ? cm : map[i - 1][j - 1];
					map[i][j] = cm + 1;
					if(map[i][j]>max){
						max=map[i][j];
					}
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
