package com.skyline.leetcode.solution;

/**
 * @author huasong.cl
 */
public class Q1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int total = 0;
        int n = customers.length;
        for (int i = 0; i < n; ++i) {
            if (grumpy[i] == 1 || i < X) {
                total += customers[i];
            }
        }
        int max = total;
        for (int i = X; i < n; ++i) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
            if (grumpy[i - X] == 0) {
                total -= customers[i - X];
            }
            max = Integer.max(max, total);
        }
        return max;
    }

}
