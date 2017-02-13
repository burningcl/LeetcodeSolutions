package com.skyline.leetcode.solution;

import java.util.*;

/**
 * Magical String
 * https://leetcode.com/problems/magical-string/
 * <p>
 * Created by chenliang on 2017/1/24.
 */
public class Q481 {

    public int magicalString(int n) {
        if (n <= 0) {
            return 0;
        } else if (n <= 3) {
            return 1;
        }
        boolean[] array = new boolean[n];
        array[0] = true;
        int lIndex = 2;
        int hIndex = 3;
        int size = 3;
        boolean one = false;
        int cntOne = 1;
        while (size < n) {
            int cnt = array[lIndex++] ? 1 : 2;
            one = !one;
            int subSize = Integer.min(cnt, n - size);
            if (one) {
                cntOne += subSize;
                for (int i = 0; i < subSize; i++) {
                    array[hIndex++] = one;
                }
            } else {
                hIndex += subSize;
            }
            size += subSize;

        }

        return cntOne;
    }

}
