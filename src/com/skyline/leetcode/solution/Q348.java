package com.skyline.leetcode.solution;

/**
 * Design Tic-Tac-Toe
 * https://leetcode.com/problems/design-tic-tac-toe/?tab=Description
 * Created by chenliang on 2017/3/2.
 */
public class Q348 {

    public class TicTacToe {

        int[] rowCnts;

        int[] columnCnts;

        int diag1;

        int diag2;

        int n;

        /**
         * Initialize your data structure here.
         */
        public TicTacToe(int n) {
            rowCnts = new int[n];
            columnCnts = new int[n];
            diag1 = 0;
            diag2 = 0;
            this.n = n;
        }

        /**
         * Player {player} makes a move at ({row}, {col}).
         *
         * @param row    The row of the board.
         * @param col    The column of the board.
         * @param player The player, can be either 1 or 2.
         * @return The current winning condition, can be either:
         * 0: No one wins.
         * 1: Player 1 wins.
         * 2: Player 2 wins.
         */
        public int move(int row, int col, int player) {
            int delta = player % 2 == 0 ? 1 : -1;
            rowCnts[row] += delta;
            if (Math.abs(rowCnts[row]) == n) {
                return player;
            }
            columnCnts[col] += delta;
            if (Math.abs(columnCnts[col]) == n) {
                return player;
            }
            if (row == col) {
                diag1 += delta;
                if (Math.abs(diag1) == n) {
                    return player;
                }
            }
            if (row == n - 1 - col) {
                diag2 += delta;
                if (Math.abs(diag2) == n) {
                    return player;
                }
            }
            return 0;
        }
    }

}
