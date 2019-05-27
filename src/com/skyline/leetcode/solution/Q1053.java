package com.skyline.leetcode.solution;

/**
 * @author huasong.cl
 */
public class Q1053 {

    public int[] prevPermOpt1(int[] A) {
        if (A == null || A.length <= 1) {
            return A;
        }
        int i = A.length - 2;
        for (; i >= 0 && A[i] <= A[i + 1]; i--) {
        }
        if (i < 0) {
            return A;
        }
        for (int j = A.length - 1; j > i; j++) {
            if (A[j] < A[i] && A[j - 1] != A[j]) {
                int t = A[j];
                A[j] = A[i];
                A[i] = t;
                break;
            }
        }
        return A;
    }

}
