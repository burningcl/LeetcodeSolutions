package com.skyline.leetcode.solution.contest20;

import java.util.Map;

/**
 * Created by chenliang on 2017/2/19.
 */
public class Q517 {

    public int findMinMoves(int[] machines) {
        if (machines == null || machines.length <= 0) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < machines.length; i++) {
            sum += machines[i];
        }
        if (sum % machines.length != 0) {
            return -1;
        }
        int maxMove = 0;
        int curMove = 0;
        int avg = sum / machines.length;
        for (int i = 0; i < machines.length - 1; i++) {
            int move = 0;
            if (machines[i] != avg) {
                move = machines[i] - avg;
                machines[i + 1] += move;
            }
            int totalMove = curMove >= 0 && move >= 0 ? curMove + move : Integer.max(Math.abs(curMove), Math.abs(move));
            if (totalMove > maxMove) {
                maxMove = totalMove;
            }
            curMove = -move;

        }
        return maxMove;
    }

}
