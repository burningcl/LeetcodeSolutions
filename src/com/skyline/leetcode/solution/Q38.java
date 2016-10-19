package com.skyline.leetcode.solution;

/**
 * Count and Say
 * 
 * https://leetcode.com/problems/count-and-say/
 * 
 * @author jairus
 *
 */
public class Q38 {

	public String[] cache = null;

	public String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}
		if (cache == null) {
			cache = new String[128];
		}
		if (cache[n] != null) {
			return cache[n];
		}
		String str = "1";
		for (int i = 2; i <= n; i++) {
			if (cache[i] != null) {
				str = cache[i];
				continue;
			}
			String cStr = "";
			char c = str.charAt(str.length() - 1);
			int cnt = 1;
			for (int j = 1; j < str.length(); j++) {
				char cc = str.charAt(str.length() - 1 - j);
				if (cc == c) {
					cnt++;
				} else {
					cStr = String.valueOf(cnt) + c + cStr;
					cnt = 1;
					c = cc;
				}
			}
			cStr = String.valueOf(cnt) + c + cStr;
			str = cStr;
		}
		if (n < cache.length) {
			cache[n] = str;
		}
		return str;
	}

	public static void main(String... strings) {
		Q38 q = new Q38();
		for (int i = 0; i < 30; i++) {
			System.out.println(i + "\t" + q.countAndSay(i));
		}
	}
}
