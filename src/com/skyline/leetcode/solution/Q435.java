package com.skyline.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Non-overlapping Intervals
 * 
 * https://leetcode.com/problems/non-overlapping-intervals/
 * 
 * @author jairus
 *
 */
public class Q435 {

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

	// public int eraseOverlapIntervals(Interval[] intervals) {
	// if (intervals == null || intervals.length <= 1) {
	// return 0;
	// }
	// int total = 0;
	// int[] cnts = new int[intervals.length];
	// for (int i = 0; i < intervals.length; i++) {
	// for (int j = i + 1; j < intervals.length; j++) {
	// Interval inti = intervals[i];
	// Interval intj = intervals[j];
	// if ((inti.start >= intj.start && inti.start < intj.end)
	// || (intj.start >= inti.start && intj.start < inti.end)) {
	// cnts[i]++;
	// cnts[j]++;
	// }
	// }
	// }
	//// for (int k = 0; k < cnts.length; k++) {
	//// System.out.println(cnts[k]);
	//// }
	// for (int k = 0; k < cnts.length; k++) {
	// int max = Integer.MIN_VALUE;
	// int i = 0;
	// for (int ii = 0; ii < cnts.length; ii++) {
	// if (cnts[ii] > max) {
	// i = ii;
	// max = cnts[ii];
	// }
	// }
	// if (max <= 0) {
	// break;
	// }
	// for (int j = 0; j < intervals.length; j++) {
	// if (j == i) {
	// continue;
	// }
	// Interval inti = intervals[i];
	// Interval intj = intervals[j];
	// if ((inti.start >= intj.start && inti.start < intj.end)
	// || (intj.start >= inti.start && intj.start < inti.end)) {
	// cnts[i]--;
	// cnts[j]--;
	// }
	// }
	// total++;
	// }
	// return total;
	// }

	public int eraseOverlapIntervals(Interval[] intervals) {
		if (intervals == null || intervals.length <= 1) {
			return 0;
		}

		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.start == o2.start) {
					return o1.end - o2.end;
				} else {
					return o1.start - o2.start;
				}
			}
		});

		int total = 1;
		Interval former = intervals[0];
		Interval cur = null;
		for (int i = 1; i < intervals.length; i++) {
			cur = intervals[i];
			// 特别注意类似[[1,5],[2,3][3,4][4,5]]这种情况
			if (cur.end < former.end) {
				former = cur;
			} else if (cur.start >= former.end) {
				former = cur;
				total++;
			}
		}
		return intervals.length - total;
	}
}
