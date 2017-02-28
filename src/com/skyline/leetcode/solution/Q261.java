package com.skyline.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Graph Valid Tree
 * https://leetcode.com/problems/graph-valid-tree/?tab=Description
 * Created by chenliang on 2017/2/26.
 */
public class Q261 {

    public boolean validTree(int n, int[][] edges) {

        if (n < 0 || edges.length < n) {
            return false;
        }

        boolean[] vArray = new boolean[n];
        int vNodeCnt = 0;

        boolean[][] edgeMap = new boolean[n][n];
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            edgeMap[edge[0]][edge[1]] = true;
            edgeMap[edge[1]][edge[0]] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (vArray[node] == true) {
                return false;
            }
            vArray[node] = true;
            vNodeCnt++;
            for (int i = 0; i < n; i++) {
                if (edgeMap[node][i]) {
                    queue.add(i);
                    edgeMap[node][i] = false;
                    edgeMap[i][node] = false;
                }
            }
        }
        return vNodeCnt == n;

    }

}
