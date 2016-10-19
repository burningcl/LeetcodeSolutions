package com.skyline.leetcode.solution;

/**
 * Rotate Image
 * 
 * https://leetcode.com/problems/rotate-image/
 * 
 * @author jairus
 *
 */
public class Q48 {

	public void rotate(int[][] matrix, int level, final int n) {
		int size = n - 2 * level;
		if (size <= 1) {
			return;
		}
		for (int i = 0; i < size - 1; i++) {
			int b = size - 1;
			int v = matrix[b + level][i + level];
			matrix[b + level][i + level] = matrix[b - i + level][b + level];
			matrix[b - i + level][b + level] = matrix[0 + level][b - i + level];
			matrix[0 + level][b - i + level] = matrix[i + level][0 + level];
			matrix[i + level][0 + level] = v;
		}
		rotate(matrix, level + 1, n);
	}

	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length <= 1 || matrix.length != matrix[0].length) {
			return;
		}
		rotate(matrix, 0, matrix.length);
	}

	public static void main(String... strings) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		Q48 q = new Q48();
		q.rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
