package com.skyline.leetcode.solution;

/**
 * Game of Life
 * https://leetcode.com/problems/game-of-life/?tab=Description
 * Created by chenliang on 2017/3/1.
 */
public class Q289 {

    int[][] diff = {{1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1}};

    public int getNeighborCnt(int[][] board, int n, int m, int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int x1 = x + diff[i][0];
            int y1 = y + diff[i][1];
            if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < m && board[x1][y1] >= 1) {
                cnt++;
            }
        }
        return cnt;
    }

    public void gameOfLife(int[][] board) {
        if (board == null || board.length <= 0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        if (m <= 0) {
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int neighborCnt = this.getNeighborCnt(board, n, m, i, j);
                board[i][j] = board[i][j] == 1 ? neighborCnt + 1 : -neighborCnt;
            }
        }
        /*
        Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cnt = board[i][j];
                if (cnt > 0) {
                    cnt--;
                }
                if (cnt >= 0 && cnt < 2) {
                    cnt = 0;
                } else if (cnt == 2 || cnt == 3) {
                    cnt = 1;
                } else if (cnt > 3) {
                    cnt = 0;
                } else if (cnt == -3) {
                    cnt = 1;
                } else {
                    cnt = 0;
                }
                board[i][j] = cnt;
            }
        }
    }

}
