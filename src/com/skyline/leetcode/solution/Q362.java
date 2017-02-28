package com.skyline.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Design Hit Counter
 * https://leetcode.com/problems/design-hit-counter/?tab=Description
 * Created by chenliang on 2017/2/28.
 */
public class Q362 {

    public class HitCounter {

        int FIVE_MINUTES = 300;

        Queue<Integer> queue = null;

        /**
         * Initialize your data structure here.
         */
        public HitCounter() {
            queue = new ArrayDeque<>();
        }

        /**
         * Record a hit.
         *
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public void hit(int timestamp) {
            queue.add(timestamp);
        }

        /**
         * Return the number of hits in the past 5 minutes.
         *
         * @param timestamp - The current timestamp (in seconds granularity).
         */
        public int getHits(int timestamp) {
            int startTimestamp = timestamp - FIVE_MINUTES;
            while (!queue.isEmpty() && queue.peek() <= startTimestamp) {
                queue.poll();
            }
            return queue.size();
        }
    }

}
