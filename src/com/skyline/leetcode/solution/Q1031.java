package com.skyline.leetcode.solution;

/**
 * @author huasong.cl
 */
public class Q1031 {

    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        return Integer.max(
                this.maxSumTwoNoOverlap1(A, L, M),
                this.maxSumTwoNoOverlap1(A, M, L)
        );
    }

    public int maxSumTwoNoOverlap1(int[] A, int L, int M) {
        int[] maxM = new int[A.length];
        int m = 0;
        for (int i = A.length - 1; i >= A.length - M; i--) {
            m += A[i];
        }
        maxM[A.length - M] = m;
        for (int i = A.length - M - 1; i >= 0; i--) {
            m = m + A[i] - A[i + M];
            maxM[i] = Integer.max(m, maxM[i + 1]);
        }
        int l = 0;
        for (int i = 0; i < L; i++) {
            l += A[i];
        }
        int maxSum = l + maxM[L];
        for (int i = L; i < A.length - M; i++) {
            l = l + A[i] - A[i - L];
            maxSum = Integer.max(maxSum, l + maxM[i + 1]);
        }
        return maxSum;
    }

}
