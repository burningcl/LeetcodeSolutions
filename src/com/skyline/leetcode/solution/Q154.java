package com.skyline.leetcode.solution;

/**
 * Find Minimum in Rotated Sorted Array II
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * Created by chenliang on 2017/2/7.
 */
public class Q154 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        return this.findMin(nums, 0, nums.length - 1);
    }

    public int findMin(int[] nums, int low, int high) {
        if (low > high) {
            return Integer.MAX_VALUE;
        } else if (low == high) {
            return nums[low];
        } else if (nums[low] == nums[high]) {
            int mid = (low + high) / 2;
            int left = this.findMin(nums, low, mid);
            int right = this.findMin(nums, mid + 1, high);
            return Integer.min(left, right);
        } else {
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
            return Integer.min(nums[low], nums[high]);
        }
    }
}
