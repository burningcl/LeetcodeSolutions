package com.skyline.leetcode.solution;

/**
 * Set Matrix Zeroes
 * 
 * https://leetcode.com/problems/set-matrix-zeroes/
 * 
 * @author jairus
 *
 */
public class Q73 {

	public void setZeroes(int[][] matrix) {
		if (matrix == null) {
			return;
		}
		int n = matrix.length;
		int m = matrix[0].length;
		boolean[] array = new boolean[m];
		for (int i = 0; i < n; i++) {
			boolean foundZero = false;
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 0) {
					array[j] = true;
					foundZero = true;
				}
			}
			if (foundZero){
				for (int k = 0; k < n; k++) {
					matrix[i][k] = 0;
				}
			}
		}
		for (int j = 0; j < m; j++) {
			if(array[j]){
				for (int i = 0; i < n; i++) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {

	}

}
