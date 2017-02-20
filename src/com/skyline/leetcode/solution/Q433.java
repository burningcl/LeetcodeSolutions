package com.skyline.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Minimum Genetic Mutation
 * https://leetcode.com/problems/minimum-genetic-mutation/?tab=Description
 * Created by chenliang on 2017/2/20.
 */
public class Q433 {

    public int minMutation(String start, String end, String[] bank) {
        if (start == null || start.length() <= 0 || end == null || end.length() <= 0 || bank == null || bank.length <= 0) {
            return -1;
        } else if (start.equals(end)) {
            return 0;
        }
        int len = bank.length;
        boolean[][] map = new boolean[len][len];
        int target = -1;
        for (int i = 0; i < len; i++) {
            if (end.equals(bank[i])) {
                target = i;
            }
            for (int j = i + 1; j < len; j++) {
                if (mutable(bank[i], bank[j])) {
                    map[i][j] = true;
                    map[j][i] = true;
                }
            }
        }
        if (target == -1) {
            return -1;
        }
        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        int min = 1;
        boolean[] vArray = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (mutable(start, bank[i])) {
                queue1.add(i);
                vArray[i] = true;
            }
        }
        while (!queue1.isEmpty()) {
            while (!queue1.isEmpty()) {
                int index = queue1.poll();
                if (index == target) {
                    return min;
                }
                for (int i = 0; i < len; i++) {
                    if (!vArray[i] && map[index][i]) {
                        queue2.add(i);
                        vArray[i] = true;
                    }
                }
            }
            min++;
            Queue<Integer> q = queue1;
            queue1 = queue2;
            queue2 = q;
        }
        return -1;
    }

    public boolean mutable(String start, String end) {
        boolean mutable = false;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) {
                if (!mutable) {
                    mutable = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
