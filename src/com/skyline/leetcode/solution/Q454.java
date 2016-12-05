package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 4Sum II
 * 
 * https://leetcode.com/problems/4sum-ii/
 * 
 * @author jairus
 *
 */
public class Q454 {

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		if (A == null || A.length <= 0 || B == null || B.length <= 0 || C == null || C.length <= 0 || D == null
				|| D.length <= 0) {
			return 0;
		}
		Map<Integer, Integer> CD = new HashMap<>();
		for (int c : C) {
			for (int d : D) {
				Integer cnt = CD.get(c + d);
				CD.put(c + d, cnt == null ? 1 : cnt + 1);
			}
		}
		int total = 0;
		for (int a : A) {
			for (int b : B) {
				Integer cnt = CD.get(-a - b);
				total += cnt == null ? 0 : cnt;
			}
		}
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
