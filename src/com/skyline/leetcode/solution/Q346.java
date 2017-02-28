package com.skyline.leetcode.solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Moving Average from Data Stream
 * https://leetcode.com/problems/moving-average-from-data-stream/?tab=Description
 * Created by chenliang on 2017/2/28.
 */
public class Q346 {

    public class MovingAverage {

        Queue<Integer> queue = null;

        int size;

        double sum = 0;

        /**
         * Initialize your data structure here.
         */
        public MovingAverage(int size) {
            queue = new LinkedList<>();
            this.size = size;
        }

        public double next(int val) {
            sum += val;
            queue.add(val);
            if (queue.size() > size) {
                sum -= queue.poll();
            }
            return sum / queue.size();
        }
    }

}
