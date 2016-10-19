package com.skyline.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Largest Number
 * 
 * https://leetcode.com/problems/largest-number/
 * 
 * @author jairus
 *
 */
public class Q179 {

	private int len(long num) {
		if (num == 0) {
			return 1;
		}
		int len = 0;
		while (num > 0) {
			num = num / 10;
			len++;
		}
		return len;
	}

	public String largestNumber(int[] nums) {
		if (nums == null || nums.length <= 0) {
			return "0";
		}
		int max = 0;
		Long[] newNums = new Long[nums.length];
		Map<Long, Integer> lenMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (num > max) {
				max = num;
			}
			newNums[i] = (long) num;
			lenMap.put((long) num, this.len(num));
		}
		if (max <= 0) {
			return "0";
		}

		int maxLen = len(max);
		int[] lens = new int[maxLen + 1];
		int t = 1;
		lens[0] = t;
		for (int i = 1; i <= maxLen; i++) {
			t = t * 10;
			lens[i] = t;
		}

		Arrays.sort(newNums, new Comparator<Long>() {

			@Override
			public int compare(Long o1, Long o2) {
				int len1 = lenMap.get(o1);
				int len2 = lenMap.get(o2);
				long n1 = o1 * lens[len2] + o2;
				long n2 = o2 * lens[len1] + o1;
				if (n1 > n2) {
					return -1;
				} else if (n1 < n2) {
					return 1;
				} else {
					return 0;
				}
			}
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < newNums.length; i++) {
			sb.append(newNums[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);

	}

}
