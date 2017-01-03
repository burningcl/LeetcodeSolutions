package com.skyline.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort Characters By Frequency
 * 
 * https://leetcode.com/problems/sort-characters-by-frequency/
 * 
 * @author jairus
 *
 */
public class Q451 {

	public static final int IDX_CHAR = 0;
	public static final int IDX_CNT = 1;

	public String frequencySort(String s) {
		if (s == null || s.length() <= 0) {
			return "";
		}
		int[][] array = new int[128][2];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (array[c][IDX_CNT] == 0) {
				array[c][IDX_CHAR] = c;
			}
			array[c][IDX_CNT]++;
		}
		Arrays.sort(array, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[IDX_CNT] - o1[IDX_CNT];
			}
		});
		StringBuilder sb = new StringBuilder();
		for (int[] sub : array) {
			for (int i = 0; i < sub[IDX_CNT]; i++) {
				sb.append((char) sub[IDX_CHAR]);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
