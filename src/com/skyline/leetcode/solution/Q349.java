package com.skyline.leetcode.solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Intersection of Two Arrays
 *
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * 
 * @author jairus
 *
 */
public class Q349 {

	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null) {
			return null;
		}
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0;
		int j = 0;
		Set<Integer> set = new HashSet<>();
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums2[j] < nums1[i]) {
				j++;
			} else {
				set.add(nums1[i]);
				i++;
				j++;
			}
		}
		Iterator<Integer> it = set.iterator();
		int[] ret = new int[set.size()];
		int c = 0;
		while (it.hasNext()) {
			ret[c++] = it.next();
		}
		return ret;
	}

	public static void main(String... strings) {

	}

}
