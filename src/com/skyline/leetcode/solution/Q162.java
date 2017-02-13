package com.skyline.leetcode.solution;

/**
 * Find Peak Element
 * https://leetcode.com/problems/find-peak-element/
 * Created by chenliang on 2017/2/13.
 */
public class Q162 {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        return 0;
    }

}
