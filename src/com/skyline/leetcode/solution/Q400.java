package com.skyline.leetcode.solution;

/**
 * Nth Digit
 * 
 * https://leetcode.com/problems/nth-digit/
 * 
 * @author jairus
 *
 */
public class Q400 {
	public int findNthDigit(int n) {
		int dLen = 0;
		long num = n;
		long d = 9;

		for (dLen = 1; num > 0;) {
			num -= d * (dLen);
			d *= 10;
			dLen++;
		}
		num += (d / 10 * --dLen - 1);
		d = d / 90;

		d += num / dLen;
		num = num % dLen;
		for (int i = dLen - 1; i > num; i--) {
			d /= 10;
		}

		return (int) (d % 10);
	}

	public static void main(String... strings) {
		Q400 q = new Q400();
		System.out.println(Integer.MAX_VALUE);
		System.out.println(q.findNthDigit((int) 100) == 5);
		System.out.println(q.findNthDigit(2147483644));
	}
}
