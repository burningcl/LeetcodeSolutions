package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Super Ugly Number
 * 
 * https://leetcode.com/problems/super-ugly-number/
 * 
 * @author jairus
 *
 */
public class Q313 {

	public int nthSuperUglyNumber(int n, int[] primes) {
		if (n <= 1 || primes == null || primes.length < 1) {
			return 1;
		}
		List<Integer> list = new ArrayList<>();
		list.add(1);
		int[] indexes = new int[primes.length];
		for (int i = 1; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < primes.length; j++) {
				int sum = primes[j] * list.get(indexes[j]);
				if (sum < min) {
					min = sum;
				}
			}
			for (int j = 0; j < primes.length; j++) {
				int sum = primes[j] * list.get(indexes[j]);
				if (sum == min) {
					indexes[j]++;
				}
			}
			list.add(min);
		}
		return list.get(n - 1);
	}

	public static void main(String[] args) {
		int n = 1000000;
		int[] primes = { 2, 3, 5 };
		System.out.println(new Q313().nthSuperUglyNumber(n, primes));

	}

}
