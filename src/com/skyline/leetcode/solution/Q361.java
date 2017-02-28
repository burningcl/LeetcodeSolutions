package com.skyline.leetcode.solution;

/**
 * Bomb Enemy
 * https://leetcode.com/problems/bomb-enemy/?tab=Description
 * Created by chenliang on 2017/2/27.
 */
public class Q361 {


    //Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero)
    public int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int[][] killGrid = new int[n][m];
        for (int i = 0; i < n; i++) {
            int killed = 0;
            int start = 0;
            for (int j = 0; j <= m; j++) {
                if (j == m || grid[i][j] == 'W') {
                    for (int k = start; k < j; k++) {
                        killGrid[i][k] += killed;
                    }
                    killed = 0;
                    start = j + 1;
                } else if (grid[i][j] == 'E') {
                    killed++;
                }
            }
        }
        for (int j = 0; j < m; j++) {
            int killed = 0;
            int start = 0;
            for (int i = 0; i <= n; i++) {
                if (i == n || grid[i][j] == 'W') {
                    for (int k = start; k < i; k++) {
                        killGrid[k][j] += killed;
                    }
                    start = i + 1;
                    killed = 0;
                } else if (grid[i][j] == 'E') {
                    killed++;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '0' && killGrid[i][j] > max) {
                    max = killGrid[i][j];
                }
            }
        }
        return max;
    }

}
