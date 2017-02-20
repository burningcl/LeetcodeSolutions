package com.skyline.leetcode.solution;

import java.math.BigInteger;

/**
 * Smallest Good Base
 * https://leetcode.com/problems/smallest-good-base/
 * Created by chenliang on 2017/2/15.
 */
public class Q483 {

    public String smallestGoodBase(String n) {
        long num = Long.valueOf(n);
        for (int len = 62; len >= 1; len--) {
            if ((1l << len) > num) {
                continue;
            }
            long base = this.smallestGoodBase(num, len);
            if (base > 1) {
                return String.valueOf(base);
            }
        }
        return String.valueOf(num - 1);
    }


    public long smallestGoodBase(long num, int len) {
        long low = 1;
        long high = (long) (Math.pow(num, 1.0 / len) + 1);
        while (low <= high) {
            long mid = (low + high) / 2;
            long sum = 0;
            long cur = 1;
            for (int i = 0; i <= len; i++) {
                sum += cur;
                cur *= mid;
            }
            if (sum == num) {
                return mid;
            } else if (sum > num) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Q483 q = new Q483();
        System.out.println(q.smallestGoodBase("1000000000000000000"));
    }

}
