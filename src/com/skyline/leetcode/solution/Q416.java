package com.skyline.leetcode.solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Partition Equal Subset Sum
 * 
 * https://leetcode.com/problems/partition-equal-subset-sum/
 * 
 * @author jairus
 *
 */
public class Q416 {

	Map<Long, Integer> map = new HashMap<>();

	private boolean exists(int[] nums, int low, long target) {
		int high = nums.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			long val = nums[mid];
			if (val == target) {
				return true;
			} else if (val < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}

	private boolean canPartition(int[] nums, int index, long target) {
		if (target < 0 || index >= nums.length) {
			return false;
		}
		if (map.containsKey(target) && map.get(target) <= index) {
			return false;
		}
		if (exists(nums, index, target))
			return true;
		if (this.canPartition(nums, index + 1, target - nums[index]))
			return true;
		if (this.canPartition(nums, index + 1, target))
			return true;
		map.put(target, index);
		return false;
	}

	public boolean canPartition(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return true;
		}
		Arrays.sort(nums);
		long sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % 2 != 0) {
			return false;
		}
		long target = (long) (sum / 2);
		return this.canPartition(nums, 0, target);
	}

	public static void main(String... strings) {
		int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
				1, 1, 1, 1, 97, 95, 99, 99};
		Q416 q = new Q416();
		long t1 = System.currentTimeMillis();
		System.out.println(q.canPartition(nums));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
		int[] nums2={1,2,3};
		System.out.println(q.canPartition(nums2));
		int[] nums3={1,2,5};
		System.out.println(q.canPartition(nums3));

	}
}
