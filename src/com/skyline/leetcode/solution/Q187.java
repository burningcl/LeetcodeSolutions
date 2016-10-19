package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Repeated DNA Sequences
 * 
 * @author jairus
 *
 */
public class Q187 {

	public List<String> findRepeatedDnaSequences(String s) {
		List<String> list = new ArrayList<>();
		if (s == null || s.length() <= 10) {
			return list;
		}
		// A, C, G, and T,
		long[] char2Int = new long[26];
		char[] int2Char = new char[5];
		char2Int['A' - 'A'] = 1;
		char2Int['C' - 'A'] = 2;
		char2Int['G' - 'A'] = 3;
		char2Int['T' - 'A'] = 4;
		int2Char[1] = 'A';
		int2Char[2] = 'C';
		int2Char[3] = 'G';
		int2Char[4] = 'T';
		Set<Long> set1 = new HashSet<>();
		Set<Long> set2 = new HashSet<>();
		long val = 0;
		for (int i = 0; i < 10; i++) {
			char c = s.charAt(i);
			long vc = char2Int[c - 'A'];
			val = val * 10 + vc;
		}
		long val10 = (long) Math.pow(10, 9);
		set1.add(val);
		for (int i = 10; i < s.length(); i++) {
			val = (val % val10) * 10 + char2Int[s.charAt(i) - 'A'];
			if (!set1.add(val)) {
				set2.add(val);
			}
		}
		for (Long v : set2) {
			String str = "";
			for (int i = 0; i < 10; i++) {
				str = int2Char[(int)(v % 10)] + str;
				v = v / 10;
			}
			list.add(str);
		}
		return list;
	}

	public static void main(String[] args) {
		Q187 q = new Q187();
		System.out.println(q.findRepeatedDnaSequences("AAAAACCCCCCAAAAACCCCCCAAAAAGGGTTT"));
	}

}
