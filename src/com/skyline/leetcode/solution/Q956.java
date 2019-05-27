package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huasong.cl
 */
public class Q956 {
//
//    public int tallestBillboard(int[] rods) {
//        Map<Integer, Integer> map1 = new HashMap<>();
//        Map<Integer, Integer> map2 = new HashMap<>();
//        map1.put(0, 0);
//        for (int rod : rods) {
//            map2.putAll(map1);
//            for (Integer diff : map1.keySet()) {
//                int curDiff = diff + rod;
//                int curRod = map1.getOrDefault(diff, 0) + rod;
//                this.updateMap(map2, curDiff, curRod);
//                curDiff = diff > rod ? diff - rod : rod - diff;
//                this.updateMap(map2, curDiff, curRod);
//            }
//            Map<Integer, Integer> t = map1;
//            map1 = map2;
//            map2 = t;
//            map2.clear();
//        }
//        return map1.getOrDefault(0, 0) / 2;
//    }

//    private void updateMap(Map<Integer, Integer> map, int diff, int rod) {
//        int max = Integer.max(map.getOrDefault(diff, 0), rod);
//        map.put(diff, max);
//    }

    public int tallestBillboard(int[] rods) {
        if (rods == null || rods.length <= 1) {
            return 0;
        }
        int dpLen = 0;
        for (int rod : rods) {
            dpLen += rod;
        }
        dpLen = (dpLen >> 1) + 1;
        int[] dp1 = new int[dpLen];
        int[] dp2 = new int[dpLen];
        for (int i = 0; i < rods.length; i++) {

            System.arraycopy(dp1, 0, dp2, 0, dpLen);
            dp2[rods[i]] = rods[i];
            int rod = rods[i];
            for (int diff = 0; diff < dpLen; diff++) {
                int preRod = dp1[diff];
                if (preRod > 0) {
                    int curDiff = diff + rod;
                    int curRod = preRod + rod;
                    this.updateMap(dp2, curDiff, curRod);
                    curDiff = diff > rod ? diff - rod : rod - diff;
                    this.updateMap(dp2, curDiff, curRod);
                }
            }
            int[] t = dp1;
            dp1 = dp2;
            dp2 = t;
        }
        return dp1[0] / 2;
    }

    private void updateMap(int[] dp, int diff, int rod) {
        if (diff < dp.length) {
            int max = Integer.max(dp[diff], rod);
            dp[diff] = max;
        }
    }

}
