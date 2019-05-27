package com.skyline.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huasong.cl
 */
public class Q1030 {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] ret = new int[R * C][];
        boolean[][] visited = new boolean[R][C];
        int[] pos0 = {r0, c0};
        int index = 0;
        ret[index++] = pos0;
        visited[r0][c0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(pos0);
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];
            if ((pos = allCellsDistOrder(R, C, r - 1, c, visited)) != null) {
                ret[index++] = pos;
                queue.offer(pos);
            }
            if ((pos = allCellsDistOrder(R, C, r + 1, c, visited)) != null) {
                ret[index++] = pos;
                queue.offer(pos);
            }
            if ((pos = allCellsDistOrder(R, C, r, c - 1, visited)) != null) {
                ret[index++] = pos;
                queue.offer(pos);
            }
            if ((pos = allCellsDistOrder(R, C, r, c + 1, visited)) != null) {
                ret[index++] = pos;
                queue.offer(pos);
            }
        }
        return ret;
    }

    public int[] allCellsDistOrder(int R, int C, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= R || c < 0 || c >= C || visited[r][c]) {
            return null;
        }
        visited[r][c] = true;
        int[] pos = {r, c};
        return pos;
    }


}
