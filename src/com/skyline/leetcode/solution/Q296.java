package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Best Meeting Point
 * https://leetcode.com/problems/best-meeting-point/?tab=Description
 * Created by chenliang on 2017/2/27.
 */
public class Q296 {

    public int minTotalDistance(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        List<Integer> iList = new ArrayList<>();
        List<Integer> jList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    iList.add(i);
                    jList.add(j);
                }
            }
        }

        return minTotalDistance(iList) + minTotalDistance(jList);

    }

    public int minTotalDistance(List<Integer> list) {
        Collections.sort(list);
        int total = 0;
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            total += list.get(right--) - list.get(left++);
        }
        return total;
    }

}
