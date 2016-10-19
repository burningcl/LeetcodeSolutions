package com.skyline.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Power of Four
 * 
 * https://leetcode.com/problems/power-of-four/
 * 
 * @author jairus
 *
 */
public class Q342 {

	Set<Integer> set = null;

	public boolean isPowerOfFour(int num) {
		if (set == null) {
			set = new HashSet<>();
			int n = 1;
			while (n < Integer.MAX_VALUE) {
				set.add(n);
				System.out.println(n);
				int n2 = n * 4;
				if (n2 > n)
					n = n2;
				else
					break;

			}
		}
		return set.contains(num);

	}

	public static void main(String... strings) {
		System.out.println(new Q342().isPowerOfFour(16));
	}
}
