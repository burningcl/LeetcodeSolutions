package com.skyline.leetcode.solution;

/**
 * 
 * Number of Segments in a String
 * 
 * https://leetcode.com/contest/leetcode-weekly-contest-11/problems/number-of-segments-in-a-string/
 * 
 * @author jairus
 *
 */
public class Q434 {

	public int countSegments(String s) {
		if (s == null || s.length() <= 0) {
			return 0;
		}
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ') {
				if (i <= 0 || s.charAt(i - 1) == ' ') {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Q434 q=new Q434();
		System.out.println(q.countSegments(" 1 2 3"));
		System.out.println(q.countSegments(" 1 2 3 "));
		System.out.println(q.countSegments(" 1  2 3"));
		System.out.println(q.countSegments(" 1 2   3"));
	}

}
