package com.skyline.leetcode.solution;

/**
 * Convert to Base -2
 *
 * @author huasong.cl
 */
public class Q1017 {

    public String baseNeg2(int N) {
        int cur = 1;
        int sum = 1;
        while (sum < N) {
            cur *= 4;
            sum += cur;
        }
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        while (cur > 0) {
            if (flag) {
                if (N >= cur) {
                    N -= cur;
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            } else {
                if (N >= cur) {
                    N -= cur;
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            }
            cur = cur / 2;
            flag = !flag;
        }
        return sb.toString();
    }

}
