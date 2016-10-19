package com.skyline.leetcode.solution;

/**
 * Rotate Function
 * 
 * https://leetcode.com/problems/rotate-function/
 * 
 * @author jairus
 *
 */
public class Q396 {

	public int maxRotateFunction(int[] A) {
		if (A == null || A.length <= 0) {
			return 0;
		}
		int sum = 0;
		int max = 0;
		int total = 0;
		for (int i = 0; i < A.length; i++) {
			total += A[i];
			sum += A[i] * i;
		}
		max = sum;
		for (int i = 0; i < A.length - 1; i++) {
			sum -= total;
			sum += A.length * A[i];
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		Q396 q = new Q396();
		int[] A = { 4, 3, 2 };
		System.out.println(q.maxRotateFunction(A));
	}

}
