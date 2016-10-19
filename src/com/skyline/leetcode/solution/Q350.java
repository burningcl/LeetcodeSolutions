package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Intersection of Two Arrays II
 *
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * 
 * @author jairus
 *
 */
public class Q350 {

	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) {
			return null;
		}
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		List<Integer> list = new ArrayList<>();
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums2[j] < nums1[i]) {
				j++;
			} else {
				list.add(nums1[i]);
				i++;
				j++;
			}
		}
		int[] ret = new int[list.size()];
		for (i = 0; i < list.size(); i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}

	public static void main(String... strings) {

	}

}
