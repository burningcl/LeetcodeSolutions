package com.skyline.leetcode.solution;

/**
 * Diagonal Traverse
 * https://leetcode.com/problems/diagonal-traverse/
 * Created by chenliang on 2017/2/10.
 */
public class Q498 {

//    public int[] findDiagonalOrder(int[][] matrix) {
//        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
//            return new int[0];
//        }
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int[] ret = new int[n * m];
//        int index = 0;
//        int time = 0;
//        int ii = 0;
//        int jj = 0;
//        int min = Integer.min(n, m);
//        int max = Integer.max(n, m);
//        for (int i = 0; i < min; i++) {
//            for (int j = 0; j < i; j++) {
//                ret[index++] = matrix[ii][jj];
//                System.out.println(matrix[ii][jj]);
//                if (i % 2 == 0) {
//                    ii++;
//                    jj--;
//                } else {
//                    ii--;
//                    jj++;
//                }
//            }
//            ret[index++] = matrix[ii][jj];
//            if (time++ % 2 == 0) {
//                ii++;
//            } else {
//                jj++;
//            }
//        }
//        for (int i = min; i < max; i++) {
//            for (int j = 0; j < min; j++) {
//                ret[index++] = matrix[ii][jj];
//                System.out.println(matrix[ii][jj]);
//                if (i % 2 == 0) {
//                    ii++;
//                    jj--;
//                } else {
//                    ii--;
//                    jj++;
//                }
//            }
//            ret[index++] = matrix[ii][jj];
//            if (min == n) {
//                ii++;
//            } else {
//                jj++;
//            }
//        }
//        for (int i = min - 1; i >= 0; i--) {
//            for (int j = 0; j < i; j++) {
//                ret[index++] = matrix[ii][jj];
//                System.out.println(matrix[ii][jj]);
//                if (i % 2 == 0) {
//                    ii++;
//                    jj--;
//                } else {
//                    ii--;
//                    jj++;
//                }
//            }
//            ret[index++] = matrix[ii][jj];
//            if (time++ % 2 == 0) {
//                ii--;
//            } else {
//                jj--;
//            }
//        }
//        return ret;
//    }

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] ret = new int[n * m];
        int ii = 0;
        int jj = 0;
        boolean up = true;
        for (int i = 0; i < ret.length; i++) {
            ret[i] = matrix[ii][jj];
            if (up) {
                if (jj == n - 1) {
                    up = false;
                    ii++;
                } else if (ii == 0) {
                    up = false;
                    jj++;
                } else {
                    ii--;
                    jj++;
                }
            } else {
                if (ii == m - 1) {
                    up = true;
                    jj++;
                } else if (jj == 0) {
                    up = true;
                    ii++;
                } else {
                    ii++;
                    jj--;
                }
            }
        }
        return ret;
    }


}
