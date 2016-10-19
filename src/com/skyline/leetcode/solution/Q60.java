package com.skyline.leetcode.solution;

/**
 * Permutation Sequence
 * 
 * https://leetcode.com/problems/permutation-sequence/
 * 
 * @author jairus
 *
 */
public class Q60 {

	public String getPermutation(int n, int k) {
		if (k < 0) {
			return "";
		}
		int total = 1;
		for (int i = 2; i < n; i++) {
			total *= i;
		}
		k--;
		boolean[] visiteds = new boolean[n];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int pos = k / total;
			int cnt = 0;
			int j = 0;
			for (; j < n && cnt <= pos; j++) {
				if (!visiteds[j]) {
					cnt++;
				}
			}
			sb.append(j);
			visiteds[--j] = true;
			k = k % total;
			if ((n - i - 1) > 0)
				total /= (n - i - 1);
		}
		return sb.toString();
	}

	public static void main(String... strings) {
		Q60 q = new Q60();
		for (int i = 1; i <= 2; i++)
			System.out.println(q.getPermutation(2, i));
	}
}
