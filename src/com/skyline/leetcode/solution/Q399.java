package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Evaluate Division
 * 
 * https://leetcode.com/problems/evaluate-division/
 * 
 * @author jairus
 *
 */
public class Q399 {

	private void put(Map<String, Map<String, Double>> map, String a, String b, double val) {
		Map<String, Double> subMap = map.get(a);
		if (subMap == null) {
			subMap = new HashMap<>();
			map.put(a, subMap);
		}
		subMap.put(b, val);
	}

	private double query(Map<String, Map<String, Double>> map, String a, String b, Set<String> set) {
		if (!map.containsKey(a) || !map.containsKey(b)) {
			return -1;
		}
		Map<String, Double> subMap = map.get(a);
		if (subMap.containsKey(b)) {
			return subMap.get(b);
		}
		double ret = -1;
		set.add(a);
		for (String c : subMap.keySet()) {
			if (set.contains(c)) {
				continue;
			}
			double val = query(map, c, b, set);
			if (val != -1) {
				ret = subMap.get(c) * val;
				subMap.put(b, ret);
				break;
			}
		}
		set.remove(a);
		return ret;
	}

	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		Map<String, Map<String, Double>> map = new HashMap<>();
		for (int i = 0; i < equations.length; i++) {
			String a = equations[i][0];
			String b = equations[i][1];
			double val = values[i];
			put(map, a, b, val);
			put(map, b, a, 1 / val);
			put(map, a, a, 1);
			put(map, b, b, 1);
		}
		double[] ret = new double[queries.length];
		Set<String> set = new HashSet<>();
		for (int i = 0; i < queries.length; i++) {
			ret[i] = query(map, queries[i][0], queries[i][1], set);
		}
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
