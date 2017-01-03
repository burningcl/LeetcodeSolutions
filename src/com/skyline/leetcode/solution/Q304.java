package com.skyline.leetcode.solution;

/**
 * Range Sum Query 2D - Immutable
 * 
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 * 
 * @author jairus
 *
 */
public class Q304 {

	public class NumMatrix {

		int[][] cache;

		public NumMatrix(int[][] matrix) {
			if (matrix == null || matrix.length <= 0 || matrix[0] == null || matrix[0].length <= 0) {
				return;
			}
			int maxRow = matrix.length + 1;
			int maxCol = matrix[0].length + 1;
			cache = new int[maxRow][maxCol];
			int i1;
			int j1;
			for (int i = 1; i < maxRow; i++) {
				for (int j = 1; j < maxCol; j++) {
					i1 = i - 1;
					j1 = j - 1;
					cache[i][j] = cache[i1][j] + cache[i][j1] - cache[i1][j1] + matrix[i1][j1];
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			return cache[row2 + 1][col2 + 1] - cache[row2 + 1][col1] - cache[row1][col2 + 1] + cache[row1][col1];
		}
	}

}
