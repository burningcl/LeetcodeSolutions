package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Strobogrammatic Number II
 * https://leetcode.com/problems/strobogrammatic-number-ii/?tab=Description
 * Created by chenliang on 2017/2/25.
 */
public class Q247 {
    public List<String> findStrobogrammatic(int n) {
        List<String> list = new ArrayList<>();
        if (n <= 0) {
            return list;
        }
        char[][] map = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};
        char[] num = new char[n];
        this.findStrobogrammatic(map, 0, n - 1, num, list);
        return list;
    }

    public void findStrobogrammatic(char[][] map, int left, int right, char[] num, List<String> list) {
        if (right < left) {
            list.add(String.valueOf(num));
            return;
        }
        int start = left == 0 && right > 0 ? 1 : 0;
        for (int i = start; i < map.length; i++) {
            if (left == right && map[i][0] != map[i][1]) {
                continue;
            }
            num[left] = map[i][0];
            num[right] = map[i][1];
            this.findStrobogrammatic(map, left + 1, right - 1, num, list);
        }
    }
}
