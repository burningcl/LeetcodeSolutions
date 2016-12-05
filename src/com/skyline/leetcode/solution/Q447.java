package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Number of Boomerangs
 * 
 * https://leetcode.com/problems/number-of-boomerangs/
 * 
 * @author jairus
 *
 */
public class Q447 {
	public int numberOfBoomerangs(int[][] points) {
		if (points == null || points.length <= 1) {
			return 0;
		}
		int total = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < points.length; i++) {
			map.clear();
			int[] p1 = points[i];
			for (int j = 0; j < points.length; j++) {
				if (i == j) {
					continue;
				}
				int[] p2 = points[j];
				int n = 0;
				for (int k = 0; k < p1.length; k++) {
					n += (p1[k] - p2[k]) * (p1[k] - p2[k]);
				}
				Integer cnt = map.get(n);
				map.put(n, cnt == null ? 1 : cnt + 1);
			}
			for (int n : map.keySet()) {
				int cnt = map.get(n);
				int p = 0;
				for (int k = 2; k <= cnt; k++) {
					p += k;
				}
				System.out.println(n + ":" + cnt);
				total += p;
			}
		}
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
