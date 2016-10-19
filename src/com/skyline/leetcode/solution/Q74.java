package com.skyline.leetcode.solution;

/**
 * Search a 2D Matrix
 * 
 * https://leetcode.com/problems/search-a-2d-matrix/
 * 
 * @author jairus
 *
 */
public class Q74 {

	public boolean searchMatrix(int[][] matrix, int target, int rowL, int colL, int rowH, int colH) {
		if (rowL > rowH || colL > colH) {
			return false;
		}
		// System.out.println(rowL + "," + colL + "," + rowH + "," + colH);
		int rowM = (rowL + rowH) / 2;
		int colM = (colL + colH) / 2;
		int val = matrix[rowM][colM];
		if (val == target) {
			return true;
		} else if (val > target) {
			if (this.searchMatrix(matrix, target, rowL, colL, rowM - 1, colH)) {
				return true;
			} else {
				return this.searchMatrix(matrix, target, rowM, colL, rowH, colM - 1);
			}
		} else {
			if (this.searchMatrix(matrix, target, rowL, colM + 1, rowH, colH)) {
				return true;
			} else {
				return this.searchMatrix(matrix, target, rowM + 1, colL, rowH, colM);
			}
		}
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null) {
			return false;
		}
		int n = matrix.length;
		int m = matrix[0].length;
		return searchMatrix(matrix, target, 0, 0, n - 1, m - 1);
	}

//	public boolean searchMatrix(int[][] matrix, int target) {
//		if (matrix == null) {
//			return false;
//		}
//		int n = matrix.length - 1;
//		int m = matrix[0].length - 1;
//		int low = 0;
//		int high = n;
//		int mid = 0;
//		while (low <= high) {
//			mid = (low + high) / 2;
//			if (matrix[mid][m] == target) {
//				return true;
//			} else if (matrix[mid][m] > target) {
//				high = mid - 1;
//			} else {
//				low = mid + 1;
//			}
//		}
//		// System.out.println(low + ", " + high + "," + mid);
//		if (matrix[mid][m] < target)
//			mid++;
//		if (mid > n) {
//			return false;
//		}
//		low = 0;
//		high = m;
//		while (low <= high) {
//			int mm = (low + high) / 2;
//			if (matrix[mid][mm] == target) {
//				return true;
//			} else if (matrix[mid][mm] > target) {
//				high = mm - 1;
//			} else {
//				low = mm + 1;
//			}
//		}
//		return false;
//	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		Q74 q = new Q74();
		System.out.println(q.searchMatrix(matrix, 4) == false);
		System.out.println(q.searchMatrix(matrix, 3) == true);
		System.out.println(q.searchMatrix(matrix, 11) == true);
		System.out.println(q.searchMatrix(matrix, 14) == false);
		System.out.println(q.searchMatrix(matrix, 15) == false);
		System.out.println(q.searchMatrix(matrix, 16) == true);
		System.out.println(q.searchMatrix(matrix, 30) == true);
		System.out.println(q.searchMatrix(matrix, 7) == true);
		int[][] matrix2 = { { 1 } };
		System.out.println(q.searchMatrix(matrix2, 2) == false);
		System.out.println(q.searchMatrix(matrix2, 1) == true);
		System.out.println(q.searchMatrix(matrix2, 0) == false);

		int[][] matrix3 = { { 1, 2 } };
		System.out.println(q.searchMatrix(matrix3, 2) == true);
		System.out.println(q.searchMatrix(matrix3, 1) == true);
		System.out.println(q.searchMatrix(matrix3, 0) == false);
		System.out.println(q.searchMatrix(matrix3, 3) == false);

		int[][] matrix4 = { { 1 }, { 2 } };
		System.out.println(q.searchMatrix(matrix4, 2) == true);
		System.out.println(q.searchMatrix(matrix4, 1) == true);
		System.out.println(q.searchMatrix(matrix4, 0) == false);
		System.out.println(q.searchMatrix(matrix4, 3) == false);
	}

}
