package com.skyline.leetcode.solution;

/**
 * Russian Doll Envelopes
 * 
 * https://leetcode.com/problems/russian-doll-envelopes/
 * 
 * @author jairus
 *
 */
public class Q354 {

	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null) {
			return 0;
		} else if (envelopes.length <= 1) {
			return envelopes.length;
		}
		int[] cache = new int[envelopes.length];
		int max = 0;
		for (int i = 0; i < envelopes.length; i++) {
			int cm = maxEnvelopes(envelopes, i, cache);
			if (cm > max) {
				max = cm;
			}
		}
		return max;
	}

	private int maxEnvelopes(int[][] envelopes, int cur, int[] cache) {
		if (cache[cur] > 0) {
			return cache[cur];
		}
		int[] e = envelopes[cur];
		int max = 0;
		for (int i = 0; i < envelopes.length; i++) {
			int[] ce = envelopes[i];
			if (e[0] > ce[0] && e[1] > ce[1]) {
				int cm = maxEnvelopes(envelopes, i, cache);
				if (cm > max) {
					max = cm;
				}
			}
		}
		max++;
		cache[cur] = max;
		return max;
	}

	public static void main(String... strings) {
		int[][] envelopes = { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 2, 3 } };
		System.out.println(new Q354().maxEnvelopes(envelopes));
	}

}
