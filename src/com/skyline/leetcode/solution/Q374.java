package com.skyline.leetcode.solution;

/**
 * Guess Number Higher or Lower
 * 
 * https://leetcode.com/problems/guess-number-higher-or-lower/
 * 
 * @author jairus
 *
 */
public class Q374 {

	public int picked;

	public int guess(int num) {
		if (num > picked) {
			return -1;
		} else if (num == picked) {
			return 0;
		} else {
			return 1;
		}
	}

	public int guessNumber(int n) {
		long low = 1;
		long high = n;
		while (low < high) {
			int num = (int) ((low + high) >> 1);
			int result = guess(num);
			if (result == 0) {
				return num;
			} else if (result < 0) {
				high = num - 1;
			} else {
				low = num + 1;
			}
		}
		return (int) low;
	}

	public static void main(String... strings) {
		Q374 q = new Q374();
		q.picked = 1702766719;
		System.out.println(q.guessNumber(2126753390));
	}
}
