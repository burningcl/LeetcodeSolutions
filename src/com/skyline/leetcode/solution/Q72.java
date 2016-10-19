package com.skyline.leetcode.solution;

/**
 * Edit Distance
 * 
 * https://leetcode.com/problems/edit-distance/
 * 
 * @author jairus
 *
 */
public class Q72 {

	private boolean empty(String str) {
		return str == null || str.length() <= 0;
	}

	private int minDistance(String word1, String word2, int index1, int index2) {
		int left1 = word1.length() - index1;
		int left2 = word2.length() - index2;
		if (left1 <= 0) {
			return left2;
		} else if (left2 <= 0) {
			return left1;
		}

		int d = map[index1][index2];
		if (d >= 0) {
			return d;
		}

		char c1 = word1.charAt(index1);
		char c2 = word2.charAt(index2);

		if (c1 == c2) {
			d = minDistance(word1, word2, index1 + 1, index2 + 1);
		} else {
			int d1 = minDistance(word1, word2, index1 + 1, index2 + 1) + 1;
			int d2 = minDistance(word1, word2, index1 + 1, index2) + 1;
			int d3 = minDistance(word1, word2, index1, index2 + 1) + 1;
			d = d1 < d2 ? d1 : d2;
			d = d < d3 ? d : d3;
		}
		map[index1][index2] = d;
		return d;
	}

	int[][] map = null;

	public int minDistance(String word1, String word2) {
		if (empty(word1) && !empty(word2)) {
			return word2.length();
		} else if (!empty(word1) && empty(word2)) {
			return word1.length();
		} else if (empty(word1) && empty(word2)) {
			return 0;
		}
		map = new int[word1.length()][word2.length()];
		for (int i = 0; i < word1.length(); i++) {
			for (int j = 0; j < word2.length(); j++) {
				map[i][j] = -1;
			}
		}
		return minDistance(word1, word2, 0, 0);
	}

	public static void main(String[] args) {
		Q72 q = new Q72();
		System.out.println(q.minDistance("abc", "bca"));
		System.out.println(q.minDistance("a", "bca"));
		System.out.println(q.minDistance("abc", "def"));
		System.out.println(q.minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine"));
	}

}
