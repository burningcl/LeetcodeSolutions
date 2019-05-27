package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huasong.cl
 */
public class Q873 {

    public int lenLongestFibSubseq(int[] A) {
        int max = 0;
        int n = A.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(A[i], i);
        }
        int[][] cache = new int[n][n];
        for (int i = 0; i < n; i++) {
            int pre = A[i];
            for (int j = i + 1; j < n; j++) {
                int target = A[j] - pre;
                if (indexMap.containsKey(target) && indexMap.get(target) != i) {
                    cache[i][j] = cache[indexMap.get(target)][i] + 1;
                    max = Integer.max(max, cache[i][j]);
                }

            }
        }
        return max > 0 ? max + 2 : 0;
    }


}
