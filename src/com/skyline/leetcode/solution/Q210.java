package com.skyline.leetcode.solution;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Course Schedule II
 * https://leetcode.com/problems/course-schedule-ii/
 * Created by chenliang on 2017/1/28.
 */
public class Q210 {

    int index = 0;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] prerequisity : prerequisites) {
            list.get(prerequisity[0]).add(prerequisity[1]);
        }
        int[] ret = new int[numCourses];
        boolean[] varray = new boolean[numCourses];
        boolean[] vingarray = new boolean[numCourses];

        try {
            for (int i = 0; i < numCourses; i++) {
                dfs(ret, varray, vingarray, list, i);
            }
        } catch (Exception e) {
            return new int[0];
        }
        return ret;
    }

    public void dfs(int[] ret, boolean[] varray, boolean[] vingarray, List<List<Integer>> list, int i) {
        if (varray[i]) {
            return;
        }
        if (vingarray[i]) {
            throw new RuntimeException();
        }
        vingarray[i] = true;
        for (int rIndex : list.get(i)) {
            if (varray[rIndex]) {
                continue;
            }
            this.dfs(ret, varray, vingarray, list, rIndex);
        }
        varray[i] = true;
        vingarray[i] = false;
        ret[index++] = i;
    }

}
