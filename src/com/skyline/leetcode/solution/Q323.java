package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * Number of Connected Components in an Undirected Graph
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/?tab=Description
 * Created by chenliang on 2017/3/1.
 */
public class Q323 {

    public int countComponents(int n, int[][] edges) {
        boolean[][] matrix = new boolean[n][n];
        boolean[] vArray = new boolean[n];
        Arrays.fill(vArray, true);
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            matrix[edge[0]][edge[1]] = true;
            matrix[edge[1]][edge[0]] = true;
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (vArray[i] == true) {
                cnt++;
                dfs(matrix, vArray, n, i);
            }
        }
        return cnt;
    }

    public void dfs(boolean[][] matrix, boolean[] vArray, int n, int index) {
        vArray[index] = false;
        for (int i = 0; i < n; i++) {
            if (vArray[i] && matrix[index][i]) {
                dfs(matrix, vArray, n, i);
            }
        }
    }

}
