package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * Sparse Matrix Multiplication
 * https://leetcode.com/problems/sparse-matrix-multiplication/?tab=Description
 * Created by chenliang on 2017/3/1.
 */
public class Q311 {

    public int[][] multiply(int[][] A, int[][] B) {
        int n1 = A.length;
        int m1 = A[0].length;
        int m2 = B[0].length;
        int[][] ret = new int[n1][m2];
        boolean[] allZeroColumns = new boolean[m2];
        Arrays.fill(allZeroColumns, true);
        for (int j = 0; j < m2; j++) {
            for (int k = 0; k < m1 && allZeroColumns[j]; k++) {
                allZeroColumns[j] &= B[k][j] == 0;
            }
        }
        for (int i = 0; i < n1; i++) {
            boolean allZero = true;
            for (int k = 0; k < m1 && allZero; k++) {
                allZero = A[i][k] == 0;
            }
            if (allZero) {
                continue;
            }
            for (int j = 0; j < m2; j++) {
                if (allZeroColumns[j]) {
                    continue;
                }
                int sum = 0;
                for (int k = 0; k < m1; k++) {
                    sum += A[i][k] * B[k][j];
                }
                ret[i][j] = sum;
            }
        }
        return ret;
    }

}
