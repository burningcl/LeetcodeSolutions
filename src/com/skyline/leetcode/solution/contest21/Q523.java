package com.skyline.leetcode.solution.contest21;

/**
 * Continuous Subarray Sum
 * https://leetcode.com/contest/leetcode-weekly-contest-21/problems/continuous-subarray-sum/
 * Created by chenliang on 2017/2/26.
 */
public class Q523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length <= 0) {
            return false;
        }
        if (k == 0) {
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == 0 && nums[i - 1] == 0) {
                    return true;
                }
            }
            return false;
        }
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum % k == 0) {
                return true;
            }
            int subSum = sum;
            for (int j = 0; j <= i - 2; j++) {
                subSum -= nums[j];
                if (subSum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
