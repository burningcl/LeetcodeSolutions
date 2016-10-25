package com.skyline.leetcode.solution;

import java.util.TreeMap;

/**
 * Contains Duplicate III
 * 
 * https://leetcode.com/problems/contains-duplicate-iii/
 * 
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the difference between nums[i] and nums[j] is at
 * most t and the difference between i and j is at most k.
 * 
 * @author jairus
 *
 */
public class Q220 {

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums == null || nums.length <= 0) {
			return false;
		}
		TreeMap<Long, Integer> map = new TreeMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (i - k - 1 >= 0) {
				long numk = nums[i - k - 1];
				Integer cnt = map.get(numk);
				if (cnt != null && cnt > 1) {
					cnt--;
					map.put(numk, cnt);
				} else {
					map.remove(numk);
				}
			}

			long num = nums[i];
			Long floor = map.floorKey(num + t);
			Long ceil = map.ceilingKey(num - t);
			if (floor != null && floor >= num - t && ceil != null && ceil <= num + t) {
				System.out.println(num + ", floor: " + floor + ", ceil: " + ceil);
				return true;
			}

			Integer numCnt = map.get(num);
			if (numCnt == null) {
				numCnt = 1;
			} else {
				numCnt++;
			}
			map.put(num, numCnt);
		}
		return false;
	}

	public static void main(String[] args) {

		TreeMap<Integer, Integer> map = new TreeMap<>();
		map.put(1, 2);
		System.out.println(map.ceilingKey(2));
		System.out.println(map.ceilingKey(1));
		System.out.println(map.ceilingKey(0));
		System.out.println(map.floorKey(100));

		Q220 q = new Q220();
		int[] nums = { 1, 8, 2, 4, 9, 1, 4, 0 };
		System.out.println(q.containsNearbyAlmostDuplicate(nums, 1, 2) == true);
		System.out.println(q.containsNearbyAlmostDuplicate(nums, 2, 1) == true);
		System.out.println(q.containsNearbyAlmostDuplicate(nums, 3, 1) == true);
		System.out.println(q.containsNearbyAlmostDuplicate(nums, 1, 1) == false);

		int[] nums2 = { -1, -1 };
		System.out.println(q.containsNearbyAlmostDuplicate(nums2, 1, -1) == false);

		int[] nums3 = { 0, 2147483647 };
		System.out.println(q.containsNearbyAlmostDuplicate(nums3, 1, 2147483647) == true);

		int[] nums4 = { 0, 10, 22, 15, 0, 5, 22, 12, 1, 5 };
		System.out.println(q.containsNearbyAlmostDuplicate(nums4, 3, 3) == true);
	}

}
