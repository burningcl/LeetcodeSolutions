package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Factor Combinations
 * https://leetcode.com/problems/factor-combinations/?tab=Description
 * Created by chenliang on 2017/2/26.
 */
public class Q254 {

//    public List<List<Integer>> getFactors(int n) {
//        List<List<Integer>> list = new ArrayList<>();
//        if (n <= 1) {
//            return list;
//        }
//        this.getFactors(2, n, new ArrayList<Integer>(), list);
//        return list;
//    }
//
//    public void getFactors(int start, int target, List<Integer> subList, List<List<Integer>> list) {
//        if (target == 1) {
//            if (subList.size() > 1) {
//                list.add(new ArrayList<>(subList));
//            }
//            return;
//        }
//        for (int i = start; i <= target; i++) {
//            if (target % i == 0) {
//                int rest = target / i;
//                if (rest >= i || rest == 1) {
//                    subList.add(i);
//                    this.getFactors(i, rest, subList, list);
//                    subList.remove(subList.size() - 1);
//                }
//            }
//        }
//    }

}
