package com.skyline.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Relative Ranks
 * https://leetcode.com/problems/relative-ranks/
 * Created by chenliang on 2017/2/10.
 */
public class Q506 {
    public String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return new String[0];
        }
        int[][] array = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            array[i][0] = i;
            array[i][1] = nums[i];
        }
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        String[] ret = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i >= 3) {
                ret[array[i][0]] = String.valueOf(i + 1);
            } else if (i == 0) {
                ret[array[i][0]] = "Gold Medal";
            } else if (i == 1) {
                ret[array[i][0]] = "Silver Medal";
            } else if (i == 2) {
                ret[array[i][0]] = "Bronze Medal";
            }
        }
        return ret;
    }
}
