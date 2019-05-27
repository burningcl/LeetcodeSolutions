package com.skyline.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Fair Candy Swap
 *
 * @author huasong.cl
 */
public class Q888 {

    public int[] fairCandySwap(int[] A, int[] B) {
        Set<Integer> bSet = new HashSet<>();
        int bSum = 0;
        int aSum = 0;
        for (int b : B) {
            bSet.add(b);
            bSum += b;
        }
        for (int a : A) {
            aSum += a;
        }
        int diff = bSum - aSum;
        if (diff % 2 != 0) {
            return null;
        }
        diff = diff >> 1;
        for (int a : A) {
            int b = a + diff;
            if (bSet.contains(b)) {
                int[] ret = {a, b};
                return ret;
            }
        }
        return null;
    }

}
