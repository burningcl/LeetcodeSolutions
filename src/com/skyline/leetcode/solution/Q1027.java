package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huasong.cl
 */
public class Q1027 {

    public int longestArithSeqLength(int[] A) {
        List<Map<Integer, Integer>> list = new ArrayList<>(A.length);
        list.add(new HashMap<>());
        int max = 1;
        for (int j = 1; j < A.length; j++) {
            int a = A[j];
            Map<Integer, Integer> map = new HashMap<>();
            list.add(map);
            for (int i = j - 1; i >= 0; i--) {
                int val = A[i] - a;
                Map<Integer, Integer> mapi = list.get(i);
                int len = Integer.max(mapi.getOrDefault(val, 0) + 1, map.getOrDefault(val, 2));
                max = Integer.max(len, max);
                map.put(val, len);
            }
        }
        return max;
    }

}
