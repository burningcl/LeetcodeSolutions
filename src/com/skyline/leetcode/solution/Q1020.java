package com.skyline.leetcode.solution;

/**
 * @author huasong.cl
 */
public class Q1020 {

    public int numEnclaves(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int total = 0;
        int c;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1 && (c = numEnclaves(A, i, j, n, m)) > 0) {
                    total += c;
                }
            }
        }
        return total;
    }

    private int numEnclaves(int[][] A, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return Integer.MIN_VALUE;
        } else if (A[i][j] == 0 || A[i][j] == -1) {
            return 0;
        }
        A[i][j] = -1;
        int c0 = numEnclaves(A, i - 1, j, n, m);
        int c1 = numEnclaves(A, i + 1, j, n, m);
        int c2 = numEnclaves(A, i, j - 1, n, m);
        int c3 = numEnclaves(A, i, j + 1, n, m);
        if (c0 >= 0 && c1 >= 0 && c2 >= 0 && c3 >= 0) {
            return c0 + c1 + c2 + c3 + 1;
        } else {
            return Integer.MIN_VALUE;
        }
    }


}
