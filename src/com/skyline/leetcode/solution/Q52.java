package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N-Queens II
 * https://leetcode.com/problems/n-queens-ii/?tab=Description
 * Created by chenliang on 2017/2/18.
 */
public class Q52 {

    public int totalNQueens(int n) {
        if (n < 0) {
            return 0;
        }

        int[] rows = new int[n];
        Arrays.fill(rows, -1);
        return this.solveNQueens(rows, 0, n);
    }

    public int solveNQueens(int[] rows, int row, int n) {
        if (row == n) {
            return 1;
        }
        int nextRow = row + 1;
        boolean[] invalideColumns = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (rows[i] != -1) {
                int column = row - rows[i] + i;
                if (column < n) {
                    invalideColumns[column] = true;
                }
                column = i - row + rows[i];
                if (column >= 0) {
                    invalideColumns[column] = true;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (rows[i] == -1 && !invalideColumns[i]) {
                rows[i] = row;
                cnt += this.solveNQueens(rows, nextRow, n);
                rows[i] = -1;
            }
        }
        return cnt;
    }
}
