package com.skyline.leetcode.solution;

/**
 * Max Consecutive Ones
 * https://leetcode.com/problems/max-consecutive-ones/
 * Created by chenliang on 2017/1/18.
 */
public class Q485 {

    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int maxLen = 0;
        int curLen = 0;
        for (int i = 0, size = nums.length; i < size; i++) {
            if (nums[i] == 1) {
                curLen++;
            } else {
                curLen = 0;
            }
            if (curLen > maxLen) {
                maxLen = curLen;
            }
        }
        return maxLen;
    }
}
