package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Flip Game
 * https://leetcode.com/problems/flip-game/?tab=Description
 * Created by chenliang on 2017/2/27.
 */
public class Q293 {

    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() <= 1) {
            return list;
        }
        int plusCnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+') {
                plusCnt++;
            } else {
                plusCnt = 0;
            }
            if (plusCnt >= 2) {
                list.add(s.substring(0, i - 2) + "--" + s.substring(i + 1, s.length()));
            }
        }
        return list;
    }

}
