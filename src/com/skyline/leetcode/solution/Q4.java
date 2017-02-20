package com.skyline.leetcode.solution;

/**
 * Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Created by chenliang on 2017/2/15.
 */
public class Q4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length <= 0) {
            return findMedian(nums2);
        } else if (nums2 == null || nums2.length <= 0) {
            return findMedian(nums1);
        }
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0;
        int high = nums1.length - 1;
        int leftCnt = (nums1.length + nums2.length) / 2;
        if ((nums1.length + nums2.length) % 2 == 1) {
            leftCnt++;
        }
        int mid1 = 0;
        int mid2 = 0;
        int leftMax = Integer.MAX_VALUE;
        int rightMin = Integer.MIN_VALUE;
        while (leftMax > rightMin) {
            mid1 = high < 0 ? -1 : (low + high) / 2;
            mid2 = leftCnt - mid1 - 2;
            int median1 = mid1 < 0 || mid1 >= nums1.length ? Integer.MIN_VALUE : nums1[mid1];
            int median2 = mid2 < 0 || mid2 >= nums2.length ? Integer.MIN_VALUE : nums2[mid2];
            leftMax = Integer.max(median1, median2);
            rightMin = Integer.min(
                    mid1 + 1 >= nums1.length ? Integer.MAX_VALUE : nums1[mid1 + 1],
                    mid2 + 1 >= nums2.length ? Integer.MAX_VALUE : nums2[mid2 + 1]
            );
            System.out.println(median1 + ", " + median2 + ", " + leftMax + ", " + rightMin);
            if (median1 > median2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        if ((nums1.length + nums2.length) % 2 == 1) {
            return leftMax;
        } else {
            return (double) (leftMax + rightMin) / 2;
        }
    }

    public double findMedian(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        int mid = (nums.length - 1) / 2;
        return nums.length % 2 == 0 ? (double) (nums[mid] + nums[mid + 1]) / 2 : nums[mid];
    }


}
