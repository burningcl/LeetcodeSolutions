package com.skyline.leetcode.solution;

/**
 * Two Sum II - Input array is sorted
 * 
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * 
 * @author jairus
 * 
 */
public class Q167 {

	private int find(int[] nums, int target, int low, int high) {
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	public int[] twoSum(int[] numbers, int target) {
		int[] ret = new int[2];
		if (numbers == null || numbers.length <= 1) {
			return ret;
		}
		int end = numbers.length - 1;
		for (int i = 0; i < end; i++) {
			int num = numbers[i];
			int tIndex = find(numbers, target - num, i + 1, end);
			if (tIndex > 0) {
				ret[0] = i + 1;
				ret[1] = tIndex + 1;
				return ret;
			}
		}
		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
