package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Word Search II
 * 
 * 
 * https://leetcode.com/problems/word-search-ii/
 * 
 * @author jairus
 *
 */
public class Q212 {
	private boolean exist(char[][] board, String word, int index, int i, int j, boolean[][] tMap) {
		if (index >= word.length()) {
			return true;
		} else if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || tMap[i][j]) {
			return false;
		}

		if (board[i][j] == word.charAt(index)) {
			// System.out.println(word.charAt(index) + ", " + index + ", (" + i
			// + ", " + j + ")");
			tMap[i][j] = true;
			if (this.exist(board, word, index + 1, i - 1, j, tMap) || this.exist(board, word, index + 1, i + 1, j, tMap)
					|| this.exist(board, word, index + 1, i, j - 1, tMap)
					|| this.exist(board, word, index + 1, i, j + 1, tMap)) {
				return true;
			}
			tMap[i][j] = false;
		}
		return false;
	}

	private boolean exist(char[][] board, String word) {
		if (word == null || word.length() <= 0) {
			return true;
		}
		int n = board.length;
		int m = board[0].length;
		boolean[][] tMap = new boolean[n][m];
		// boolean[][][] map = new boolean[n][m][word.length()];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (this.exist(board, word, 0, i, j, tMap)) {
					return true;
				}
			}
		}
		return false;
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> list = new ArrayList<>();
		if (board == null || words == null) {
			return list;
		}
		Set<String> set=new HashSet<>();
		for (String word : words) {
			set.add(word);
		}
		for (String word : set) {
			if (this.exist(board, word))
				list.add(word);
		}
		return list;
	}
}
