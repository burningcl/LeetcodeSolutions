package com.skyline.leetcode.solution.contest21;

/**
 * Minesweeper
 * https://leetcode.com/contest/leetcode-weekly-contest-21/problems/minesweeper/
 * Created by chenliang on 2017/2/26.
 */
public class Q529 {

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length <= 0) {
            return board;
        }
        int n = board.length;
        int m = board[0].length;
        int i = click[0];
        int j = click[1];
        if (board[i][j] == 'E') {
            test(board, i, j, n, m);
        } else if (board[i][j] == 'M') {
            test(board, i - 1, j - 1, n, m);
            test(board, i - 1, j, n, m);
            test(board, i - 1, j + 1, n, m);
            test(board, i, j - 1, n, m);
            test(board, i, j + 1, n, m);
            test(board, i + 1, j - 1, n, m);
            test(board, i + 1, j, n, m);
            test(board, i + 1, j + 1, n, m);
            board[i][j] = 'X';
        }
        return board;
    }

    public void test(char[][] board, int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m || board[i][j] != 'E') {
            return;
        }
        int cnt = this.getCnt(board, i, j, n, m);
        if (cnt > 0) {
            board[i][j] = (char) (cnt + '0');
        } else {
            board[i][j] = 'B';
            test(board, i - 1, j - 1, n, m);
            test(board, i - 1, j, n, m);
            test(board, i - 1, j + 1, n, m);
            test(board, i, j - 1, n, m);
            test(board, i, j + 1, n, m);
            test(board, i + 1, j - 1, n, m);
            test(board, i + 1, j, n, m);
            test(board, i + 1, j + 1, n, m);
        }
    }

    public int getCnt(char[][] board, int i, int j, int n, int m) {
        int cnt = 0;
        if (isMine(board, n, m, i - 1, j - 1)) {
            cnt++;
        }
        if (isMine(board, n, m, i - 1, j)) {
            cnt++;
        }
        if (isMine(board, n, m, i - 1, j + 1)) {
            cnt++;
        }
        if (isMine(board, n, m, i, j - 1)) {
            cnt++;
        }
        if (isMine(board, n, m, i, j + 1)) {
            cnt++;
        }
        if (isMine(board, n, m, i + 1, j - 1)) {
            cnt++;
        }
        if (isMine(board, n, m, i + 1, j)) {
            cnt++;
        }
        if (isMine(board, n, m, i + 1, j + 1)) {
            cnt++;
        }
        return cnt;
    }

    public boolean isMine(char[][] board, int n, int m, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        return board[i][j] == 'M' || board[i][j] == 'X';
    }

}
