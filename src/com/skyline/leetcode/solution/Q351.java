package com.skyline.leetcode.solution;

import java.util.Set;

/**
 * Android Unlock Patterns Add to List
 * https://leetcode.com/problems/android-unlock-patterns/?tab=Description
 * Created by chenliang on 2017/2/28.
 */
public class Q351 {

    protected boolean canLink(boolean[] varray, int from, int to) {
        if (varray[to]) {
            return false;
        }
        if (!varray[5] && (from == 1 && to == 9 || from == 9 && to == 1 || from == 3 && to == 7 || from == 7 && to == 3)) {
            return false;
        }
        if (!varray[5] && (from == 2 && to == 8 || from == 8 && to == 2 || from == 4 && to == 6 || from == 6 && to == 4)) {
            return false;
        }
        if (!varray[2] && (from == 1 && to == 3 || from == 3 && to == 1)) {
            return false;
        }
        if (!varray[4] && (from == 1 && to == 7 || from == 7 && to == 1)) {
            return false;
        }
        if (!varray[6] && (from == 3 && to == 9 || from == 9 && to == 3)) {
            return false;
        }
        if (!varray[8] && (from == 7 && to == 9 || from == 9 && to == 7)) {
            return false;
        }
        return true;
    }

    public int numberOfPatterns(int m, int n) {
        if (n < m || m <= 0) {
            return 0;
        }
        boolean[] varray = new boolean[10];
        return this.numberOfPatterns(m, n, varray, 1) * 4
                + this.numberOfPatterns(m, n, varray, 2) * 4
                + this.numberOfPatterns(m, n, varray, 5);
    }

    public int numberOfPatterns(int m, int n, boolean[] varray, int start) {
        return this.numberOfPatterns(m, n, varray, 0, start, 0);
    }

    public int numberOfPatterns(int m, int n, boolean[] varray, int from, int to, int len) {
        if (!canLink(varray, from, to) || len >= n) {
            return 0;
        }
        len++;
        varray[to] = true;
        int total = 0;
        for (int i = 1; i <= 9; i++) {
            total += numberOfPatterns(m, n, varray, to, i, len);
        }
        if (len >= m && len <= n) {
            total++;
        }
        varray[to] = false;
        return total;
    }

}
