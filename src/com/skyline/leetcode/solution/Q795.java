package com.skyline.leetcode.solution;

/**
 * Number of Subarrays with Bounded Maximum
 *
 * @author huasong.cl
 */
public class Q795 {

    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int max = Integer.MIN_VALUE;
        int lIndex = 0;
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > R) {
                if (max >= L) {
                    total += count(A, L, lIndex, i - 1);
                }
                max = Integer.MIN_VALUE;
                lIndex = i + 1;
            } else {
                if (i == A.length - 1) {
                    total += count(A, L, lIndex, i);
                }
                max = Integer.max(max, A[i]);
            }
        }
        return total;
    }

    private int count(int[] A, int L, int lIndex, int rIndex) {
        if (lIndex > rIndex) {
            return 0;
        }
        int total = 0;
        int pre = -1;
        for (int i = lIndex; i <= rIndex; i++) {
            if (A[i] >= L) {
                pre = i - lIndex + 1;
                total += pre;
            } else if (pre != -1) {
                total += pre;
            }
        }
        return total;
    }

}
