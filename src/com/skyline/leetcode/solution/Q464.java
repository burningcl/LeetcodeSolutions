package com.skyline.leetcode.solution;

/**
 * Can I Win
 * https://leetcode.com/problems/can-i-win/
 * Created by chenliang on 2017/1/30.
 */
public class Q464 {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal > (maxChoosableInteger + 1) * maxChoosableInteger / 2) {
            return false;
        } else if (desiredTotal == 0) {
            return true;
        }else {
            return desiredTotal % (maxChoosableInteger + 1) != 0;
        }
    }
}
