package com.skyline.leetcode.solution;

/**
 * https://leetcode.com/problemset/algorithms/
 * 
 * @author jairus
 *
 */
public class Q263 {
	public boolean isUgly(int num) {
		if (num <= 0) {
			return false;
		}
		int[] array = { 2, 3, 5 };
		while (num > 1) {
			boolean flag = false;
			for (int i : array) {
				if (num % i == 0) {
					num /= i;
					flag = true;
				}
			}
			if (!flag) {
				return false;
			}
		}
		return true;
	}

	public static void main(String... strings) {
		Q263 q = new Q263();
		System.out.println(q.isUgly(2));
		System.out.println(q.isUgly(6));
		System.out.println(q.isUgly(30));
		System.out.println(q.isUgly(120));
		System.out.println(q.isUgly(99));
	}
}
