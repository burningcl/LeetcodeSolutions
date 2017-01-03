package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Minimum Height Trees
 * 
 * https://leetcode.com/problems/minimum-height-trees/
 * 
 * 
 * @author jairus
 *
 */
public class Q310 {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> list = new ArrayList<Integer>();
		if (n <= 0) {
			return list;
		} else if (n == 1) {
			list.add(0);
			return list;
		}

		List<List<Integer>> map = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			map.add(new ArrayList<>());
		}
		int[] degree = new int[n];
		for (int i = 0; i < edges.length; i++) {
			int[] edge = edges[i];
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
			degree[edge[0]]++;
			degree[edge[1]]++;
		}
		List<Integer> l1 = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (degree[i] == 0) {
				return list;
			}
			if (degree[i] == 1) {
				l1.add(i);
			}
		}

		int cnt = 0;
		List<Integer> l2 = new ArrayList<Integer>();
		while (cnt < n - 2) {
			cnt += l1.size();
			for (int index : l1) {
				degree[index] = 0;
			}
			if (cnt >= n - 2) {
				break;
			}
			for (int index : l1) {
				List<Integer> ns = map.get(index);
				for (int ni : ns) {
					if (--degree[ni] == 1) {
						l2.add(ni);
					}
				}
			}
			l1.clear();
			List<Integer> tl = l2;
			l2 = l1;
			l1 = tl;
		}

		for (int i = 0; i < n; i++) {
			if (degree[i] > 0)
				list.add(i);
		}

		return list;
	}

	public static void main(String[] args) {
		Q310 q = new Q310();
		int[][] edges = {};
		System.out.println(q.findMinHeightTrees(1, edges));
		int[][] e1 = { { 1, 0 }, { 1, 2 }, { 1, 3 } };
		System.out.println(q.findMinHeightTrees(4, e1));
		int[][] e2 = { { 0, 3 }, { 1, 3 }, { 2, 3 }, { 4, 3 }, { 5, 4 } };
		System.out.println(q.findMinHeightTrees(6, e2));
		int[][] e3 = { { 0, 1 } };
		System.out.println(q.findMinHeightTrees(2, e3));
	}

}
