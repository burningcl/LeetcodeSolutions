package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Insert Interval
 * 
 * https://leetcode.com/problems/insert-interval/
 * 
 * @author jairus
 *
 */
public class Q57 {

	// Definition for an interval.
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

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		List<Interval> list = new ArrayList<>();
		if (intervals == null || intervals.size() <= 0) {
			if (newInterval != null) {
				list.add(newInterval);
			}
			return list;
		} else if (newInterval == null) {
			return intervals;
		}

		Interval cur = null;
		for (int i = 0; i < intervals.size() || newInterval != null;) {
			Interval insert = null;
			Interval interval = null;
			if (i < intervals.size())
				interval = intervals.get(i);
			if (newInterval == null) {
				insert = interval;
				i++;
			} else if (interval == null) {
				insert = newInterval;
				newInterval = null;
			} else {
				if (interval.start < newInterval.start) {
					insert = interval;
					i++;
				} else {
					insert = newInterval;
					newInterval = null;
				}
			}

			if (cur == null) {
				cur = insert;
			} else {
				if (cur.end > insert.start) {
					cur.end = cur.end >= insert.end ? cur.end : insert.end;
				} else {
					list.add(cur);
					cur = insert;
				}
			}
		}
		if (cur != null) {
			list.add(cur);
		}
		return list;
	}

}
