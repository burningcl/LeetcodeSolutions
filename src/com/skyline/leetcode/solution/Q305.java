package com.skyline.leetcode.solution;

import java.util.*;

/**
 * Number of Islands II
 * https://leetcode.com/problems/number-of-islands-ii/?tab=Description
 * Created by chenliang on 2017/2/28.
 */
public class Q305 {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] grid = new int[m][n];
        int[] array = new int[positions.length + 1];
        int curIndex = 1;
        List<Integer> list = new ArrayList<>();
        int num = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < positions.length; i++) {
            grid[positions[i][0]][positions[i][1]] = curIndex;
            array[curIndex] = curIndex;
            set.clear();
            set.add(curIndex);
            this.f(grid, array, m, n, positions[i][0], positions[i][1], curIndex, set);
            num += 2 - set.size();
            curIndex++;
            list.add(num);
        }
        return list;
    }

    int[][] diff = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void f(int[][] grid, int[] array, int m, int n, int i, int j, int curIndex, Set<Integer> set) {
        for (int k = 0; k < 4; k++) {
            int x = i + diff[k][0];
            int y = j + diff[k][1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 0 && grid[x][y] != curIndex) {
                int index = findIndex(array, grid[x][y]);
                set.add(index);
                array[index] = curIndex;
            }
        }
    }

    public int findIndex(int[] array, int index) {
        while (array[index] != index) {
            index = array[index];
        }
        return index;
    }

}
