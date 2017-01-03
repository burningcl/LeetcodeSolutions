package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

public class Q472 {

	public class Node {
		boolean isWord = false;
		Node[] nodes = new Node[26];
	}

	public Node build(String[] words) {
		Node root = new Node();
		root.isWord = true;
		for (String word : words) {
			Node cur = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (cur.nodes[c - 'a'] == null) {
					cur.nodes[c - 'a'] = new Node();
				}
				cur = cur.nodes[c - 'a'];
			}
			cur.isWord = true;
		}
		return root;
	}

	public boolean test(String word, int index, Node cur, Node root, int cnt) {
		if (index >= word.length()) {
			return cur.isWord && cnt > 1;
		}
		for (; index < word.length(); index++) {
			char c = word.charAt(index);
			cur = cur.nodes[c - 'a'];
			if (cur == null) {
				return false;
			}
			// System.out.println(c+", "+cur+", "+cur.isWord);
			if (cur.isWord) {
				if (this.test(word, index + 1, root, root, cnt + 1)) {
					return true;
				}
			}
		}
		return false;

	}

	public List<String> findAllConcatenatedWordsInADict(String[] words) {

		List<String> list = new ArrayList<>();
		if (words == null || words.length <= 1) {
			return list;
		}
		Node root = this.build(words);
		// for(Node nodex:root.nodes )
		// System.out.println(nodex);
		for (String word : words) {
			if (this.test(word, 0, root, root, 0)) {
				list.add(word);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Q472 q = new Q472();
		String[] words = { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
		System.out.println(q.findAllConcatenatedWordsInADict(words));
	}

}
