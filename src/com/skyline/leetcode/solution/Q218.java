package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * The Skyline Problem
 * 
 * https://leetcode.com/problems/the-skyline-problem/
 * 
 * @author jairus
 *
 */
public class Q218 {

	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> list = new ArrayList<>();
		if (buildings == null || buildings.length <= 0) {
			return list;
		}
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[2] - o1[2];
			}
		});
		Arrays.sort(buildings, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] != o2[0] ? o1[0] - o2[0] : o2[2] - o1[2];
			}
		});
		int height = 0;
		for (int i = 0; i <= buildings.length; i++) {
			long start = i < buildings.length ? buildings[i][0] : Long.MAX_VALUE;
			int[] p = null;
			while (!queue.isEmpty() && queue.peek()[1] <= start) {
				p = queue.poll();
				while (!queue.isEmpty() && queue.peek()[1] <= p[1]) {
					queue.poll();
				}
				int ht = queue.isEmpty() ? 0 : queue.peek()[2];
				if (height != ht && p[1] < start) {
					int[] item = new int[2];
					item[0] = p[1];
					item[1] = ht;
					list.add(item);
				}
				height = ht;
			}
			if (i < buildings.length) {
				int[] b = buildings[i];
				queue.add(b);
				if (height < b[2] && (p == null || p[1] < b[0] || p[2] != b[2])) {
					int[] item = new int[2];
					item[0] = b[0];
					item[1] = b[2];
					list.add(item);
				}
				height = Math.max(height, b[2]);
			}
		}

		return list;
	}

	public static void main(String[] args) {
		Q218 q = new Q218();
		// int[][] bs = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20,
		// 10 }, { 19, 24, 8 } };
		// System.out.println(q.getSkyline(bs));
		//
		// int[][] bs1 = { { 1, 10, 2 }, { 2, 9, 2 }, { 3, 7, 3 } };
		// System.out.println(q.getSkyline(bs1));

		int[][] bs2 = { { 0, 2, 3 }, { 2, 5, 3 } };
		System.out.println(q.getSkyline(bs2));
	}

}
