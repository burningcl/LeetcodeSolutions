package com.skyline.leetcode.solution;

/**
 * Find Minimum in Rotated Sorted Array
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Created by chenliang on 2017/2/7.
 */
public class Q153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (nums[low] > nums[high]) {
            int mid = (low + high) / 2;
            if (mid == low) {
                break;
            }
            if (nums[mid] < nums[low]) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return nums[low] > nums[high] ? nums[high] : nums[low];
    }
}
