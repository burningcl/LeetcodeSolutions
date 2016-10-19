package com.skyline.leetcode.solution;

/**
 * Unique Binary Search Trees
 * 
 * https://leetcode.com/problems/unique-binary-search-trees/
 * 
 * @author jairus
 *
 */
public class Q96 {

	int[][] cache = null;

	public int numTrees(int start, int end) {
		if (start > end) {
			return 1;
		}
		if (cache[start][end] > 0) {
			return cache[start][end];
		}
		int cnt = 0;
		for (int i = start; i <= end; i++) {
			int left = numTrees(start, i - 1);
			int right = numTrees(i + 1, end);
			cnt += (left * right);
		}
		cache[start][end] = cnt;
		return cnt;
	}

	public int numTrees(int n) {
		cache = new int[n + 2][n + 2];
		return numTrees(1, n);
	}
}
