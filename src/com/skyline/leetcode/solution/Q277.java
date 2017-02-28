package com.skyline.leetcode.solution;

/**
 * Find the Celebrity
 * https://leetcode.com/problems/find-the-celebrity/?tab=Description
 * Created by chenliang on 2017/2/27.
 */
public class Q277 {

    boolean knows(int a, int b) {
        if (a == 0 && b == 1) {
            return true;
        }
        return false;
    }

    //0 knows 1; 1 does not know 0.
    public int findCelebrity(int n) {
        int a = 0;
        for (int b = 1; b < n; b++) {
            if (knows(a, b) && isCelebrity(b, n)) {
                return b;
            }
        }
        return isCelebrity(a, n) ? a : -1;

    }

    public boolean isCelebrity(int b, int n) {
        for (int c = 0; c < n; c++) {
            if (c == b) {
                continue;
            }
            if (knows(b, c) || !knows(c, b)) {
                return false;
            }
        }
        return true;
    }



}
