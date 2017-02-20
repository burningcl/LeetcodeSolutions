package com.skyline.leetcode.solution.contest20;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by chenliang on 2017/2/19.
 */
public class Q526 {

    public int countArrangement(int N) {
        if (N <= 0) {
            return 0;
        }
        int key = (1 << (N + 1)) - 2;
        int[] cache = new int[1 << (N + 1)];
        Arrays.fill(cache, -1);
        cache[0] = 1;
        return this.countArrangement(key, N, 1, cache);
    }

    public int countArrangement(int key, int N, int index, int[] cache) {
        if (cache[key] >= 0) {
            return cache[key];
        }
        int total = 0;
        for (int i = 1; i <= N; i++) {
            int mask = 1 << i;
            if ((mask & key) == 0) {
                continue;
            }
            if (index % i == 0 || i % index == 0) {
                key ^= mask;
                total += countArrangement(key, N, index + 1, cache);
                key ^= mask;
            }
        }
        return cache[key] = total;
    }

    public static void main(String... strings) {
        Q526 q = new Q526();
        System.out.println(q.countArrangement(15));
        System.out.println(q.countArrangement(2));
    }

}
