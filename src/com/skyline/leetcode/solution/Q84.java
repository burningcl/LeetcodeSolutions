package com.skyline.leetcode.solution;

import java.util.ArrayDeque;

/**
 * Largest Rectangle in Histogram
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * Created by chenliang on 2017/1/29.
 */
public class Q84 {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length <= 0) {
            return 0;
        }
        ArrayDeque<Integer> heightStack = new ArrayDeque<>();
        ArrayDeque<Integer> indexStack = new ArrayDeque<>();
        heightStack.add(heights[0]);
        indexStack.add(0);
        int area = heights[0];
        for (int i = 1; i <= heights.length; i++) {
            int curHeight = i < heights.length ? heights[i] : Integer.MIN_VALUE;
            int curIndex = i;
            while (!heightStack.isEmpty() && heightStack.peek() >= curHeight) {
                int curHeightT = heightStack.pop();
                curIndex = indexStack.pop();
                int areaT = (i - curIndex) * curHeightT;
                if (areaT > area) {
                    area = areaT;
                }
            }
            heightStack.push(curHeight);
            indexStack.push(curIndex);
        }
        return area;
    }

}
