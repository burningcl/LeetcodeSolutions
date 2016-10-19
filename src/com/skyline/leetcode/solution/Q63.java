package com.skyline.leetcode.solution;

/**
 * Unique Paths II
 * 
 * https://leetcode.com/problems/unique-paths-ii/
 * 
 * @author jairus
 *
 */
public class Q63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0) {
			return 0;
		}
		if (obstacleGrid[0][0] == 1) {
			return 0;
		}
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] > 0) {
					obstacleGrid[i][j] = 0;
				} else if (i <= 0 || j <= 0) {
					if (i <= 0 && j <= 0) {
						obstacleGrid[i][j] = 1;
					} else if (i <= 0) {
						obstacleGrid[i][j] = obstacleGrid[i][j - 1];
					} else {
						obstacleGrid[i][j] = obstacleGrid[i - 1][j];
					}
				} else {
					obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
				}
			}
		}
		return obstacleGrid[m - 1][n - 1];
	}

	public static void main(String[] args) {
		Q63 q = new Q63();
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		System.out.println(q.uniquePathsWithObstacles(obstacleGrid));
	}

}
