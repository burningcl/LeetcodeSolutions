package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals
 * <p>
 * https://leetcode.com/problems/merge-intervals/
 *
 * @author jairus
 */
public class Q56 {

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

//	public List<Interval> merge(List<Interval> intervals) {
//		if (intervals == null || intervals.size() <= 1) {
//			return intervals;
//		}
//		Collections.sort(intervals, new Comparator<Interval>() {
//			@Override
//			public int compare(Interval o1, Interval o2) {
//				if (o1.start == o2.start) {
//					return o1.end - o2.end;
//				} else {
//					return o1.start - o2.start;
//				}
//			}
//		});
//
//		List<Interval> ret = new ArrayList<>();
//		Interval cur = intervals.get(0);
//		ret.add(cur);
//
//		for (int i = 1; i < intervals.size(); i++) {
//			Interval c = intervals.get(i);
//			if (cur.start <= c.start && cur.end >= c.start) {
//				cur.end = cur.end > c.end ? cur.end : c.end;
//			} else {
//				cur=c;
//				ret.add(cur);
//			}
//		}
//		return ret;
//	}

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start) {
                    return o2.end - o1.end;
                } else {
                    return o1.start - o2.start;
                }
            }
        });

        List<Interval> ret = new ArrayList<>();
        Interval cur = intervals.get(0);
        ret.add(cur);

        for (int i = 1; i < intervals.size(); i++) {
            Interval c = intervals.get(i);
            if (c.end <= cur.end) {
                continue;
            }
            if (cur.end >= c.start) {
                cur.end = c.end;
            } else {
                ret.add(c);
                cur = c;
            }
        }
        return ret;
    }

}
