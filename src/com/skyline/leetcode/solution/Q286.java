package com.skyline.leetcode.solution;

/**
 * Walls and Gates
 * https://leetcode.com/problems/walls-and-gates/?tab=Description
 * Created by chenliang on 2017/2/27.
 */
public class Q286 {

    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        int n = rooms.length;
        int m = rooms[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    flooding(rooms, n, m, i - 1, j, 1);
                    flooding(rooms, n, m, i + 1, j, 1);
                    flooding(rooms, n, m, i, j - 1, 1);
                    flooding(rooms, n, m, i, j + 1, 1);
                }
            }
        }
    }

    public void flooding(int[][] rooms, int n, int m, int i, int j, int dis) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return;
        }
        if (rooms[i][j] <= dis) {
            return;
        }
        rooms[i][j] = dis;
        dis++;
        flooding(rooms, n, m, i - 1, j, dis);
        flooding(rooms, n, m, i + 1, j, dis);
        flooding(rooms, n, m, i, j - 1, dis);
        flooding(rooms, n, m, i, j + 1, dis);
    }

}
