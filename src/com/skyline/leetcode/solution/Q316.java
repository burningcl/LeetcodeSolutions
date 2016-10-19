package com.skyline.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove Duplicate Letters
 * 
 * https://leetcode.com/problems/remove-duplicate-letters/
 * 
 * @author jairus
 *
 */
public class Q316 {

	public String removeDuplicateLetters(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		int[] cnts = new int[26];
		int cnt = 0;
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 'a';
			if (cnts[index] == 0) {
				cnt++;
			}
			cnts[index]++;
		}
		StringBuilder builder = new StringBuilder();
		Set<Character> set = new HashSet<>();
		int start = 0;
		for (int i = 0; i < s.length() && cnt > 0; i++) {
			char c = s.charAt(i);
			int index = c - 'a';

			if (--cnts[index] == 0 && !set.contains(c)) {
				cnt--;
				int minIndex = start;
				while (minIndex <= i) {
					char minC = c;
					boolean foundMin = false;
					int oMinIndex = minIndex;
					for (int j = i; j >= oMinIndex; j--) {
						char cc = s.charAt(j);
						if (!set.contains(cc)) {
							if (cc <= minC) {
								minC = cc;
								minIndex = j;
								foundMin = true;
							}
						}
					}
					if (foundMin) {
						set.add(minC);
						builder.append(minC);
					} else {
						break;
					}
				}
				start = minIndex + 1;
			}
		}
		return builder.toString();
	}

	public String removeDuplicateLetters2(String s) {
		int[] count = new int[26];
		int pos = 0;
		for (int i = 0; i < s.length(); i++)
			count[s.charAt(i) - 'a']++;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < s.charAt(pos))
				pos = i;
			if (--count[s.charAt(i) - 'a'] == 0)
				break;
		}
		return s.length() == 0 ? ""
				: s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
	}

	public static void main(String... strings) {
		Q316 q = new Q316();
		System.out.println(q.removeDuplicateLetters(""));
		System.out.println(q.removeDuplicateLetters("a"));
		System.out.println(q.removeDuplicateLetters("aa"));
		System.out.println(q.removeDuplicateLetters("ab"));
		System.out.println(q.removeDuplicateLetters("aba"));
		System.out.println(q.removeDuplicateLetters("abac"));
		System.out.println(q.removeDuplicateLetters("bccacbc"));
		System.out.println(q.removeDuplicateLetters("abacb"));
		System.out.println(q.removeDuplicateLetters("bxshkpdwcsjdbikywvioxrypfzfbppydfilfxxtouzzjxaymjpmdoevv")
				.equals("bhcsdikworfltuzjxaympev"));
		System.out.println(
				q.removeDuplicateLetters("eywdgenmcnzhztolafcfnirfpuxmfcenlppegrcalgxjlajxmphwidqqtrqnmmbssotoywfrtylm")
						.equals(q.removeDuplicateLetters2(
								"eywdgenmcnzhztolafcfnirfpuxmfcenlppegrcalgxjlajxmphwidqqtrqnmmbssotoywfrtylm")));
		System.out
				.println(q.removeDuplicateLetters("yioccqiorhtoslwlvfgzycahonecugtatbyphpuunwvaalcpndabyldkdtzfjlgwqk")
						.equals(q.removeDuplicateLetters2(
								"yioccqiorhtoslwlvfgzycahonecugtatbyphpuunwvaalcpndabyldkdtzfjlgwqk")));
	}

}
