package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Max Points on a Line
 * 
 * https://leetcode.com/problems/max-points-on-a-line/
 * 
 * @author jairus
 *
 */
public class Q149 {

	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public int maxPoints(Point[] points) {
		if (points == null) {
			return 0;
		} else if (points.length <= 2) {
			return points.length;
		}

		int max = 0;
		int pointCnt = 0;
		Map<Double, Integer> map = new HashMap<>();
		for (int i = 0; i < points.length; i++) {
			map.clear();
			pointCnt = 1;
			for (int j = i + 1; j < points.length; j++) {
				if (points[j].x == points[i].x && points[j].y == points[i].y) {
					pointCnt++;
					continue;
				}
				double v = points[j].x == points[i].x ? Integer.MAX_VALUE
						: ((double) (points[j].y - points[i].y)) / (points[j].x - points[i].x);
				if (v == 0)
					v = 0;
				Integer cnt = map.get(v);
				if (cnt == null) {
					cnt = 1;
				} else {
					cnt++;
				}
				map.put(v, cnt);
			}
			for (Map.Entry<Double, Integer> e : map.entrySet()) {
				if (e.getValue() + pointCnt > max) {
					max = e.getValue() + pointCnt;
				}
			}
			if (pointCnt > max) {
				max = pointCnt;
			}
		}
		return max;
	}

	public static void main(String[] args) {
	}
}
