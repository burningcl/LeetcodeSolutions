package com.skyline.leetcode.solution;

import java.util.*;

/**
 * IPO
 * https://leetcode.com/problems/ipo/
 * Created by chenliang on 2017/2/13.
 */
public class Q502 {
//    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
//        if (k <= 0 || Profits == null || Profits.length <= 0 || Capital == null || Capital.length <= 0) {
//            return 0;
//        }
//        int n = Profits.length;
//        boolean[] useds = new boolean[n];
//
//        int index;
//        int capital = W;
//
//        for (int i = 0; i < k; i++) {
//
//            index = -1;
//
//            for (int j = 0; j < n; j++) {
//                if (useds[j]) {
//                    continue;
//                }
//                if (W >= Capital[j] && W - Capital[j] + Profits[j] > capital) {
//                    index = j;
//                    capital = W - Capital[j] + Profits[j];
//                }
//            }
//
//            if (index == -1) {
//                return W;
//            }
//
//            useds[index] = true;
//            W = capital;
//
//        }
//
//        return W;
//    }

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        if (k <= 0 || Profits == null || Profits.length <= 0 || Capital == null || Capital.length <= 0) {
            return 0;
        }
        int n = Profits.length;
        int[][] array = new int[n][2];
        for (int i = 0; i < n; i++) {
            array[i][0] = Profits[i];
            array[i][1] = Capital[i];
        }
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int j = 0;
        for (int i = 0; i < k; i++) {
            for (; j < n && array[j][1] <= W; j++) {
                int profit = array[j][0];
                int cnt = map.getOrDefault(profit, 0);
                map.put(profit, cnt + 1);
            }
            System.out.println(map.size());
            if (map.isEmpty()) {
                return W;
            }
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            W += entry.getKey();
            int cnt = entry.getValue();
            if (cnt == 1) {
                map.remove(entry.getKey());
            } else {
                map.put(entry.getKey(), cnt - 1);
            }
        }

        return W;
    }

}
