package com.skyline.leetcode.solution;

/**
 * Add Digits
 * 
 * https://leetcode.com/problems/add-digits/
 * 
 * @author jairus
 *
 */
public class Q258 {
	public int addDigits1(int num) {
		while (num >= 10) {
			num = num / 10 + num % 10;
		}
		return num;
	}

	public int addDigits(int num) {
		 return (num - 1) % 9 + 1;
	}

	public static void main(String[] args) {
		Q258 q = new Q258();
		for (int i = 0; i < 100; i++) {
			System.out.println(i + "\t" + q.addDigits1(i) + "\t" + q.addDigits(i));
		}

	}

}
