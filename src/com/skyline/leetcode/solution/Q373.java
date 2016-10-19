package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Find K Pairs with Smallest Sums
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * 
 * @author jairus
 *
 */
public class Q373 {

	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<int[]> list = new ArrayList<>();
		if (nums1 == null || nums1.length <= 0 || nums2 == null || nums2.length <= 0 || k <= 0) {
			return list;
		}
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				int[] pair = new int[2];
				pair[0] = nums1[i];
				pair[1] = nums2[j];
				list.add(pair);
			}
		}
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return (o1[0] + o1[1]) - (o2[0] + o2[1]);
			}
		});
		if (list.size() > k) {
			list = list.subList(0, k);
		}
		return list;
	}

	public static void main(String... strings) {
		int[] nums1 = { 1 };
		int[] nums2 = { 2, 4, 6 };
		int k = 20;
		List<int[]> list = new Q373().kSmallestPairs(nums1, nums2, k);
		System.out.println(list.size());
		for (int[] item : list) {
			System.out.println(item[0] + ", " + item[1]);
		}
	}
}
