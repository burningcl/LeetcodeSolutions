package com.skyline.leetcode.solution;

import java.util.Arrays;

public class Q473 {

    public boolean makesquare(int[] nums, int index, int sum0, int sum1, int sum2, int sum3) {
        if (index >= nums.length) {
            return (0 == sum0) && (0 == sum1) && (0 == sum2) && (0 == sum3);
        }
        int num = nums[index++];
        if (sum0 >= num && this.makesquare(nums, index, sum0 - num, sum1, sum2, sum3)) {
            return true;
        }
        if (sum1 >= num && this.makesquare(nums, index, sum0, sum1 - num, sum2, sum3)) {
            return true;
        }
        if (sum2 >= num && this.makesquare(nums, index, sum0, sum1, sum2 - num, sum3)) {
            return true;
        }
        if (sum3 >= num && this.makesquare(nums, index, sum0, sum1, sum2, sum3 - num)) {
            return true;
        }
        return false;
    }

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) {
            return false;
        }
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int target = (int) (sum / 4);
        return this.makesquare(nums, 0, target, target, target, target);
    }

    public static void main(String[] args) {

    }

}
