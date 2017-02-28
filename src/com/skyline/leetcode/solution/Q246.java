package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * Strobogrammatic Number
 * https://leetcode.com/problems/strobogrammatic-number/?tab=Description
 * Created by chenliang on 2017/2/25.
 */
public class Q246 {
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() <= 0) {
            return false;
        }
        int[] array = new int[10];
        Arrays.fill(array, -1);
        array[0] = 0;
        array[1] = 1;
        array[6] = 9;
        array[8] = 8;
        array[9] = 6;
        StringBuilder num2 =new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            int curNum = num.charAt(i) - '0';
            if (array[curNum] < 0) {
                return false;
            }
            num2.append(array[curNum]);
        }
        return num2.toString().equals(num);
    }
}
