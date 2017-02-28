package com.skyline.leetcode.solution;

import java.util.*;

/**
 * Meeting Rooms II
 * https://leetcode.com/problems/meeting-rooms-ii/?tab=Description
 * Created by chenliang on 2017/2/25.
 */
public class Q253 {

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length <= 0) {
            return 0;
        }
        TreeSet<Integer> set = new TreeSet<>();
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o2.end - o1.end;
                } else {
                    return o1.start - o1.start;
                }
            }
        });
        int cnt = 0;
        for (int i = 0; i < intervals.length; i++) {
            Interval cur = intervals[i];
            Integer preEnd = set.floor(cur.start);
            if (preEnd == null) {
                cnt++;
            } else {
                set.remove(preEnd);
            }
            set.add(cur.end);
        }
        return cnt;
    }

}
