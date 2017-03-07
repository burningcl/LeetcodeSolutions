package com.skyline.leetcode.solution;

/**
 * Max Consecutive Ones II
 * <p>
 * Created by chenliang on 2017/3/1.
 */
public class Q487 {

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int start = 0;
        int zeroIndex = -1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (start >= 0) {
                    if (zeroIndex >= 0) {
                        start = zeroIndex + 1;
                        zeroIndex = i;
                    } else {
                        zeroIndex = i;
                        if (i - start + 1 > max) {
                            max = i - start + 1;
                        }
                    }
                } else {
                    start = i;
                    zeroIndex = i;
                }
            } else {

                if (i - start + 1 > max) {
                    max = i - start + 1;
                }
            }
        }
        return max;
    }
}
