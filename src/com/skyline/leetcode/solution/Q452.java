package com.skyline.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Minimum Number of Arrows to Burst Balloons
 * 
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * 
 * @author jairus
 *
 */
public class Q452 {

	public int findMinArrowShots(int[][] points) {
		if (points.length <= 0)
			return 0;
		Arrays.sort(points, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1]: o1[0] - o2[0];
			}
		});
		int cnt = 1;
		int end = points[0][1];
		for (int i = 1; i < points.length; i++) {
			int[] point = points[i];
			if (end < point[0]) {
				end = point[1];
				cnt++;
			} else {
				if (end > point[1]) {
					end = point[1];
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
