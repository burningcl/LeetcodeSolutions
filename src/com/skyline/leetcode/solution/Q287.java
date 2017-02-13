package com.skyline.leetcode.solution;

import java.util.regex.Pattern;

/**
 * Find the Duplicate Number
 * https://leetcode.com/problems/find-the-duplicate-number/
 * Created by chenliang on 2017/2/13.
 */
public class Q287 {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        while (nums[0] != nums[nums[0]]) {
            int t = nums[0];
            nums[0] = nums[t];
            nums[t] = t;
        }
        return nums[0];
    }

}
