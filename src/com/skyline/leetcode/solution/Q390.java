package com.skyline.leetcode.solution;

/**
 * Elimination Game
 * 
 * https://leetcode.com/problems/elimination-game/
 * 
 * @author jairus
 *
 */
public class Q390 {

	public int lastRemaining2(final int n) {
		if (n <= 1) {
			return n;
		}
		boolean[] array = new boolean[n];
		int time = 0;
		int num = n;
		while (true) {
			int cnt = 0;
			if (time % 2 == 0) {
				for (int i = 0; i < n; i++) {
					if (array[i]) {
						continue;
					}
					if (cnt % 2 == 0) {
						array[i] = true;
					}
					cnt++;
				}
			} else {
				for (int i = n - 1; i >= 0; i--) {
					if (array[i]) {
						continue;
					}
					if (cnt % 2 == 0) {
						array[i] = true;
					}
					cnt++;
				}
			}
			num = num / 2;
			if (num <= 1) {
				break;
			}
			time++;
		}
		for (int i = 0; i < n; i++) {
			if (!array[i]) {
				return i + 1;
			}
		}
		return 0;
	}

	// public int lastRemaining(final int n) {
	// if (n <= 1) {
	// return n;
	// }
	// int time = 0;
	// int num = n;
	// int start = 2;
	// int div = 2;
	// while (num > 1) {
	// int size = n / div - 1;
	// if (time % 2 == 0) {
	// start = start + (size * div);
	// } else {
	// start = start - (size * div);
	// }
	// num = num / 2;
	// div = div << 1;
	// time++;
	// }
	// return start;
	// }

	public int lastRemaining(int n) {
		if (n <= 1) {
			return n;
		}
		int time = 0;
		int low = 1;
		int high = n;
		int div = 1;
		while (low < high) {
			if (time % 2 == 0) {
				if ((high - low) % (div * 2) == 0) {
					high -= div;
				}
				low += div;
			} else {
				if ((high - low) % (div * 2) == 0) {
					low += div;
				}
				high -= div;
			}
			n = n / 2;
			div = div << 1;
			time++;
		}
		return low;
	}

	public static void main(String... strings) {
		Q390 q = new Q390();
		for (int i = 1; i < 100000000; i++) {
			System.out.println(i);
			if (q.lastRemaining(i) != q.lastRemaining2(i)) {
				System.out.println("fail, " + i);
				break;
			}
		}
	}
}
