package com.skyline.leetcode.solution;

import java.util.*;

/**
 * N-Queens
 * https://leetcode.com/problems/n-queens/?tab=Description
 * Created by chenliang on 2017/2/18.
 */
public class Q51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        if (n < 0) {
            return list;
        }
        int[] rows = new int[n];
        Arrays.fill(rows, -1);
        this.solveNQueens(rows, 0, n, list);
        return list;
    }

    public void solveNQueens(int[] rows, int row, int n, List<List<String>> list) {
        if (row == n) {
            List<String> subList = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                sb.setLength(0);
                for (int j = 0; j < n; j++) {
                    sb.append(rows[j] == i ? 'Q' : '.');
                }
                subList.add(sb.toString());
            }
            list.add(subList);
            return;
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
        for (int i = 0; i < n; i++) {
            if (rows[i] == -1 && !invalideColumns[i]) {
                rows[i] = row;
                this.solveNQueens(rows, nextRow, n, list);
                rows[i] = -1;
            }
        }
    }

}
