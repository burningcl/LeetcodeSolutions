package com.skyline.leetcode.solution;

/**
 * 372. Super Pow
 * 
 * https://leetcode.com/problems/super-pow/
 * 
 * @author jairus
 *
 */
public class Q372 {

	public int superPow(int a, int[] b) {
		int n = 1337;
		int[] cache = new int[n];
		long cur = 1;
		int circle = 0;
		for (int i = 0; i < n; i++) {
			cur *= a;
			cur = cur % n;
			if (cur == cache[0]) {
				circle = i;
				break;
			} else {
				cache[i] = (int)cur;
			}
		}
		if (circle == 0)
			return 0;
		cur = 0;
		for (int i = 0; i < b.length; i++) {
			int bi = b[i];
			if (bi == 0) {
				cur *= 10;
			} else{
				while (bi > 0) {
					bi /= 10;
					cur *= 10;
				}
			}
			cur += b[i];
			cur = cur % circle;
		}
		cur = (cur - 1 + circle) % circle;
		return cache[(int)cur];
	}

	public static void main(String... strings) {
		int a = 2147483647;
		int[] b = { 2, 0, 0 };
		System.out.println(new Q372().superPow(a, b));
	}
}
