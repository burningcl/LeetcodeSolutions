package com.skyline.leetcode.solution;

/**
 * The Maze
 * https://leetcode.com/problems/the-maze/?tab=Description
 * Created by chenliang on 2017/2/27.
 */
public class Q490 {

    public static final int LEFT = 1 << 0;
    public static final int RIGHT = 1 << 1;
    public static final int UP = 1 << 2;
    public static final int DOWN = 1 << 3;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        int[][] cache = new int[n][m];
        int i = start[0];
        int j = start[1];
        return this.hasPath(maze, cache, n, m, i, j, destination, LEFT)
                || this.hasPath(maze, cache, n, m, i, j, destination, RIGHT)
                || this.hasPath(maze, cache, n, m, i, j, destination, UP)
                || this.hasPath(maze, cache, n, m, i, j, destination, DOWN);
    }

    public boolean hasPath(int[][] maze, int[][] cache, int n, int m, int i, int j, int[] destination, int direction) {
        if (i == destination[0] && j == destination[1]) {
            return true;
        }
        if ((cache[i][j] & direction) > 0) {
            return false;
        }
        cache[i][j] = cache[i][j] | direction;
        int k = i;
        int l = j;
        if (direction == LEFT) {
            for (; k >= 0 && maze[k][j] == 0; k--) {
            }
            k++;
        } else if (direction == RIGHT) {
            for (; k < n && maze[k][j] == 0; k++) {
            }
            k--;
        } else if (direction == UP) {
            for (; l >= 0 && maze[i][l] == 0; l--) {
            }
            l++;
        } else if (direction == DOWN) {
            for (; l < m && maze[i][l] == 0; l++) {
            }
            l--;
        }
        if (this.hasPath(maze, cache, n, m, k, l, destination, LEFT)
                || this.hasPath(maze, cache, n, m, k, l, destination, RIGHT)
                || this.hasPath(maze, cache, n, m, k, l, destination, UP)
                || this.hasPath(maze, cache, n, m, k, l, destination, DOWN)) {
            return true;
        }
        return false;
    }

}
