package com.skyline.leetcode.solution;

import java.util.*;

/**
 * Rearrange String k Distance Apart
 * https://leetcode.com/problems/rearrange-string-k-distance-apart/?tab=Description
 * Created by chenliang on 2017/3/2.
 */
public class Q358 {

//    public String rearrangeString(String s, int k) {
//        if (s == null || s.length() <= 1 || k <= 1) {
//            return s;
//        }
//        char[] cs = new char[s.length()];
//        Arrays.fill(cs, ' ');
//        int[] lastIndexes = new int[128];
//        int[] cnts = new int[128];
//        for (int i = 0; i < s.length(); i++) {
//            cnts[s.charAt(i)]++;
//        }
//        Arrays.fill(lastIndexes, -1);
//        if (rearrangeString(s, 0, lastIndexes, k, cs, cnts)) {
//            return String.valueOf(cs);
//        } else {
//            return "";
//        }
//    }
//
//    public boolean rearrangeString(String s, int sIndex, int[] lastIndexes, int k, char[] cs, int[] cnts) {
//        if (sIndex >= s.length()) {
//            return true;
//        }
//        char c = s.charAt(sIndex);
//        int cIndex = 0;
//        int lastIndex = lastIndexes[c];
//        if (lastIndex >= 0) {
//            cIndex = lastIndex + k;
//        }
//        for (int i = cIndex; i < cs.length - (cnts[c] - 1) * k; i++) {
//            if (cs[i] != ' ') {
//                continue;
//            }
//            cs[i] = c;
//            lastIndexes[c] = i;
//            cnts[c]--;
//            if (rearrangeString(s, sIndex + 1, lastIndexes, k, cs, cnts)) {
//                return true;
//            }
//            cs[i] = ' ';
//            lastIndexes[c] = lastIndex;
//            cnts[c]++;
//        }
//        return false;
//    }

    public String rearrangeString(String s, int k) {
        if (s == null || s.length() <= 1 || k <= 1) {
            return s;
        }
        char[] cs = new char[s.length()];
        int[][] cnts = new int[128][2];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnts[c][0] = c;
            cnts[c][1]++;
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < 128; i++) {
            if (cnts[i][1] > 0) {
                heap.add(cnts[i]);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        int[] lastIndexes = new int[128];
        Arrays.fill(lastIndexes, -1);
        int index = 0;
        while (!heap.isEmpty() || !queue.isEmpty()) {
            while (!queue.isEmpty() && index - lastIndexes[queue.peek()[0]] >= k) {
                heap.add(queue.poll());
            }
            if (heap.isEmpty()) {
                return "";
            }
            int[] item = heap.poll();
            char c = (char) item[0];
            lastIndexes[c] = index;
            cs[index++] = c;
            if (--item[1] <= 0) {
                continue;
            }
            queue.add(item);
        }
        return String.valueOf(cs);

    }

//    public boolean rearrangeString(String s, int sIndex, int[] lastIndexes, int k, char[] cs, int[] cnts) {
//        if (sIndex >= s.length()) {
//            return true;
//        }
//        char c = s.charAt(sIndex);
//        int cIndex = 0;
//        int lastIndex = lastIndexes[c];
//        if (lastIndex >= 0) {
//            cIndex = lastIndex + k;
//        }
//        for (int i = cIndex; i < cs.length - (cnts[c] - 1) * k; i++) {
//            if (cs[i] != ' ') {
//                continue;
//            }
//            cs[i] = c;
//            lastIndexes[c] = i;
//            cnts[c]--;
//            if (rearrangeString(s, sIndex + 1, lastIndexes, k, cs, cnts)) {
//                return true;
//            }
//            cs[i] = ' ';
//            lastIndexes[c] = lastIndex;
//            cnts[c]++;
//        }
//        return false;
//    }

}
