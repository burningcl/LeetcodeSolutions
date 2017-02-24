package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Two Sum III - Data structure design
 * https://leetcode.com/problems/two-sum-iii-data-structure-design/?tab=Description
 * Created by chenliang on 2017/2/24.
 */
public class Q170 {

    public class TwoSum {

        Map<Long, Integer> map = null;

        /**
         * Initialize your data structure here.
         */
        public TwoSum() {
            map = new HashMap<>();
        }

        /**
         * Add the number to an internal data structure..
         */
        public void add(int number) {
            int cnt = map.getOrDefault((long) number, 0);
            map.put((long) number, cnt + 1);
        }

        /**
         * Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            long sum = value;
            for (long num : map.keySet()) {
                long target = sum - num;
                if (map.containsKey(target)) {
                    if (num == target && map.get(num) > 1) {
                        return true;
                    } else if (num != target) {
                        return true;
                    }
                }
            }
            return false;
        }

    }

}
