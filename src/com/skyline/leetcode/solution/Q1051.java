package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * @author huasong.cl
 */
public class Q1051 {

    public int heightChecker(int[] heights) {
        int[] array = Arrays.copyOf(heights, heights.length);
        Arrays.sort(array);
        int total = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != array[i]) {
                total++;
            }
        }
        return total;
    }

}
