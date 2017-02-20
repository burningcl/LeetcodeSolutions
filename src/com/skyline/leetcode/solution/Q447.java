package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Number of Boomerangs
 * <p>
 * https://leetcode.com/problems/number-of-boomerangs/
 *
 * @author jairus
 */
public class Q447 {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length <= 1) {
            return 0;
        }
        int total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int[] p1 = points[i];
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int[] p2 = points[j];
                int n = 0;
                for (int k = 0; k < p1.length; k++) {
                    n += (p1[k] - p2[k]) * (p1[k] - p2[k]);
                }
                int cnt = map.getOrDefault(n, 0);
                map.put(n, cnt + 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int cnt = entry.getValue();
                total += (cnt - 1) * cnt;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
