package com.skyline.leetcode.solution;

import java.util.Map;
import java.util.TreeMap;

import com.skyline.leetcode.solution.Q435.Interval;

/**
 * 
 * Find Right Interval
 * 
 * https://leetcode.com/problems/find-right-interval/
 * 
 * @author jairus
 *
 */
public class Q436 {
	public int[] findRightInterval(Interval[] intervals) {
		if (intervals == null)
			return null;
		int[] ret = new int[intervals.length];
		if (intervals.length <= 0)
			return ret;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < intervals.length; i++) {
			map.put(intervals[i].start, i);
		}
		Map.Entry<Integer, Integer> entry = null;
		for (int i = 0; i < intervals.length; i++) {
			entry = map.ceilingEntry(intervals[i].end);
			ret[i] = entry != null ? entry.getValue() : -1;
		}
		return ret;
	}

}
