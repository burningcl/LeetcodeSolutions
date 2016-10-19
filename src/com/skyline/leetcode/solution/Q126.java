package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Word Ladder II
 * 
 * https://leetcode.com/problems/word-ladder-ii/
 * 
 * @author jairus
 * 
 */
public class Q126 {

	private boolean canChange(String s1, String s2) {
		if (s1.equals(s2)) {
			return false;
		}
		boolean can = false;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				if (can)
					return false;
				else
					can = true;
			}
		}
		return can;
	}

	private void findLadders(List<List<String>> list, List<Set<String>> sets, List<String> sub, String parent, int level) {
		Set<String> set = sets.get(level);
		for (String str : set) {
			if (canChange(str, parent)) {
				sub.add(str);
				if(level==sets.size()-1){
					List<String> sub1=new ArrayList<String>();
					sub1.addAll(sub);
					list.add(sub1);
				}else{
					this.findLadders(list, sets, sub, str, level+1);
				}
				sub.remove(level+1);
			}
		}
	}

	public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		List<List<String>> list = new ArrayList<List<String>>();

		if (beginWord.equals(endWord)) {
			List<String> sub = new ArrayList<String>();
			sub.add(endWord);
			list.add(sub);
			return list;
		}

		List<Set<String>> sets = new ArrayList<Set<String>>();
		Set<String> ss = new HashSet<String>();
		ss.add(endWord);
		sets.add(ss);
		wordList.add(beginWord);
		while (!ss.contains(beginWord)) {
			Set<String> cs = new HashSet<String>();
			for (String w2 : ss) {
				StringBuilder sb = new StringBuilder(w2);
				for (int j = 0; j < w2.length(); j++) {
					char cur = w2.charAt(j);
					for (char c = 'a'; c <= 'z'; c++) {
						sb.setCharAt(j, c);
						String s = sb.toString();
						if (wordList.contains(s)) {
							cs.add(s);
						}
					}
					sb.setCharAt(j, cur);
				}
			}

			if (cs.size() <= 0) {
				break;
			}
			wordList.removeAll(cs);
			ss = cs;
			sets.add(0, cs);
		}
		if (!ss.contains(beginWord)) {
			return list;
		}

		sets.remove(0);

		List<String> sub = new ArrayList<String>();
		sub.add(beginWord);
		this.findLadders(list, sets, sub, beginWord, 0);
		return list;
	}
	
	private static Set<String> toSet(String[] array) {
		Set<String> set = new HashSet<String>();
		for (String s : array) {
			set.add(s);
		}
		return set;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Q126 q = new Q126();

		String beginWord = "hit";
		String endWord = "cog";
		String[] wordList = { "hot", "dot", "dog", "lot", "log" };
		System.out.println(q.findLadders(beginWord, endWord, toSet(wordList)));
	}

}
