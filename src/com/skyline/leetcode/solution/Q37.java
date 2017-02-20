package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sudoku Solver
 * <p>
 * https://leetcode.com/problems/sudoku-solver/
 *
 * @author jairus
 */
public class Q37 {

//	private static final int n = 9;
//
//	private void solve(final char[][] board, final int[][] map, final int i, final int j) {
//		final int avb = map[i][j];
//		if (avb <= 0 || (avb & (avb - 1)) != 0) {
//			return;
//		}
//		int val = 0;
//		int t = avb;
//		while (t > 0) {
//			t >>= 1;
//			val++;
//		}
//		board[i][j] = (char) (val + '0');
//		map[i][j] = 0;
//		final int ni = i / 3 * 3;
//		final int nj = j / 3 * 3;
//		for (int k = 0; k < n; k++) {
//			if ((map[i][k] & avb) > 0) {
//				map[i][k] ^= avb;
//				solve(board, map, i, k);
//			}
//			if ((map[k][j] & avb) > 0) {
//				map[k][j] ^= avb;
//				solve(board, map, k, j);
//			}
//			int nni = ni + k / 3;
//			int nnj = nj + k % 3;
//			if ((map[nni][nnj] & avb) > 0) {
//				map[nni][nnj] ^= avb;
//				solve(board, map, nni, nnj);
//			}
//		}
//	}
//
//	public void solveSudoku(char[][] board) {
//		if (board == null || board.length != n || board[0].length != n) {
//			return;
//		}
//		int[][] map = new int[n][n];
//		int[] rowAvbs = new int[n];
//		int[] colAvbs = new int[n];
//		int[] blockAvbs = new int[n];
//		final int avb = (1 << 9) - 1;
//		for (int i = 0; i < n; i++) {
//			rowAvbs[i] = avb;
//			colAvbs[i] = avb;
//			blockAvbs[i] = avb;
//		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				char c = board[i][j];
//				if (c == '.') {
//					continue;
//				}
//				int val = c - '1';
//				int a = (1 << val) ^ avb;
//				rowAvbs[i] &= a;
//				colAvbs[j] &= a;
//				blockAvbs[i / 3 * 3 + j / 3] &= a;
//
//			}
//		}
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				char c = board[i][j];
//				if (c != '.') {
//					continue;
//				}
//				map[i][j] = rowAvbs[i] & colAvbs[j] & blockAvbs[i / 3 * 3 + j / 3];
//			}
//		}
//
//		// 到这边没有问题
////		for (int i = 0; i < n; i++) {
////			for (int j = 0; j < n; j++) {
////				System.out.print(map[i][j] + "\t");
////			}
////			System.out.println();
////		}
////		System.out.println();
////		System.out.println(rowAvbs[0] + "\t" + colAvbs[0] + "," + blockAvbs[0]);
//
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				if (board[i][j] != '.') {
//					continue;
//				}
//				solve(board, map, i, j);
//			}
//		}
////		for (int i = 0; i < n; i++) {
////			for (int j = 0; j < n; j++) {
////				System.out.print(Integer.toBinaryString(map[i][j]));
////			}
////			System.out.println();
////		}
////		System.out.println();
////		System.out.println(rowAvbs[0] + "\t" + colAvbs[0] + "," + blockAvbs[0]);
//
//		boolean finished = true;
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				if (board[i][j] == '.') {
//					finished = false;
//					break;
//				}
//			}
//			if (!finished) {
//				break;
//			}
//		}
//	}

    public void solveSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] columns = new int[9];
        int[][] cells = new int[3][3];
        int avl = (1 << 10) - 2;
        Arrays.fill(rows, avl);
        Arrays.fill(columns, avl);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = avl;
            }
        }
        List<int[]> items = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    int[] item = {i, j};
                    items.add(item);
                    continue;
                }
                int num = c - '0';
                int mask = 1 << num;
                rows[i] ^= mask;
                columns[j] ^= mask;
                cells[i / 3][j / 3] ^= mask;
            }
        }
        this.solveSudoku(board, items, rows, columns, cells, 0);
    }

    protected boolean solveSudoku(char[][] board, List<int[]> items, int[] rows, int[] columns, int[][] cells, int index) {
        if (index == items.size()) {
            return true;
        }
        int[] curItem = items.get(index);
        int i = curItem[0];
        int j = curItem[1];
        int avl = rows[i] & columns[j] & cells[i / 3][j / 3];
        for (int num = 1; num <= 9; num++) {
            int mask = 1 << num;
            if ((avl & mask) > 0) {
                board[i][j] = (char) ('0' + num);
                rows[i] ^= mask;
                columns[j] ^= mask;
                cells[i / 3][j / 3] ^= mask;
                if (this.solveSudoku(board, items, rows, columns, cells, index + 1)) {
                    return true;
                }
                board[i][j] = '.';
                rows[i] ^= mask;
                columns[j] ^= mask;
                cells[i / 3][j / 3] ^= mask;
            }
        }
        return false;
    }

    public static void main(String... strings) {
        Q37 q = new Q37();
        String[] strs = {"..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..", "...8.3.2.",
                "........6", "...2759.."};
        int n = 9;
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = strs[i].charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        q.solveSudoku(board);
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print("\"");
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("\",");
        }
        int avl = (1 << 10) - 2;
        //System.out.println(Integer.toBinaryString(avl));
    }
}
