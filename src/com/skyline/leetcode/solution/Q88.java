package com.skyline.leetcode.solution;

/**
 * Merge Sorted Array
 * 
 * https://leetcode.com/problems/merge-sorted-array/
 * 
 * @author jairus
 *
 */
public class Q88 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		for (int i = m - 1; i >= 0; i--) {
			nums1[i + n] = nums1[i];
		}
		int i = n;
		int j = 0;
		int k = 0;
		int l = m + n;
		while (i < l && j < n) {
			if (nums1[i] < nums2[j]) {
				nums1[k++] = nums1[i++];
			} else {
				nums1[k++] = nums2[j++];
			}
		}
		while (j < n) {
			nums1[k++] = nums2[j++];
		}
	}
}
