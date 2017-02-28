package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * Wiggle Sort
 * https://leetcode.com/problems/wiggle-sort/?tab=Description
 * Created by chenliang on 2017/2/27.
 */
public class Q280 {

    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            swap(nums, i, i + 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i >= nums.length || j >= nums.length) {
            return;
        }
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
