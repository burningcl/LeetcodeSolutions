package com.skyline.leetcode.solution;

import java.util.TreeSet;

/**
 * Find Median from Data Stream
 * 
 * https://leetcode.com/problems/find-median-from-data-stream/
 * 
 * @author jairus
 *
 */
public class Q295 {

	// TreeMap<Integer, Integer> map = new TreeMap<>();
	//
	// int numCnt;
	//
	// // Adds a number into the data structure.
	// public void addNum(int num) {
	// Integer cnt = map.get(num);
	// if (cnt == null) {
	// cnt = 1;
	// } else {
	// cnt++;
	// }
	// map.put(num, cnt);
	// numCnt++;
	// }
	//
	// // Returns the median of current data stream
	// public double findMedian() {
	// if (numCnt == 0) {
	// return 0;
	// }
	// Set<Map.Entry<Integer, Integer>> set = map.entrySet();
	// Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();
	// int cnt = 0;
	// Map.Entry<Integer, Integer> entry = null;
	// int half = numCnt / 2;
	// while (cnt < half && iterator.hasNext()) {
	// entry = iterator.next();
	// cnt += entry.getValue();
	// }
	// Map.Entry<Integer, Integer> next = iterator.hasNext() ? iterator.next() :
	// null;
	// if (numCnt % 2 == 1) {
	// if (cnt > half) {
	// return entry.getKey();
	// } else {
	// return next.getKey();
	// }
	// } else {
	// if (cnt > half && entry.getValue() > 1) {
	// return entry.getKey();
	// } else {
	// return (double) (entry.getKey() + next.getKey()) / 2;
	// }
	// }
	// }

	TreeSet<Long> set = new TreeSet<>();

	int numCnt;

	long mid = 0;

	// Adds a number into the data structure.
	public void addNum(int num) {
		long numLong = num;
		numLong = (numLong << 32) + numCnt;
		set.add(numLong);
		if (numCnt == 0) {
			mid = numLong;
		} else if (numCnt % 2 == 0) {
			if (numLong > mid) {
				// 向后找更大的一个数
				mid = set.ceiling(mid + 1);
			}
		} else {
			if (numLong < mid) {
				// 向前找更小的一个数
				mid = set.floor(mid - 1);
			}
		}
		numCnt++;
	}

	// Returns the median of current data stream
	public double findMedian() {
		if (numCnt == 0) {
			return 0;
		}
		if (numCnt % 2 == 1) {
			return mid >> 32;
		} else {
			long gt = set.ceiling(mid + 1);
			return (double) ((gt >> 32) + (mid >> 32)) / 2;
		}
	}

	public static void main(String... strings) {
		Q295 q = new Q295();
		// [6.00000,8.00000,6.00000,6.00000,6.00000,5.50000,6.00000,5.50000,5.00000,4.00000,3.00000]
//		 q.addNum(6);
//		 System.out.println(q.findMedian());
//		 q.addNum(10);
//		 System.out.println(q.findMedian());
//		 q.addNum(2);
//		 System.out.println(q.findMedian());
//		 q.addNum(6);
//		 System.out.println(q.findMedian());
//		 q.addNum(5);
//		 System.out.println(q.findMedian());
//		 q.addNum(0);
//		 System.out.println(q.findMedian());
//		 q.addNum(6);
//		 System.out.println(q.findMedian());
//		 q.addNum(3);
//		 System.out.println(q.findMedian());
//		 q.addNum(1);
//		 System.out.println(q.findMedian());
//		 q.addNum(0);
//		 System.out.println(q.findMedian());
//		 q.addNum(0);
//		 System.out.println(q.findMedian());

		q.addNum(0);
		System.out.println(q.findMedian());
		q.addNum(0);
		System.out.println(q.findMedian());
		q.addNum(1);
		System.out.println(q.findMedian());
		q.addNum(2);
		System.out.println(q.findMedian());
		q.addNum(3);
		System.out.println(q.findMedian());
		q.addNum(4);
		System.out.println(q.findMedian());
	}
}
