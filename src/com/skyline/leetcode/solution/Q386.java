package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Lexicographical Numbers
 * 
 * https://leetcode.com/problems/lexicographical-numbers/
 * 
 * @author jairus
 *
 */
public class Q386 {
	// public List<Integer> lexicalOrder(int n) {
	// List<Integer> list = new ArrayList<>();
	// if (n <= 0) {
	// return list;
	// }
	// int size = 0;
	// int tn = n;
	// while (tn > 0) {
	// size++;
	// tn = tn / 10;
	// }
	// for (int i = 1; i <= 9 && i <= n; i++) {
	// list.add(i);
	// int max = i;
	// int min = i;
	// for (int j = 1; j < size; j++) {
	// max = max * 10 + 9;
	// min = min * 10;
	// int end = n < max ? n : max;
	// for (int k = min; k <= end; k++) {
	// list.add(k);
	// }
	// }
	// }
	// return list;
	// }

	public void lexicalOrder(int num, int level, final int totalLevel, final int max, List<Integer> list) {
		if (level > totalLevel) {
			return;
		}
		list.add(num);
		int start = num * 10;
		int end = start + 9;
		end = end < max ? end : max;
		for (int i = start; i <= end; i++) {
			lexicalOrder(i, 1, totalLevel, max, list);
		}
	}

	public List<Integer> lexicalOrder(int n) {
		List<Integer> list = new ArrayList<>();
		if (n <= 0) {
			return list;
		}
		int totalLevel = 0;
		int tn = n;
		while (tn > 0) {
			totalLevel++;
			tn = tn / 10;
		}
		for (int i = 1; i <= 9 && i <= n; i++) {
			lexicalOrder(i, 1, totalLevel, n, list);
		}
		return list;
	}

	public static void main(String... strings) {
		Q386 q = new Q386();
		System.out.println(q.lexicalOrder(0));
		System.out.println(q.lexicalOrder(1));
		System.out.println(q.lexicalOrder(2));
		System.out.println(q.lexicalOrder(8));
		System.out.println(q.lexicalOrder(9));
		System.out.println(q.lexicalOrder(10));
		System.out.println(q.lexicalOrder(11));
		System.out.println(q.lexicalOrder(55));
		System.out.println(q.lexicalOrder(99));
		System.out.println(q.lexicalOrder(100));
		System.out.println(q.lexicalOrder(101));
		System.out.println(q.lexicalOrder(555));
		System.out.println(q.lexicalOrder(998));
		System.out.println(q.lexicalOrder(999));
	}
}
