package com.skyline.leetcode.solution;

import java.util.*;

/**
 * Range Addition
 * https://leetcode.com/problems/range-addition/?tab=Description
 * Created by chenliang on 2017/3/1.
 */
public class Q370 {

//    public int[] getModifiedArray(int length, int[][] updates) {
//        int[] ret = new int[length];
//        Arrays.sort(updates, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
//        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1] - o2[1];
//            }
//        });
//        int sum = 0;
//        for (int i = 0; i < length; i++) {
//
//        }
//    }

//    public int[] getModifiedArray(int length, int[][] updates) {
//
//        int[] ret = new int[length];
//        Map<Integer, List<Integer>> addMap = new HashMap<>();
//        Map<Integer, List<Integer>> delMap = new HashMap<>();
//
//        for (int i = 0; i < updates.length; i++) {
//
//            int[] update = updates[i];
//
//            List<Integer> addList = addMap.get(update[0]);
//            if (addList == null) {
//                addList = new ArrayList<>();
//                addMap.put(update[0], addList);
//            }
//            addList.add(i);
//
//            List<Integer> delList = delMap.get(update[1]);
//            if (delList == null) {
//                delList = new ArrayList<>();
//                delMap.put(update[1], delList);
//            }
//            delList.add(i);
//        }
//
//        int sum = 0;
//        for (int i = 0; i < length; i++) {
//            List<Integer> addList = addMap.get(i);
//            if (addList != null) {
//                for (int j = 0; j < addList.size(); j++) {
//                    sum += updates[addList.get(j)][2];
//                }
//            }
//            ret[i]=sum;
//            List<Integer> delList = delMap.get(i);
//            if (delList != null) {
//                for (int j = 0; j < delList.size(); j++) {
//                    sum -= updates[delList.get(j)][2];
//                }
//            }
//        }
//
//        return ret;
//    }

    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ret = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int[] update = updates[i];
            ret[update[0]] += update[2];
            if (update[1] + 1 < length) {
                ret[update[1] + 1] -= update[2];
            }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += ret[i];
            ret[i] = sum;
        }
        return ret;
    }

}
