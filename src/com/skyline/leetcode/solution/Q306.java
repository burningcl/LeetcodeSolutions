package com.skyline.leetcode.solution;

/**
 * Additive Number
 * 
 * https://leetcode.com/problems/additive-number/
 * 
 * @author jairus
 *
 */
public class Q306 {

	public boolean isAdditiveNumber(int[] nums, long add1, long add2, int start) {
		if (start >= nums.length) {
			return false;
		}
		long r = 0;
		long sum = add1 + add2;
		for (int i = start; i < nums.length; i++) {
			r = r * 10 + nums[i];
			if (r <= 0 && add1 > 0 && add2 > 0) {
				return false;
			} else if (r > sum) {
				return false;
			} else if (r == sum) {
				add1 = add2;
				add2 = sum;
				sum = add1 + add2;
				if ((sum ^ add1) < 0 && (sum ^ add2) < 0) {
					// overflow
					return false;
				}
				r = 0;
				if (i == nums.length - 1) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isAdditiveNumber(String num) {
		if (num == null || num.length() < 3) {
			return false;
		}
		int[] nums = new int[num.length()];
		for (int i = 0; i < num.length(); i++) {
			nums[i] = num.charAt(i) - '0';
		}
		long add1 = 0;

		int size1 = num.length();
		for (int i = 0; i < size1 && add1 >= 0; i++) {
			add1 = add1 * 10 + nums[i];
			if (add1 == 0) {
				size1 = 1;
			}
			long add2 = 0;
			int size2 = num.length();
			for (int j = i + 1; j < size2 && add2 >= 0; j++) {
				add2 = add2 * 10 + nums[j];
				if (add2 == 0) {
					size2 = i + 2;
				}
				// System.out.println("add1: " + add1 + ", add2: " + add2);
				if (this.isAdditiveNumber(nums, add1, add2, j + 1))
					return true;
			}
		}
		return false;
	}

	public static void main(String... strings) {
		Q306 q = new Q306();
		System.out.println(q.isAdditiveNumber("112358"));
		System.out.println(q.isAdditiveNumber("199100199"));
		System.out.println(q.isAdditiveNumber("101121"));
		System.out.println(q.isAdditiveNumber("199100200")==false);
		System.out.println(q.isAdditiveNumber("0000"));
		System.out.println(q.isAdditiveNumber("1011"));
		System.out.println(q.isAdditiveNumber("0112"));
	}

}
