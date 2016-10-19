package com.skyline.leetcode.solution;

/**
 * Interleaving String
 * 
 * https://leetcode.com/problems/interleaving-string/
 * 
 * @author jairus
 *
 */
public class Q97 {

	boolean[][] map = null;

	private char charAt(String s, int i) {
		return i < s.length() ? s.charAt(i) : 0;
	}

	public boolean isInterleave(final String s1, final int i1, final String s2, final int i2, final String s3,
			final int i3) {
		if (map[i1][i2]) {
			return false;
		}
		if (i1 >= s1.length() && i2 >= s2.length() && i3 >= s3.length()) {
			return true;
		}
		char c1 = charAt(s1, i1);
		char c2 = charAt(s2, i2);
		char c3 = charAt(s3, i3);

		if (c1 == c3) {
			if (isInterleave(s1, i1 + 1, s2, i2, s3, i3 + 1))
				return true;
		}
		if (c2 == c3) {
			if (isInterleave(s1, i1, s2, i2 + 1, s3, i3 + 1))
				return true;
		}
		map[i1][i2] = true;
		return false;
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null) {
			return false;
		} else if (s1.length() + s2.length() != s3.length()) {
			return false;
		}
		map = new boolean[s1.length() + 1][s2.length() + 1];
		return this.isInterleave(s1, 0, s2, 0, s3, 0);
	}

	public static void main(String... strings) {
		Q97 q = new Q97();
		System.out.println(q.isInterleave("a", "b", "ba"));
		System.out.println(q.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		System.out.println(q.isInterleave(
				"bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
				"babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
				"babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
	}
}
