package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * 3Sum Smaller
 * https://leetcode.com/problems/3sum-smaller/?tab=Description
 * Created by chenliang on 2017/2/24.
 */
public class Q259 {

    public int threeSumSmaller(int[] nums, int target) {
        int cnt = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    cnt += right - left;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return cnt;
    }

}
