package com.skyline.leetcode.solution;

/**
 * Search a 2D Matrix II
 * 
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * 
 * @author jairus
 *
 */
public class Q240 {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length <= 0 || matrix[0] == null || matrix[0].length <= 0) {
			return false;
		}
		int i = 0;
		int j = matrix[0].length - 1;
		while (matrix[i][j] != target) {
			while (i < matrix.length && matrix[i][j] < target) {
				i++;
			}
			if (i >= matrix.length) {
				return false;
			}
			while (j >= 0 && matrix[i][j] > target) {
				j--;
			}
			if (j < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

	}

}
