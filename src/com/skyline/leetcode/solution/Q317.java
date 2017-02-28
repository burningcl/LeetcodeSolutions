package com.skyline.leetcode.solution;

import java.util.*;

/**
 * Shortest Distance from All Buildings
 * https://leetcode.com/problems/shortest-distance-from-all-buildings/?tab=Description
 * Created by chenliang on 2017/2/28.
 */
public class Q317 {

//    public int shortestDistance(int[][] grid) {
//        if (grid == null || grid.length <= 0 || grid[0].length <= 0) {
//            return 0;
//        }
//        int n = grid.length;
//        int m = grid[0].length;
//        int[][] disGrid = new int[n][m];
//        long min = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (grid[i][j] != 0) {
//                    continue;
//                }
//                for (int k = 0; k < n; k++) {
//                    Arrays.fill(disGrid[k], Integer.MAX_VALUE);
//                }
//                flooding(grid, disGrid, n, m, i, j, 0);
//                long total = 0;
//                for (int k = 0; k < n && total < Integer.MAX_VALUE; k++) {
//                    for (int l = 0; l < m && total < Integer.MAX_VALUE; l++) {
//                        if (grid[k][l] == 1) {
//                            total += disGrid[k][l];
//                        }
//                    }
//                }
//                min = Long.min(min, total);
//            }
//        }
//        return min >= Integer.MAX_VALUE ? -1 : (int) min;
//    }
//
//    public void flooding(int[][] grid, int[][] disGrid, int n, int m, int i, int j, int val) {
//        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 2 || disGrid[i][j] <= val) {
//            return;
//        }
//        disGrid[i][j] = val;
//        if (grid[i][j] == 1) {
//            return;
//        }
//        val++;
//        flooding(grid, disGrid, n, m, i - 1, j, val);
//        flooding(grid, disGrid, n, m, i + 1, j, val);
//        flooding(grid, disGrid, n, m, i, j - 1, val);
//        flooding(grid, disGrid, n, m, i, j + 1, val);
//    }


//    public int shortestDistance(int[][] grid) {
//        if (grid == null || grid.length <= 0 || grid[0].length <= 0) {
//            return 0;
//        }
//        int n = grid.length;
//        int m = grid[0].length;
//        int[][] disGrid = new int[n][m];
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (grid[i][j] == 1) {
//                    this.bfs(grid, disGrid, n, m, i, j);
//                }
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(disGrid[i][j] + "\t");
//                if (grid[i][j] == 0 && disGrid[i][j] > 0) {
//                    min = Integer.min(min, disGrid[i][j]);
//                }
//            }
//            System.out.println();
//        }
//
//        return min == Integer.MAX_VALUE ? -1 : min;
//    }

//    public void bfs(int[][] grid, int[][] disGrid, int n, int m, int i, int j) {
//        Queue<Integer> queue = new ArrayDeque<>();
//        Queue<Integer> queue1 = new ArrayDeque<>();
//        boolean[][] vMap = new boolean[n][m];
//        queue.add(i);
//        queue.add(j);
//        int dis = 0;
//        while (!queue.isEmpty()) {
//            boolean added=false;
//            while (!queue.isEmpty()) {
//                i = queue.poll();
//                j = queue.poll();
//                if(vMap[i][j]){
//                    continue;
//                }
//                disGrid[i][j] += dis;
//                vMap[i][j] = true;
//                if (i - 1 >= 0 && grid[i - 1][j] == 0 ) {
//                    queue1.add(i - 1);
//                    queue1.add(j);
//                    added=true;
//                }
//                if (i + 1 < n && grid[i + 1][j] == 0 ) {
//                    queue1.add(i + 1);
//                    queue1.add(j);
//                    added=true;
//                }
//                if (j - 1 >= 0 && grid[i][j - 1] == 0 ) {
//                    queue1.add(i);
//                    queue1.add(j - 1);
//                    added=true;
//                }
//                if (j + 1 < m && grid[i][j + 1] == 0 ) {
//                    queue1.add(i);
//                    queue1.add(j + 1);
//                    added=true;
//                }
//            }
//            if(added) {
//                dis++;
//            }
//            Queue<Integer> t = queue;
//            queue = queue1;
//            queue1 = t;
//        }
//        for ( i = 0; i < n; i++) {
//            for ( j = 0; j < m; j++) {
//                System.out.print(disGrid[i][j] + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }

    int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        // Initialize building list and accessibility matrix `grid`
        List<Tuple> buildings = new ArrayList<>();
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1)
                    buildings.add(new Tuple(i, j, 0));
                grid[i][j] = -grid[i][j];
            }
        // BFS from every building
        for (int k = 0; k < buildings.size(); ++k)
            bfs(buildings.get(k), k, dist, grid, m, n);
        // Find the minimum distance
        int ans = -1;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (grid[i][j] == buildings.size() && (ans < 0 || dist[i][j] < ans))
                    ans = dist[i][j];
        return ans;
    }

    public void bfs(Tuple root, int k, int[][] dist, int[][] grid, int m, int n) {
        Queue<Tuple> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            Tuple b = q.poll();
            dist[b.y][b.x] += b.dist;
            for (int i = 0; i < 4; ++i) {
                int x = b.x + dx[i], y = b.y + dy[i];
                if (y >= 0 && x >= 0 && y < m && x < n && grid[y][x] == k) {
                    grid[y][x] = k + 1;
                    q.add(new Tuple(y, x, b.dist + 1));
                }
            }
        }
    }

    class Tuple {
        public int y;
        public int x;
        public int dist;

        public Tuple(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }

}
