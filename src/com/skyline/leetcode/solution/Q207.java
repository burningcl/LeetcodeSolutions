package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Course Schedule
 * 
 * https://leetcode.com/problems/course-schedule/
 * 
 * @author jairus
 *
 */
public class Q207 {

	private boolean canFinish(int index, Set<Integer> triedSet, Map<Integer, Set<Integer>> map, Set<Integer> succSet) {
		if (map.get(index) == null || succSet.contains(index)) {
			return true;
		} else if (triedSet.contains(index)) {
			return false;
		}
		triedSet.add(index);
		Set<Integer> set = map.get(index);
		for (int i : set) {
			if (!this.canFinish(i, triedSet, map, succSet))
				return false;
		}
		succSet.add(index);
		return true;
	}

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null || prerequisites.length <= 0) {
			return true;
		}
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int[] p : prerequisites) {
			Set<Integer> set = map.get(p[0]);
			if (set == null) {
				set = new HashSet<>();
				map.put(p[0], set);
			}
			set.add(p[1]);
		}
		Set<Integer> triedSet = new HashSet<>();
		Set<Integer> succSet = new HashSet<>();
		for (int i = 0; i < numCourses; i++) {
			if (succSet.contains(i)) {
				continue;
			}
			if (!canFinish(i, triedSet, map, succSet)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Q207 q = new Q207();
		int[][] ps = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 0 } };
		System.out.println(q.canFinish(3, ps));

		int[][] ps1 = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 1, 2 }, { 1, 3 }, { 2, 3 } };
		System.out.println(q.canFinish(4, ps1));
	}

}
