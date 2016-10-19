package com.skyline.leetcode.solution;

/**
 * Search in Rotated Sorted Array
 * 
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * @author jairus
 *
 */
public class Q33 {

	private int search(int[] nums, int target, int low, int high) {
		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public int search(int[] nums, int target) {
		if (nums == null || nums.length <= 0) {
			return -1;
		} else if (nums.length <= 1) {
			return nums[0] == target ? 0 : -1;
		}
		int i = 0;
		for (; i < nums.length - 2 && nums[i] <= nums[i + 1]; i++) {
		}
		if (target >= nums[0] && target <= nums[i]) {
			return search(nums, target, 0, i);
		} else if (i < nums.length - 1 && target >= nums[i + 1] && target <= nums[nums.length - 1]) {
			return search(nums, target, i + 1, nums.length - 1);
		} else {
			return -1;
		}
	}

	public static void main(String... strings) {
		Q33 q = new Q33();
		int n = 5;
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				nums[j] = (j + i) % n + 1;
				System.out.print(nums[j] + "\t");
			}
			System.out.println();
			int target = 0;
			System.out.println(target + ":\t" + q.search(nums, target));
			target = 1;
			System.out.println(target + ":\t" + q.search(nums, target));
			target = n;
			System.out.println(target + ":\t" + q.search(nums, target));
			target = n + 1;
			System.out.println(target + ":\t" + q.search(nums, target));
		}
	}
}
