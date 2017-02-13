package com.skyline.leetcode.solution;

import java.util.*;

/**
 * Zuma Game
 * https://leetcode.com/problems/zuma-game/
 * Created by chenliang on 2017/1/18.
 */
public class Q488 {

    public int findMinStep(String board, String hand) {
        if (board == null || board.length() <= 0 || hand == null || hand.length() <= 0) {
            return -1;
        }
        int[] map = new int[26];
        for (int i = 0; i < hand.length(); i++) {
            map[hand.charAt(i) - 'A']++;
        }
        return findMinStep(board, map, hand.length());
    }

    public int findMinStep(String board, int[] map, int avaliable) {
        board = this.clear(board);
        if (board.length() <= 0) {
            return 0;
        } else if (avaliable <= 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        Character minc = null;
        for (int i = 0; i < board.length(); i++) {
            char c = board.charAt(i);
            if (map[c - 'A'] > 0 && (i + 1 == board.length() || board.charAt(i + 1) != c)) {
                String boardTmep = board.substring(0, i + 1) + c + board.substring(i + 1);
                map[c - 'A']--;
                int steps = this.findMinStep(boardTmep, map, avaliable - 1);
                if (steps >= 0 && steps < min) {
                    min = steps;
                    minc = c;
                }
                map[c - 'A']++;
            }
        }
        if (minc == null) {
            return -1;
        }
        return ++min;
    }

    String patternStr = "(.)\\1{2,}";

    java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(patternStr);

    public String clear(String board) {
        while (pattern.matcher(board).find()) {
            board = board.replaceAll(patternStr, "");
        }
        return board;
    }

    public static void main(String... args) {
        Q488 q = new Q488();
        System.out.println(q.findMinStep("WRRBBW", "RB"));
        System.out.println(q.findMinStep("WWRRBBWW", "WRBRW"));
        System.out.println(q.findMinStep("G", "GGGGG"));
        System.out.println(q.findMinStep("RBYYBBRRB", "YRBGB"));
        System.out.println(q.findMinStep("RRWWRRW", "WR"));
        System.out.println(q.findMinStep("BRYRBB","RYGYR"));
    }
}
