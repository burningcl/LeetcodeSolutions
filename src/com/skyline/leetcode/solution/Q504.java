package com.skyline.leetcode.solution;

/**
 * Base 7
 * https://leetcode.com/problems/base-7/
 * Created by chenliang on 2017/2/13.
 */
public class Q504 {

    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        boolean negative = num < 0;
        num = num < 0 ? -num : num;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 7);
            num = num / 7;
        }
        if (negative) {
            sb.append("-");
        }
        return sb.reverse().toString();
    }
}
