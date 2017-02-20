package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Data Stream as Disjoint Intervals
 * https://leetcode.com/problems/data-stream-as-disjoint-intervals/
 * Created by chenliang on 2017/2/17.
 */
public class Q352 {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public class SummaryRanges {

        TreeMap<Integer, Interval> treeMap = null;

        /**
         * Initialize your data structure here.
         */
        public SummaryRanges() {
            treeMap = new TreeMap<>();
        }

        public void addNum(int val) {
            Map.Entry<Integer, Interval> entry = treeMap.floorEntry(val);
            int start = val;
            int end = val;
            if (entry != null) {
                if (val <= entry.getValue().end) {
                    return;
                } else if (val == entry.getValue().end + 1) {
                    start = entry.getKey();
                    treeMap.remove(start);
                }
            }
            Map.Entry<Integer, Interval> nextEntry = treeMap.higherEntry(val);
            if (nextEntry != null && nextEntry.getKey() == val + 1) {
                treeMap.remove(nextEntry.getKey());
                end = nextEntry.getValue().end;
            }
            treeMap.put(start, new Interval(start, end));
        }

        public List<Interval> getIntervals() {
            List<Interval> list = new ArrayList<>();
            list.addAll(treeMap.values());
            return list;
        }
    }
}
