package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Can I Win
 * https://leetcode.com/problems/can-i-win/
 * Created by chenliang on 2017/1/30.
 */
public class Q464 {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        int key = (1 << (maxChoosableInteger + 1)) - 1;
        Map<Integer, Boolean> map = new HashMap<>();
        return this.canIWin(key, maxChoosableInteger, desiredTotal, map);
    }

    public boolean canIWin(int key, int maxChoosableInteger, int desiredTotal, Map<Integer, Boolean> map) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int mask;
        boolean canIWin = false;
        for (int i = maxChoosableInteger; i >= 1; i--) {
            mask = 1 << i;
            if ((key & mask) > 0) {
                if (desiredTotal <= i || !this.canIWin(key ^ mask, maxChoosableInteger, desiredTotal - i, map)) {
                    canIWin = true;
                    break;
                }
            }
        }
        map.put(key, canIWin);
        return canIWin;
    }


}
