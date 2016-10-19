package com.skyline.leetcode.solution;

/**
 * Search in Rotated Sorted Array II
 * 
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * 
 * @author jairus
 *
 */
public class Q81 {

	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length <= 0) {
			return false;
		}
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int val = nums[mid];
			int vall = nums[low];
			int valh = nums[high];
			if (val == target) {
				// done
				return true;
			} else if (vall == valh) {
				// done
				if (target == vall) {
					return true;
				} else {
					low++;
					high--;
				}
			} else if (val == vall) {
				low++;
			} else if (val == valh) {
				high--;
			} else if (vall < val && val < valh) {
				// done
				if (target > val) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else if (vall > val && val < valh) {
				// mid之后是有续的
				if (target > val && target <= valh) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else if (vall < val && val > valh) {
				// mid之前是有续的
				if (target < val && target >= vall) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				// 不存在
				return false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Q81 q = new Q81();
		int[] nums1 = { 4, 5, 0, 1, 2, 4 };
		System.out.println(q.search(nums1, 4) == true);
		System.out.println(q.search(nums1, 0) == true);
		System.out.println(q.search(nums1, 1) == true);
		System.out.println(q.search(nums1, 2) == true);
		System.out.println(q.search(nums1, 5) == true);
		System.out.println(q.search(nums1, 6) == false);
		System.out.println(q.search(nums1, 3) == false);
		System.out.println(q.search(nums1, -1) == false);
		int[] nums2 = { 3, 5, 7, 0, 2, 3 };
		System.out.println(q.search(nums2, 3) == true);
		System.out.println(q.search(nums2, 5) == true);
		System.out.println(q.search(nums2, 7) == true);
		System.out.println(q.search(nums2, 0) == true);
		System.out.println(q.search(nums2, 2) == true);
		System.out.println(q.search(nums2, 1) == false);
		System.out.println(q.search(nums2, 4) == false);
		System.out.println(q.search(nums2, 6) == false);
		System.out.println(q.search(nums2, -1) == false);
		System.out.println(q.search(nums2, 8) == false);
		int[] nums3 = { 3, 5, 7, -1, 0, 2 };
		System.out.println(q.search(nums3, 3) == true);
		System.out.println(q.search(nums3, 5) == true);
		System.out.println(q.search(nums3, 7) == true);
		System.out.println(q.search(nums3, -1) == true);
		System.out.println(q.search(nums3, 0) == true);
		System.out.println(q.search(nums3, 2) == true);
		System.out.println(q.search(nums3, 4) == false);
		System.out.println(q.search(nums3, 6) == false);
		System.out.println(q.search(nums3, 8) == false);
		System.out.println(q.search(nums3, -2) == false);
		System.out.println(q.search(nums3, 1) == false);
		int[] nums4 = { 1, 3, 5, 7, 9, 10 };
		System.out.println(q.search(nums4, 1) == true);
		System.out.println(q.search(nums4, 3) == true);
		System.out.println(q.search(nums4, 5) == true);
		System.out.println(q.search(nums4, 7) == true);
		System.out.println(q.search(nums4, 9) == true);
		System.out.println(q.search(nums4, 10) == true);
		System.out.println(q.search(nums4, 0) == false);
		System.out.println(q.search(nums4, 2) == false);
		System.out.println(q.search(nums4, 4) == false);
		System.out.println(q.search(nums4, 6) == false);
		System.out.println(q.search(nums4, 8) == false);
		System.out.println(q.search(nums4, 11) == false);
		int[] nums5 = { 1, 1, 1, 3, 1 };
		System.out.println(q.search(nums5, 1) == true);
		System.out.println(q.search(nums5, 3) == true);
		System.out.println(q.search(nums5, 0) == false);
		System.out.println(q.search(nums5, 2) == false);
		System.out.println(q.search(nums5, 4) == false);
		int[] nums6 = { 1, 3, 1, 1, 1 };
		System.out.println(q.search(nums6, 1) == true);
		System.out.println(q.search(nums6, 3) == true);
		System.out.println(q.search(nums6, 0) == false);
		System.out.println(q.search(nums6, 2) == false);
		System.out.println(q.search(nums6, 4) == false);
		int[] nums7 = { 3, 3, 3, 1, 3 };
		System.out.println(q.search(nums7, 1) == true);
		System.out.println(q.search(nums7, 3) == true);
		System.out.println(q.search(nums7, 0) == false);
		System.out.println(q.search(nums7, 2) == false);
		System.out.println(q.search(nums7, 4) == false);
		int[] nums8 = { 3, 1, 3, 3, 3 };
		System.out.println(q.search(nums8, 1) == true);
		System.out.println(q.search(nums8, 3) == true);
		System.out.println(q.search(nums8, 0) == false);
		System.out.println(q.search(nums8, 2) == false);
		System.out.println(q.search(nums8, 4) == false);
	}

}
