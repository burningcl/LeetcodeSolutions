package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Longest Increasing Path in a Matrix
 * 
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 * 
 * @author jairus
 *
 */
public class Q329 {

	private Integer getVal(int[][] matrix, int i, int j) {
		if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length) {
			return matrix[i][j];
		}
		return null;
	}

	private int check(int[][] matrix, int i, int j, int curVal, int[][] lenMatrix, int max) {
		Integer val = getVal(matrix, i, j);
		if (val == null) {
			return max;
		}

		if (val > curVal && lenMatrix[i][j] > max) {
			return lenMatrix[i][j];
		}
		return max;
	}

	public int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return 0;
		}
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int[] pos = new int[2];
				pos[0] = i;
				pos[1] = j;
				list.add(pos);
			}
		}
		list.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return matrix[o2[0]][o2[1]] - matrix[o1[0]][o1[1]];
			}
		});
		int max = 0;
		int[][] lenMatrix = new int[matrix.length][matrix[0].length];
		for (int[] pos : list) {
			int i = pos[0];
			int j = pos[1];
			int cm = 0;
			int cur = getVal(matrix, i, j);
			cm = check(matrix, i - 1, j, cur, lenMatrix, cm);
			cm = check(matrix, i + 1, j, cur, lenMatrix, cm);
			cm = check(matrix, i, j - 1, cur, lenMatrix, cm);
			cm = check(matrix, i, j + 1, cur, lenMatrix, cm);

			lenMatrix[i][j] = cm + 1;

			if (lenMatrix[i][j] > max) {
				max = lenMatrix[i][j];
			}
		}
		return max;
	}
}
