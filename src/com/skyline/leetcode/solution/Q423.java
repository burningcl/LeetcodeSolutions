package com.skyline.leetcode.solution;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Reconstruct Original Digits from English
 * 
 * https://leetcode.com/problems/reconstruct-original-digits-from-english/
 * 
 * @author jairus
 *
 */
public class Q423 {

	// public boolean originalDigits(int[] array, int index, int len, String[]
	// nums, int[] cnts) {
	// if (index >= 10 || len < 0) {
	// return false;
	// }
	// String num = nums[index];
	// int size = Integer.MAX_VALUE;
	// for (int i = 0; i < num.length(); i++) {
	// int cindex = num.charAt(i);
	// if (array[cindex] < size) {
	// size = array[cindex];
	// }
	// }
	// //System.out.println(size);
	// //System.out.println(index+", "+len+", "+size);
	// for (int i = size; i >= 0; i--) {
	// boolean match = true;
	// for (int j = 0; j < num.length(); j++) {
	// int cindex = num.charAt(j);
	// array[cindex] -= i;
	// if (array[cindex] < 0) {
	// match = false;
	// }
	// }
	// cnts[index] += i;
	// len -= i * num.length();
	// if (match) {
	// if (len == 0 || this.originalDigits(array, index + 1, len, nums, cnts)) {
	// return true;
	// }
	// }
	// len += i * num.length();
	// for (int j = 0; j < num.length(); j++) {
	// int cindex = num.charAt(j);
	// array[cindex] += i;
	// }
	// cnts[index] -= i;
	// }
	// return false;
	// }
	//
	// public String originalDigits(String s) {
	// if (s == null || s.length() <= 0) {
	// return "";
	// }
	// String[] nums = { "zero", "one", "two", "three", "four", "five", "six",
	// "seven", "eight", "nine" };
	// int[] array = new int[128];
	// int len = s.length();
	// for (int i = 0; i < len; i++) {
	// array[s.charAt(i)]++;
	// }
	// int[] cnts = new int[10];
	// this.originalDigits(array, 0, len, nums, cnts);
	// StringBuilder sb = new StringBuilder();
	// for (int i = 0; i < 10; i++) {
	// for (int j = 0; j < cnts[i]; j++)
	// sb.append(i);
	// }
	// return sb.toString();
	// }

	static final String[] numStrs = { "zero", "six", "eight", "four", "three", "seven", "two", "one", "five", "nine" };
	static final int[] numInts = { 0, 6, 8, 4, 3, 7, 2, 1, 5, 9 };
	static final char[] cs = { 'z', 'x', 'g', 'u', 'h', 's', 't', 'o', 'f', 'i' };

	public String originalDigits(String s) {
		if (s == null || s.length() <= 0) {
			return "";
		}
		int[] array = new int[128];
		for (int i = 0; i < s.length(); i++) {
			array[s.charAt(i)]++;
		}
		int[] cnts = new int[10];
		for (int i = 0; i < 10; i++) {
			String num = numStrs[i];
			int size = array[cs[i]];
			cnts[numInts[i]] = size;
			for (int j = 0; j < num.length(); j++) {
				array[num.charAt(j)] -= size;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < cnts[i]; j++)
				sb.append(i);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Q423 q = new Q423();
		System.out.println(q.originalDigits("owoztneoer"));
		String[] nums = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
		Random ran = new Random();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 1000; i++) {
			sb.append(nums[ran.nextInt(10)]);
		}
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 100; i++)
			q.originalDigits(sb.toString());
		long t2 = System.currentTimeMillis();
		System.out.println("cost: " + (t2 - t1));
		System.out.println(q.originalDigits("nnei"));
	}

}
