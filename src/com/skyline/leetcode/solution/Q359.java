package com.skyline.leetcode.solution;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Logger Rate Limiter
 * https://leetcode.com/problems/logger-rate-limiter/?tab=Description
 * Created by chenliang on 2017/3/1.
 */
public class Q359 {

    public class Logger {

        LinkedHashMap<String, Integer> map;

        /**
         * Initialize your data structure here.
         */
        public Logger() {
            map = new LinkedHashMap<String, Integer>() {
                @Override
                public boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                    return map.size() > 10;
                }
            };
        }

        /**
         * Returns true if the message should be printed in the given timestamp, otherwise returns false.
         * If this method returns false, the message will not be printed.
         * The timestamp is in seconds granularity.
         */
        public boolean shouldPrintMessage(int timestamp, String message) {
            if (map.containsKey(message)) {
                int preTimestamp = map.get(message);
                if (timestamp - preTimestamp >= 10) {
                    map.put(message, timestamp);
                    return true;
                } else {
                    return false;
                }
            } else {
                map.put(message, timestamp);
                return true;
            }
        }
    }

}
