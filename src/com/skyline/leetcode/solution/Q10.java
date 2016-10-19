package com.skyline.leetcode.solution;

/**
 * Regular Expression Matching
 * 
 * https://leetcode.com/problems/regular-expression-matching/
 * 
 * @author jairus
 *
 */
public class Q10 {

	private boolean isMatch(String s, String p, int sIndex, int pIndex) {
		// System.out.println(sIndex + ", " + pIndex);
		if (s == null || p == null) {
			return false;
		} else if (sIndex >= s.length() && pIndex >= p.length()) {
			return true;
		} else if (sIndex < s.length() && pIndex >= p.length()) {
			return false;
		}
		boolean inifinite = false;
		Character pChar = p.charAt(pIndex);
		pIndex++;
		if (pIndex < p.length()) {
			char pNextChar = p.charAt(pIndex);
			if (pNextChar == '*') {
				inifinite = true;
				pIndex++;
			}
		}
		if (sIndex >= s.length()) {
			if (inifinite) {
				return isMatch(s, p, sIndex, pIndex);
			} else {
				return false;
			}
		}
		if (!inifinite) {
			if (pChar != s.charAt(sIndex) && pChar != '.')
				return false;
			sIndex++;
		} else {
			while (sIndex < s.length()) {
				char c = s.charAt(sIndex);
				if (c != pChar && pChar != '.') {
					break;
				} else if (isMatch(s, p, sIndex, pIndex)) {
					return true;
				}
				sIndex++;
			}
		}
		return isMatch(s, p, sIndex, pIndex);
	}

	public boolean isMatch(String s, String p) {
		return isMatch(s, p, 0, 0);
	}

	public static void main(String... strings) {
		Q10 q = new Q10();
		String[] ss = { "aa", "aa", "aaa", "aa", "aa", "ab", "aab", "abc", "aaaab", "aaa" };
		String[] ps = { "a", "aa", "aa", "a*", ".*", ".*", "c*a*b*", "abd", ".*a*aabc*d*.*", "a.a" };
		boolean[] ms = { false, true, false, true, true, true, true, false, true, true };
		for (int i = 0; i < ss.length; i++) {
			boolean m = q.isMatch(ss[i], ps[i]);
			System.out.println(ss[i] + "\t" + ps[i] + "\t" + m + "\t" + (m == ms[i]));
		}
	}
}
