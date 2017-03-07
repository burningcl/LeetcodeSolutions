package com.skyline.leetcode.solution;

/**
 * Self Crossing
 * https://leetcode.com/problems/self-crossing/?tab=Description
 * Created by chenliang on 2017/3/1.
 */
public class Q335 {

    public boolean isSelfCrossing(int[] x) {
        if (x == null || x.length < 4) {
            return false;
        }
        int[][] array = new int[7][2];
        for (int i = 0; i < x.length; i++) {
            int xDelta = 0;
            int yDelta = 0;
            int iMod4 = i % 4;
            if (iMod4 == 0) {
                yDelta = x[i];
            } else if (iMod4 == 1) {
                xDelta = -x[i];
            } else if (iMod4 == 2) {
                yDelta = -x[i];
            } else {
                xDelta = x[i];
            }
            array[(i + 1) % 7][0] = array[i % 7][0] + xDelta;
            array[(i + 1) % 7][1] = array[i % 7][1] + yDelta;
            if (i >= 3) {
                if (isSelfCrossing(array[(i - 3) % 7], array[(i - 2) % 7], array[(i) % 7], array[(i + 1) % 7])) {
                    return true;
                }
            }
            if (i >= 4) {
                if (isSelfCrossing(array[(i - 4) % 7], array[(i - 3) % 7], array[(i) % 7], array[(i + 1) % 7])) {
                    return true;
                }
            }
            if (i >= 5) {
                if (isSelfCrossing(array[(i - 5) % 7], array[(i - 4) % 7], array[(i) % 7], array[(i + 1) % 7])) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSelfCrossing(int[] start1, int[] end1, int[] start2, int[] end2) {
        //  System.out.println("( " + start1[0]+", "+start1[1] + ")" +"->( " + end1[0]+", "+end1[1] + ")"+"=>"+"( " + start2[0]+", "+start2[1] + ")" +"->( " + end2[0]+", "+end2[1] + ")");

        if (sameLine(start1, end1, start2, end2)) {
            return true;
        }
        if (start1[0] == end1[0]) {
            return isSelfCrossingImpl(start1, end1, start2, end2);
        } else {
            return isSelfCrossingImpl(start2, end2, start1, end1);
        }
    }

    public boolean sameLine(int[] start1, int[] end1, int[] start2, int[] end2) {
        if (start1[0] == end1[0] && start1[0] == start2[0] && start1[0] == end2[0]) {
            return (start2[1] >= Integer.min(start1[1], end1[1]) && start2[1] <= Integer.max(start1[1], end1[1]))
                    || (end2[1] >= Integer.min(start1[1], end1[1]) && end2[1] <= Integer.max(start1[1], end1[1]));
        }
        if (start1[1] == end1[1] && start1[1] == start2[1] && start1[1] == end2[1]) {
            return (start2[0] >= Integer.min(start1[0], end1[0]) && start2[0] <= Integer.max(start1[0], end1[0]))
                    || (end2[0] >= Integer.min(start1[0], end1[0]) && end2[0] <= Integer.max(start1[0], end1[0]));
        }
        return false;
    }

    public boolean isSelfCrossingImpl(int[] start1, int[] end1, int[] start2, int[] end2) {
        int x1 = start1[0];
        int minY1 = Integer.min(start1[1], end1[1]);
        int maxY1 = Integer.max(start1[1], end1[1]);
        int y2 = start2[1];
        int minX2 = Integer.min(start2[0], end2[0]);
        int maxX2 = Integer.max(start2[0], end2[0]);
        // System.out.println("x1: " + x1 + ", minY1: " + minY1 + ", maxY1: " + maxY1 + "y2: " + y2 + ", minX2: " + minX2 + ", maxX2: " + maxX2);
        return (x1 >= minX2 && x1 <= maxX2 && y2 >= minY1 && y2 <= maxY1);
    }

}
