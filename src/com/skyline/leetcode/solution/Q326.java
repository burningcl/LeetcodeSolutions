package com.skyline.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

public class Q326 {

	Set<Integer> cache;

	public boolean isPowerOfThree(int n) {
		if (cache == null) {
			cache = new HashSet<>();
			int i = 1;
			while (i > 0) {
				cache.add(i);
				i *= 3;
			}
		}
		return cache.contains(n);
	}

	public static void main(String... strings) {
		int i = 1;
		while (i > 0) {
			System.out.println(i);
			i *= 3;
		}
	}
}
