package com.skyline.leetcode.solution;

/**
 * Add and Search Word - Data structure design
 * 
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/
 * 
 * @author jairus
 *
 */
public class Q211 {

	public static class WordDictionary {

		class Node {
			boolean isWord = false;
			Node[] children = new Node[26];
		}

		Node root = new Node();

		protected void addWord(Node root, String word, int index) {
			char c = word.charAt(index);
			int cindex = c - 'a';
			Node child = root.children[cindex];
			if (child == null) {
				child = root.children[cindex] = new Node();
			}
			if (index >= word.length() - 1) {
				child.isWord = true;
			} else {
				this.addWord(child, word, index + 1);
			}
		}

		// Adds a word into the data structure.
		public void addWord(String word) {
			if (word == null || word.length() <= 0) {
				return;
			}
			this.addWord(root, word, 0);
		}

		protected boolean search(Node root, String word, int index) {
			char c = word.charAt(index);

			if (c == '.') {
				for (int i = 0; i < 26; i++) {
					if (this.searchimpl(root.children[i], word, index)) {
						return true;
					}
				}
				return false;
			} else {
				int cindex = c - 'a';
				Node child = root.children[cindex];
				return this.searchimpl(child, word, index);
			}
		}

		private boolean searchimpl(Node child, String word, int index) {
			if (child == null) {
				return false;
			}
			if (index >= word.length() - 1) {
				return child.isWord;
			} else {
				return this.search(child, word, index + 1);
			}
		}

		// Returns if the word is in the data structure. A word could
		// contain the dot character '.' to represent any one letter.
		public boolean search(String word) {
			if (word == null || word.length() <= 0) {
				return false;
			}
			return this.search(root, word, 0);
		}
	}

	public static void main(String[] args) {
		WordDictionary w = new WordDictionary();
		w.addWord("bad");
		w.addWord("dad");
		w.addWord("mad");
		System.out.println(w.search("pad"));
		System.out.println(w.search("bad"));
		System.out.println(w.search(".ad"));
		System.out.println(w.search("b.."));
		System.out.println(w.search("b.t"));
	}

}
