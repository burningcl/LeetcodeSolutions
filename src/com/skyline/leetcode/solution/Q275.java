package com.skyline.leetcode.solution;

/**
 * H-Index II
 * 
 * https://leetcode.com/problems/h-index-ii/
 * 
 * @author jairus
 *
 */
public class Q275 {
	public int hIndex(int[] citations) {
		if (citations == null || citations.length <= 0)
			return 0;
		int max = citations[citations.length - 1];
		int hMin = 0;
		int hMax = max < citations.length ? max : citations.length;
		while (hMin <= hMax) {
			int hMid = (hMin + hMax) / 2;
			int low = 0;
			int high = citations.length - 1;
			while (low <= high) {
				int mid = (low + high) / 2;
				if (citations[mid] < hMid) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			int cnt = citations.length - 1 - high;
			if (cnt < hMid) {
				hMax = hMid - 1;
			} else {
				hMin = hMid + 1;
			}
		}
		return hMax;
	}

	public static void main(String[] args) {
		Q275 q = new Q275();
		int[] nums = { 1 };
		System.out.println(q.hIndex(nums));
		int[] nums0 = { 1, 2 };
		System.out.println(q.hIndex(nums0));
		int[] nums1 = { 1, 2, 3 };
		System.out.println(q.hIndex(nums1));
		int[] nums2 = { 1, 2, 3, 4 };
		System.out.println(q.hIndex(nums2));
		int[] nums3 = { 1, 2, 3, 4 ,5};
		System.out.println(q.hIndex(nums3));

	}
}
