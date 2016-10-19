package com.skyline.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Reverse Vowels of a String
 * 
 * https://leetcode.com/problems/reverse-vowels-of-a-string/
 * 
 * @author jairus
 *
 */
public class Q345 {
	Set<Character> set;

	private boolean isVowel(char c) {
		if (set == null) {
			set = new HashSet<>();
			set.add('a');
			set.add('e');
			set.add('i');
			set.add('o');
			set.add('u');
			set.add('A');
			set.add('E');
			set.add('I');
			set.add('O');
			set.add('U');
		}
		return set.contains(c);
	}

	public String reverseVowels(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		char[] cs = s.toCharArray();
		int i = 0;
		int j = cs.length - 1;

		while (i < j) {
			if (!isVowel(cs[i])) {
				i++;
			} else if (!isVowel(cs[j])) {
				j--;
			} else {
				char c = cs[i];
				cs[i] = cs[j];
				cs[j] = c;
				i++;
				j--;
			}
		}
		return String.valueOf(cs);
	}
}
