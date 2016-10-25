package com.skyline.leetcode.solution;

/**
 * Number of Digit One
 * 
 * https://leetcode.com/problems/number-of-digit-one/
 * 
 * @author jairus
 *
 */
public class Q233 {

	private int len(int n) {
		int len = 0;
		while (n > 0) {
			len++;
			n /= 10;
		}
		return len;
	}

	private int[] array(int len) {
		int[] array = new int[len + 1];
		for (int i = 1; i <= len; i++) {
			array[i] = (int) Math.pow(10, i - 1) + 10 * array[i - 1];
		}
		return array;
	}

	public int countDigitOne(int n) {
		int len = this.len(n);
		int[] array = this.array(len);
		int sum = 0;
		long size = 1;
		int level = 0;
		while (n / size > 0 && size > 0) {
			long n1 = n / size % 10;
			long n2 = n % size;
			long cnt1 = n1 * array[level];
			long cnt2 = n1 == 0 ? 0 : (n1 == 1 ? n2 + 1 : size);
			sum += cnt1 + cnt2;
			size *= 10;
			level++;
		}
		return sum;
	}

	public static void main(String[] args) {
		Q233 q = new Q233();
		System.out.println(q.countDigitOne(999) == 300);
		System.out.println(q.countDigitOne(99) == 20);
		System.out.println(q.countDigitOne(9) == 1);
		System.out.println(q.countDigitOne(100) == 21);
		System.out.println(q.countDigitOne(991) == 300);
		System.out.println(q.countDigitOne(56789) == 33059);
		System.out.println(q.countDigitOne(1000) == 301);
		System.out.println(q.countDigitOne(14521) == 10935);
		System.out.println(q.countDigitOne(1410065408) == 1737167499);
		System.out.println(q.countDigitOne(Integer.MAX_VALUE));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(1000000000 * 10);
	}

}
