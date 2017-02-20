package com.skyline.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Perfect Rectangle
 * https://leetcode.com/problems/perfect-rectangle/
 * Created by chenliang on 2017/2/15.
 */
public class Q391 {


    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles == null || rectangles.length <= 0 || rectangles[0] == null || rectangles[0].length != 4) {
            return false;
        }

        Arrays.sort(rectangles, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < rectangles.length; i++) {
            int[] r = rectangles[i];
            if (r[0] < minX) {
                minX = r[0];
            }
            if (r[1] < minY) {
                minY = r[1];
            }
            if (r[2] > maxX) {
                maxX = r[2];
            }
            if (r[3] > maxY) {
                maxY = r[3];
            }
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(minX, minY);
        map.put(maxX, maxY);


        for (int i = 0; i < rectangles.length; i++) {
            int[] r = rectangles[i];
            int xStart = r[0];
            int yStart = r[1];
            int xEnd = r[2];
            int yEnd = r[3];
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(xStart);
            if (entry == null || entry.getKey() != xStart || entry.getValue() != yStart) {
                return false;
            }
            Map.Entry<Integer, Integer> nextEntry = map.higherEntry(xStart);
            if (nextEntry == null || nextEntry.getKey() < xEnd) {
                return false;
            }
            Map.Entry<Integer, Integer> preEntry = map.lowerEntry(xStart);
            if (preEntry != null && preEntry.getValue() == yEnd) {
                xStart = preEntry.getKey();
                map.remove(xStart);
            }
            if (xEnd == nextEntry.getKey() && yEnd == nextEntry.getValue()) {
                map.remove(xEnd);
            }
            if (xEnd < nextEntry.getKey()) {
                map.put(xEnd, entry.getValue());
            }
            map.remove(entry.getKey());
            map.put(xStart, yEnd);
        }
        return map.size() == 1;
    }

}
