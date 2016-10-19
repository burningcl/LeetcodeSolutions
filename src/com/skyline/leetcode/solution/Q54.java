package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix
 * 
 * https://leetcode.com/problems/spiral-matrix/
 * 
 * @author jairus
 *
 */
public class Q54 {

	public void spiralOrder(final int[][] matrix, final int level, final int rows, final int columns,
			final List<Integer> list) {
		int columnSize = columns - 2 * level - 1;
		int rowSize = rows - 2 * level - 1;
		if (columnSize < 0 || rowSize < 0) {
			return;
		}
		// System.out.println(columnSize + ", " + rowSize);
		if (columnSize == 0 && rowSize == 0) {
			list.add(matrix[level][level]);
			return;
		} else if (columnSize == 0 && rowSize != 0) {
			for (int i = 0; i <= rowSize; i++) {
				list.add(matrix[i + level][level]);
			}
			return;
		} else if (columnSize != 0 && rowSize == 0) {
			for (int i = 0; i <= columnSize; i++) {
				list.add(matrix[level][i + level]);
			}
			return;
		}
		for (int i = 0; i < columnSize; i++) {
			list.add(matrix[level][i + level]);
		}
		for (int i = 0; i < rowSize; i++) {
			list.add(matrix[i + level][columnSize + level]);
		}
		for (int i = 0; i < columnSize; i++) {
			list.add(matrix[rowSize + level][columnSize - i + level]);
		}
		for (int i = 0; i < rowSize; i++) {
			list.add(matrix[rowSize - i + level][level]);
		}
		spiralOrder(matrix, level + 1, rows, columns, list);
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix == null || matrix.length <= 0) {
			return list;
		}
		int rows = matrix.length;
		int columns = matrix[0].length;
		spiralOrder(matrix, 0, rows, columns, list);
		return list;
	}

	public static void main(String[] args) {
		Q54 q = new Q54();
		// int[][] matrix = { { 1 }};
		// int[][] matrix = { { 1,2 },{3,4}};
		// int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		// int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }
		// };
		// int[][] matrix = { { 1, 2, 3 }, { 5, 6, 7 }, { 9, 10, 11 }, { 13, 14,
		// 15 } };
		int[][] matrix = { { 1 },{2},{3}};
	//	int[][] matrix = { { 1, 2, 3 } };
		List<Integer> list = q.spiralOrder(matrix);
		for (int num : list) {
			System.out.print(num + "\t");
		}
	}

}
