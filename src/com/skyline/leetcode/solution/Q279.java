package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Perfect Squares
 * 
 * https://leetcode.com/problems/perfect-squares/
 * 
 * @author jairus
 *
 */
public class Q279 {

	// public int numSquares(int n) {
	// if (n <= 0) {
	// return 0;
	// } else if (n <= 3) {
	// return n;
	// }
	// int sqrt = (int) Math.sqrt(n);
	// if (sqrt * sqrt == n) {
	// return 1;
	// }
	// int[] array = new int[n + 1];
	// array[1] = 1;
	// for (int i = 2; i <= n; i++) {
	// sqrt = (int) Math.sqrt(i);
	// if (sqrt * sqrt == i) {
	// array[i] = 1;
	// continue;
	// }
	// int min =array[sqrt * sqrt ]+array[i- sqrt * sqrt ];
	// array[i] = min;
	// }
	// return array[n];
	// }

	public int numSquares(int n, Map<Integer, Integer> map) {
		if (n <= 0) {
			return 0;
		}
		if (map.containsKey(n)) {
			return map.get(n);
		}
		int sqrt = (int) Math.sqrt(n);
		int v = sqrt * sqrt;
		int ret = Integer.MAX_VALUE;
		if (n % v == 0) {
			ret = n / v;
		} else {
			for (int i = sqrt; i >= 1; i--) {
				v = i * i;
				int v1 = n - n / v * v;
				if (n / v >= ret) {
					break;
				}
				int min = n / v + numSquares(v1, map);
				if (min < ret) {
					ret = min;
				}
			}
		}
		map.put(n, ret);
		return ret;
	}

	public int numSquares(int n) {
		return this.numSquares(n, new HashMap<>());
	}

	public static void main(String[] args) {
		Q279 q = new Q279();
		System.out.println(q.numSquares(1002) == 3);
		System.out.println(q.numSquares(766665));
		System.out.println(q.numSquares(54581) == 2);
		System.out.println(q.numSquares(12));
		System.out.println(q.numSquares(Integer.MAX_VALUE));
		System.out.println(Integer.MAX_VALUE);
		// System.out.println(Math.sqrt(766665));
	}

}
