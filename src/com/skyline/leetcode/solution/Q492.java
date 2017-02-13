package com.skyline.leetcode.solution;

/**
 * Construct the Rectangle
 * <p>
 * https://leetcode.com/problems/construct-the-rectangle/
 * <p>
 * Created by chenliang on 2017/1/23.
 */
public class Q492 {

    public int[] constructRectangle(int area) {

        int[] ret = new int[2];
        if (area <= 0) {
            return ret;
        }
        int width = (int) Math.sqrt(area);
        for (; width >= 1; width--) {
            if (area % width == 0) {
                ret[0] = area / width;
                ret[1] = width;
                break;
            }
        }

        return ret;
    }
}
