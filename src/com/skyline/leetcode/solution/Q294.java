package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Flip Game II
 * https://leetcode.com/problems/flip-game-ii/?tab=Description
 * Created by chenliang on 2017/2/27.
 */
public class Q294 {

    Map<String, Boolean> map = null;

    public boolean canWin(String s) {
        if (s == null || s.length() <= 1) {
            return false;
        }
        map = new HashMap<>();
        return this.canWin(s.toCharArray());
    }

    public boolean canWin(char[] s) {
        String key = String.valueOf(s);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int plusCnt = 0;
        boolean canWin = false;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '+') {
                plusCnt++;
                if (plusCnt >= 2) {
                    s[i - 1] = '-';
                    s[i] = '-';
                    boolean canWinNext = canWin(s);
                    s[i - 1] = '+';
                    s[i] = '+';
                    if (!canWinNext) {
                        canWin = true;
                        break;
                    }
                }
            } else {
                plusCnt = 0;
            }
        }
        map.put(key, canWin);
        return canWin;
    }

    public static void main(String... strings) {
        char[] s1 = {'a', 'b'};
        char[] s2 = {'a', 'b'};
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1.equals(s2));

        Q294 q = new Q294();
        System.out.println(q.canWin("++++"));
    }

}
