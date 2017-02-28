package com.skyline.leetcode.solution;

import java.util.List;

/**
 * Zigzag Iterator
 * https://leetcode.com/problems/zigzag-iterator/?tab=Description
 * Created by chenliang on 2017/2/27.
 */
public class Q281 {

    public class ZigzagIterator {

        List<Integer> v1;

        List<Integer> v2;

        int index = 0;

        int size = 0;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            this.index = 0;
            this.size = v1.size() + v2.size();
            this.v1 = v1;
            this.v2 = v2;
        }

        public int next() {
            int half = index / 2;
            if (half >= v1.size()) {
                return v2.get(index++ - v1.size());
            } else if (half >= v2.size()) {
                return v1.get(index++ - v2.size());
            }
            index++;
            if ((index - 1) % 2 == 0) {
                return v1.get(half);
            } else {
                return v2.get(half);
            }
        }

        public boolean hasNext() {
            return index < size;
        }
    }

}
