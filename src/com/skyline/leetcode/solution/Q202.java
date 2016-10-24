package com.skyline.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Happy Number
 * 
 * https://leetcode.com/problems/happy-number/
 * 
 * @author jairus
 *
 */
public class Q202 {

	public boolean isHappy(int n, Set<Integer> set) {
		if (set.contains(n)) {
			return false;
		}
		set.add(n);
		int val = 0;
		while (n > 0) {
			int v = n % 10;
			val += v * v;
			n = n / 10;
		}
		if (val == 1) {
			return true;
		} else {
			return isHappy(val, set);
		}
	}

	public boolean isHappy(int n) {
		return this.isHappy(n, new HashSet<>());
	}

	public static void main(String[] args) {
		Q202 q = new Q202();
		// for (int i = 0; i < 100; i++)
		// System.out.println(i + "\t" + q.isHappy(i));
		System.out.println(q.isHappy(1111111));
	}

}
