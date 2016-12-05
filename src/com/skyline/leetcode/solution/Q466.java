package com.skyline.leetcode.solution;

/**
 * Count The Repetitions
 * 
 * https://leetcode.com/contest/leetcode-weekly-contest-11/problems/count-the-repetitions/
 * 
 * @author jairus
 *
 */
public class Q466 {

	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
		if (s1 == null || s1.length() <= 0 || n1 <= 0 || s2 == null || s2.length() <= 0 || n2 <= 0) {
			return 0;
		}
		if (s1.length() * n1 < s2.length() * n2) {
			return 0;
		}
		int j = 0;
		int c2 = s2.charAt(0);
		for (int k = 0; k < n1; k++) {
			for (int i = 0; i < s1.length(); i++) {
				int c1 = s1.charAt(i);
				if (c1 == c2) {
					j++;
					c2 = s2.charAt(j % s2.length());
				}
			}
			if (j % s2.length() == 0) {
				return (n1 / (k + 1) * j / n2 / s2.length());
			}
		}
		return j / n2 / s2.length();
	}

	public static void main(String[] args) {
		Q466 q = new Q466();
		long t1 = System.currentTimeMillis();
		System.out.println(q.getMaxRepetitions(
				"phqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjprepggxrpnrvystmwcysyycqpevikeffmznimkkasvwsrenzkycxf", 1000000,
				"xtlsgypsfadpooefxzbcoejuvpvaboygpoeylfpbnpljvrvipyamyehwqnqrqpmxujjloovaowuxwhmsncbxcoksfzkvatxdknly", 100));
		System.out.println(
				q.getMaxRepetitions("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
						1000000, "a", 1000000));
		System.out.println(q.getMaxRepetitions("acb", 4, "ab", 2));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);

	}

}
