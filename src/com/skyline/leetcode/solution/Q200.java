package com.skyline.leetcode.solution;

/**
 * Number of Islands
 * 
 * https://leetcode.com/problems/number-of-islands/
 * 
 * @author jairus
 *
 */
public class Q200 {

	public void flood(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		this.flood(grid, i - 1, j);
		this.flood(grid, i + 1, j);
		this.flood(grid, i, j - 1);
		this.flood(grid, i, j + 1);
	}

	public int numIslands(char[][] grid) {
		if (grid == null) {
			return 0;
		}
		int cnt = 0;
		for (int i = 0; i < grid.length; i++) {
			char[] array = grid[i];
			if (array == null) {
				return cnt;
			}
			for (int j = 0; j < array.length; j++) {
				if (grid[i][j] == '1') {
					cnt++;
					this.flood(grid, i, j);
				}
			}
		}
		return cnt;
	}
}
