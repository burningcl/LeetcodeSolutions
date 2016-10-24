package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Summary Ranges
 * 
 * https://leetcode.com/problems/summary-ranges/
 * 
 * @author jairus
 *
 */
public class Q228 {

	private String toString(int start, int end) {
		if (start == end) {
			return String.valueOf(start);
		} else {
			return start + "->" + end;
		}
	}

	public List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<>();
		if (nums == null || nums.length <= 0) {
			return list;
		}
		int start = nums[0];
		int end = nums[0];
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (num > end + 1) {
				list.add(toString(start, end));
				start = end = num;
			} else {
				end = num;
			}
		}
		list.add(toString(start, end));
		return list;
	}

	public static void main(String[] args) {
		Q228 q = new Q228();
		int[] nums1 = { 0, 1, 2, 4, 5, 7 };
		System.out.println(q.summaryRanges(nums1));
		
		int[] nums2 = { 0,  2, 4, 7 };
		System.out.println(q.summaryRanges(nums2));
		
		int[] nums3 = { 1,2,3,4 };
		System.out.println(q.summaryRanges(nums3));
		
		int[] nums4 = { 1 };
		System.out.println(q.summaryRanges(nums4));
		
		int[] nums5 = { 1 ,3,4,5,6};
		System.out.println(q.summaryRanges(nums5));

	}

}
