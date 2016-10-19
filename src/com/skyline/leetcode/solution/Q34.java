package com.skyline.leetcode.solution;

/**
 * Search for a Range
 * 
 * https://leetcode.com/problems/search-for-a-range/
 * 
 * @author jairus
 *
 */
public class Q34 {

	public int searchRange(int[] nums, int target, int low, int high, Boolean leftOne) {
		if (low > high || low < 0 || high < 0) {
			return -1;
		}
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (nums[mid] == target) {
				break;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		if (nums[mid] != target) {
			return -1;
		}
		if (leftOne == null) {
			return mid;
		}
		int pos = -1;
		if (leftOne) {
			pos = searchRange(nums, target, low, mid - 1, leftOne);
		} else {
			pos = searchRange(nums, target, mid + 1, high, leftOne);
		}
		return pos == -1 ? mid : pos;
	}

	public int[] searchRange(int[] nums, int target) {
		int[] ret = { -1, -1 };
		if (nums == null || nums.length <= 0) {
			return ret;
		}
		int low = 0;
		int high = nums.length - 1;
		int mid = searchRange(nums, target, low, high, null);
		ret[0] = searchRange(nums, target, low, mid, true);
		ret[1] = searchRange(nums, target, mid, high, false);
		return ret;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 7, 7, 8, 8, 10, 11, 11, 12 };
		Q34 q = new Q34();
		for (int i = 0; i <= 13; i++) {
			int[] ret = q.searchRange(nums, i);
			System.out.println(i + ": " + ret[0] + ", " + ret[1]);
		}
	}

}
