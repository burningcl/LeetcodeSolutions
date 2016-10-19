package com.skyline.leetcode.solution;

/**
 * Spiral Matrix II
 * 
 * https://leetcode.com/problems/spiral-matrix-ii/
 * 
 * @author jairus
 *
 */
public class Q59 {

	public void gen(final int[][] matrix, final int level, final int n, int start) {
		int size = n - 2 * level - 1;
		if (size < 0) {
			return;
		}
		if (size == 0) {
			matrix[level][level] = start;
			return;
		}
		for (int i = 0; i < size; i++) {
			matrix[level][i + level] = start++;
		}
		for (int i = 0; i < size; i++) {
			matrix[i + level][size + level] = start++;
		}
		for (int i = 0; i < size; i++) {
			matrix[size + level][size - i + level] = start++;
		}
		for (int i = 0; i < size; i++) {
			matrix[size - i + level][level] = start++;
		}
		gen(matrix, level + 1, n, start);
	}

	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		gen(matrix, 0, n, 1);
		return matrix;
	}
}
