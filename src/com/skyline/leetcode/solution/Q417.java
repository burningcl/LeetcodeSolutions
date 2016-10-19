package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Pacific Atlantic Water Flow
 * 
 * https://leetcode.com/problems/pacific-atlantic-water-flow/
 * 
 * @author jairus
 *
 */
public class Q417 {

	private void flood(final int i, final int j, final int n, final int m, final boolean[][] map,
			final int[][] matrix) {
		if (!map[i][j]) {
			return;
		}
		if (i - 1 >= 0 && !map[i - 1][j] && matrix[i][j] <= matrix[i - 1][j]) {
			map[i - 1][j] = true;
			this.flood(i - 1, j, n, m, map, matrix);
		}
		if (i + 1 < n && !map[i + 1][j] && matrix[i][j] <= matrix[i + 1][j]) {
			map[i + 1][j] = true;
			this.flood(i + 1, j, n, m, map, matrix);
		}
		if (j - 1 >= 0 && !map[i][j - 1] && matrix[i][j] <= matrix[i][j - 1]) {
			map[i][j - 1] = true;
			this.flood(i, j - 1, n, m, map, matrix);
		}
		if (j + 1 < m && !map[i][j + 1] && matrix[i][j] <= matrix[i][j + 1]) {
			map[i][j + 1] = true;
			this.flood(i, j + 1, n, m, map, matrix);
		}
	}

	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> list = new ArrayList<>();
		if (matrix == null) {
			return list;
		}
		int n = matrix.length;
		if (n <= 0) {
			return list;
		}
		int m = matrix[0].length;
		if (m <= 0) {
			return list;
		}
		boolean[][] pMap = new boolean[n][m];
		boolean[][] aMap = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			pMap[i][0] = true;
			aMap[i][m - 1] = true;
		}
		for (int i = 0; i < m; i++) {
			pMap[0][i] = true;
			aMap[n - 1][i] = true;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				this.flood(i, j, n, m, pMap, matrix);
			}
		}
		for (int i = n - 1; i >= 0; i--) {
			for (int j = m - 1; j >= 0; j--) {
				this.flood(i, j, n, m, aMap, matrix);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (aMap[i][j] && pMap[i][j]) {
					int[] array = new int[2];
					array[0] = i;
					array[1] = j;
					list.add(array);
				}
			}
		}
		return list;
	}

	private static void test(int[][] matrix) {
		Q417 q = new Q417();
		List<int[]> list = q.pacificAtlantic(matrix);
		for (int[] array : list) {
			System.out.println(array[0] + "," + array[1]);
		}
		System.out.println();

	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
				{ 5, 1, 1, 2, 4 } };
		test(matrix);
		int[][] matrix1 = { { 5, 5, 5, 6 }, { 5, 0, 0, 5 }, { 5, 0, 0, 5 }, { 6, 5, 5, 5 } };
		test(matrix1);
		int[][] matrix2 = { { 1 } };
		test(matrix2);
		int[][] matrix3 = { {} };
		test(matrix3);
	}

}
