package com.skyline.leetcode.solution;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Trapping Rain Water II
 * https://leetcode.com/problems/trapping-rain-water-ii/
 * Created by chenliang on 2017/2/14.
 */
public class Q407 {

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null) {
            return 0;
        }
        int n = heightMap.length;
        if (n <= 2) {
            return 0;
        }
        int m = heightMap[0].length;
        if (m <= 2) {
            return 0;
        }
        boolean[][] vMap = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            vMap[i][0] = true;
            vMap[i][m - 1] = true;
        }
        for (int i = 0; i < m; i++) {
            vMap[0][i] = true;
            vMap[n - 1][i] = true;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 1; i < n - 1; i++) {
            queue.add(this.getItem(heightMap, vMap, i, 1));
            if (m > 3) {
                queue.add(this.getItem(heightMap, vMap, i, m - 2));
            }
        }
        for (int i = 2; i < m - 2; i++) {
            queue.add(this.getItem(heightMap, vMap, 1, i));
            if (n > 3) {
                queue.add(this.getItem(heightMap, vMap, n - 2, i));
            }
        }
        int sum = 0;
        while (!queue.isEmpty()) {
            int[] item = queue.poll();
            int i = item[1];
            int j = item[2];
            if (vMap[i][j]) {
                continue;
            }
            if (heightMap[i][j] < item[0]) {
                sum += item[0] - heightMap[i][j];
                heightMap[i][j] = item[0];
            }
            vMap[i][j] = true;
            if (!vMap[i - 1][j]) {
                queue.add(this.getItem(heightMap, vMap, i - 1, j));
            }
            if (!vMap[i + 1][j]) {
                queue.add(this.getItem(heightMap, vMap, i + 1, j));
            }
            if (!vMap[i][j - 1]) {
                queue.add(this.getItem(heightMap, vMap, i, j - 1));
            }
            if (!vMap[i][j + 1]) {
                queue.add(this.getItem(heightMap, vMap, i, j + 1));
            }
        }
        return sum;
    }

    public int[] getItem(int[][] heightMap, boolean[][] vMap, int i, int j) {
        int height = Integer.MAX_VALUE;
        if (vMap[i - 1][j] && heightMap[i - 1][j] < height) {
            height = heightMap[i - 1][j];
        }
        if (vMap[i + 1][j] && heightMap[i + 1][j] < height) {
            height = heightMap[i + 1][j];
        }
        if (vMap[i][j - 1] && heightMap[i][j - 1] < height) {
            height = heightMap[i][j - 1];
        }
        if (vMap[i][j + 1] && heightMap[i][j + 1] < height) {
            height = heightMap[i][j + 1];
        }
        int[] ret = {height, i, j};
        return ret;
    }

}
