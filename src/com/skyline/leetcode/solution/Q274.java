package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * H-Index
 * 
 * https://leetcode.com/problems/h-index/
 * 
 * @author jairus
 *
 */
public class Q274 {

	public int hIndex(int[] citations) {
		if (citations == null || citations.length <= 0)
			return 0;
		Arrays.sort(citations);
		int max = citations[citations.length - 1];
		int hIndex = max < citations.length ? max : citations.length;
		for (; hIndex >= 0; hIndex--) {
			int low = 0;
			int high = citations.length - 1;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (citations[mid] < hIndex) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			int cnt = citations.length - 1 - high;
			if (cnt >= hIndex) {
				break;
			}
		}
		return hIndex;
	}

	public static void main(String[] args) {
		Q274 q = new Q274();
		int[] nums = { 3, 0, 6, 1, 5 };
		System.out.println(q.hIndex(nums));
		int[] nums1 = { 3, 0, 6, 1, 5, 4 };
		System.out.println(q.hIndex(nums1));
		int[] nums2 = { 3, 0, 6, 1, 5, 4, 5 };
		System.out.println(q.hIndex(nums2));
		int[] nums3 = { 1 };
		System.out.println(q.hIndex(nums3));
	}

}
