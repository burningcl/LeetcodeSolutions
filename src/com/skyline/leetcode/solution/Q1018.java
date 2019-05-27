package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huasong.cl
 */
public class Q1018 {

    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<>();
        int num = 0;
        for (int a : A) {
            num = ((num << 1) + a) % 5;
            list.add(num == 0);
        }
        return list;
    }

}
