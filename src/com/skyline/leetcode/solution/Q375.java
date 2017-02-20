package com.skyline.leetcode.solution;

/**
 * Guess Number Higher or Lower II
 * <p>
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/
 *
 * @author jairus
 */
public class Q375 {

    private int[][] cache = null;

    private int getMoneyAmount(int left, int right) {
        if (left >= right) {
            return 0;
        }

        if (cache[left][right] > 0) {
            return cache[left][right];
        }

        int min = Integer.MAX_VALUE;
        int mid = (left + right) >> 1;
        for (int i = right; i >= mid; i--) {
            int leftT = getMoneyAmount(left, i - 1);
            int rightT = getMoneyAmount(i + 1, right);
            int t = i + (leftT > rightT ? leftT : rightT);
            if (t < min) {
                min = t;
            }
        }
        cache[left][right] = min;
        return min;
    }

    public int getMoneyAmount(int n) {
        cache = new int[n + 1][n + 1];
        return getMoneyAmount(1, n);
    }

    public static void main(String... strings) {
        Q375 q = new Q375();
        System.out.println(q.getMoneyAmount(1023));
    }
}
