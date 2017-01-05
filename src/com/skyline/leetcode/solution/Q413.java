package com.skyline.leetcode.solution;

/**
 * Arithmetic Slices
 * 
 * https://leetcode.com/problems/arithmetic-slices/
 * 
 * @author jairus
 *
 */
public class Q413 {

	public int numberOfArithmeticSlices(int[] A) {
		if (A == null || A.length < 3)
			return 0;
		int total = 0;
		int listCnt = 0;
		int diff = A[1] - A[0];
		int cdiff = 0;
		for (int i = 2; i < A.length; i++) {
			cdiff = A[i] - A[i - 1];
			if (cdiff == diff) {
				listCnt++;
			} else {
				if (listCnt > 0) {
					total += (listCnt + 1) * listCnt / 2;
					listCnt = 0;
				}
				diff = cdiff;
			}
		}
		total += (listCnt + 1) * listCnt / 2;
		return total;
	}

	public static void main(String[] args) {
		Q413 q = new Q413();
		int[] A = { 1, 2, 3, 4, 5, 77, 2332 };
		System.out.println(q.numberOfArithmeticSlices(A));
	}

}
