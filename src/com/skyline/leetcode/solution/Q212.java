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

	public void flood(char[][] board, boolean[][] vMap, int i, int j, String str, Set<String> wordSet,
			Set<String> searchSet, int curLen, int maxLen, Set<String> result) {
		if (curLen >= maxLen || i < 0 || j < 0 || i >= board.length || j >= board[i].length || vMap[i][j]) {
			return;
		}
		str = str + board[i][j];
		if (searchSet.contains(str)) {
		    vMap[i][j] = true;
			if (wordSet.contains(str)) {
				result.add(str);
			}
			this.flood(board, vMap, i - 1, j, str, wordSet, searchSet, curLen + 1, maxLen, result);
			this.flood(board, vMap, i + 1, j, str, wordSet, searchSet, curLen + 1, maxLen, result);
			this.flood(board, vMap, i, j - 1, str, wordSet, searchSet, curLen + 1, maxLen, result);
			this.flood(board, vMap, i, j + 1, str, wordSet, searchSet, curLen + 1, maxLen, result);
			vMap[i][j] = false;
		}
	}

	public List<String> findWords(char[][] board, String[] words) {
		List<String> list = new ArrayList<>();
		if (board == null || words == null || board.length <= 0 || board[0].length <= 0) {
			return list;
		}
		Set<String> wordSet = new HashSet<>();
		Set<String> searchSet = new HashSet<>();
		int maxLen = 0;
		for (String word : words) {
			for (int i = 1; i <= word.length(); i++) {
				searchSet.add(word.substring(0, i));
			}
			wordSet.add(word);
			if (word.length() > maxLen) {
				maxLen = word.length();
			}
		}

		boolean[][] vMap = new boolean[board.length][board[0].length];
		Set<String> result = new HashSet<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				this.flood(board, vMap, i, j, "", wordSet, searchSet, 0, maxLen, result);
			}
		}
		list.addAll(result);
		return list;
	}
}
