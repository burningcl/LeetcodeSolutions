package com.skyline.leetcode.solution;

import java.util.*;

/**
 * @author huasong.cl
 */
public class Q1014 {

//    public int maxScoreSightseeingPair(int[] A) {
//        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
//        for (int i = 0; i < A.length; i++) {
//            treeMap.put(A[i] - i, i);
//        }
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < A.length; i++) {
//            Map.Entry<Integer, Integer> firstEntry = treeMap.firstEntry();
//            while (firstEntry != null && firstEntry.getValue() <= i) {
//                treeMap.remove(firstEntry.getKey());
//                firstEntry = treeMap.firstEntry();
//            }
//            if (firstEntry != null) {
//                max = Integer.max(max, firstEntry.getKey() + A[i] + i);
//            }
//        }
//        return max;
//    }

    public int maxScoreSightseeingPair(int[] A) {
        int maxj = A[A.length - 1] - (A.length - 1);
        int max = Integer.MIN_VALUE;
        for (int i = A.length - 2; i >= 0; i--) {
            max = Integer.max(max, maxj + A[i] + i);
            maxj = Integer.max(maxj, A[i] - i);
        }
        return max;
    }
}
