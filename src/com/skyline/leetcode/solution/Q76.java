package com.skyline.leetcode.solution;

/**
 * Minimum Window Substring
 * 
 * https://leetcode.com/problems/minimum-window-substring/
 * 
 * @author jairus
 *
 */
public class Q76 {

	public boolean valid(int[] sCnts, int[] tCnts, int minIndex, int maxIndex) {
		for (int i = minIndex; i <= maxIndex; i++) {
			if (sCnts[i] < tCnts[i]) {
				return false;
			}
		}
		return true;
	}

	public String minWindow(String s, String t) {
		if (s == null || t == null || s.length() < t.length()) {
			return "";
		}
		int[] sCnts = new int[128];
		int[] tCnts = new int[128];
		int minIndex = Integer.MAX_VALUE;
		int maxIndex = Integer.MIN_VALUE;
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			tCnts[c]++;
			if (c > maxIndex) {
				maxIndex = c;
			}
			if (c < minIndex) {
				minIndex = c;
			}
		}

		int minStart = 0;
		int minLen = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		while (j < s.length()) {
			while (!valid(sCnts, tCnts, minIndex, maxIndex) && j < s.length()) {
				sCnts[s.charAt(j++)]++;
			}
			while (valid(sCnts, tCnts, minIndex, maxIndex)) {
				if (j - i < minLen) {
					minLen = j - i;
					minStart = i;
				}
				sCnts[s.charAt(i++)]--;
			}
		}
		if (minLen >= Integer.MAX_VALUE) {
			return "";
		} else {
			return s.substring(minStart, minStart + minLen);
		}
	}

	public static void main(String[] args) {
		Q76 q = new Q76();
		System.out.println(q.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(q.minWindow("a", "b"));
	}

}
