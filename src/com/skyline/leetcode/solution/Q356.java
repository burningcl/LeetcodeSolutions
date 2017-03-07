package com.skyline.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Line Reflection
 * https://leetcode.com/problems/line-reflection/?tab=Description
 * Created by chenliang on 2017/3/1.
 */
public class Q356 {

    public boolean isReflected(int[][] points) {
        if (points == null || points.length <= 0) {
            return true;
        }
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        for (int i = 0; i < points.length; i++) {
            int[] p = points[i];
            minX = Integer.min(minX, p[0]);
            maxX = Integer.max(maxX, p[0]);
        }
        double midX = ((double) (minX + maxX)) / 2;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                if (o1[0] < midX) {
                    return o2[1] - o1[1];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        int left = 0;
        int right = points.length - 1;
        while (left <= right) {
            int[] pLeft = points[left];
            if (left > 0) {
                if (pLeft[0] == points[left - 1][0] && pLeft[1] == points[left - 1][1]) {
                    left++;
                    continue;
                }
            }
            left++;
            int[] pRight = points[right];
            if (right < points.length - 1) {
                if (pRight[0] == points[right + 1][0] && pRight[1] == points[right + 1][1]) {
                    right--;
                    continue;
                }
            }
            right--;
            if (((double) (pLeft[0] + pRight[0])) / 2 != midX) {
                return false;
            }
            if (pLeft[1] != pRight[1] && pLeft[0] != pRight[0] && pLeft[0] != midX) {
                return false;
            }
        }
        return true;
    }

}
