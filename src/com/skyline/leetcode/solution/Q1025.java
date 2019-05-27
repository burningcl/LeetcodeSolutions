package com.skyline.leetcode.solution;

/**
 * @author huasong.cl
 */
public class Q1025 {

    Boolean[] cache = null;

    private void init() {
        if (cache == null) {
            cache = new Boolean[1001];
            cache[1] = false;
            cache[2] = true;
            cache[3] = false;
        }
    }

    public boolean divisorGame(int N) {
        init();
        if (cache[N] != null) {
            return cache[N];
        }
        boolean ret = false;
        for (int i = 1; i < N; i++) {
            if (N % i == 0 && !divisorGame(N - i)) {
                ret = true;
                break;
            }
        }
        return cache[N] = ret;
    }


}
