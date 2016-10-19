package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Queue Reconstruction by Height
 * 
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 * 
 * @author jairus
 *
 */
public class Q406 {
	public int[][] reconstructQueue(int[][] people) {
		if (people == null || people.length <= 1) {
			return people;
		}
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}
		});
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < people.length; i++) {
			int[] cur = people[i];
			int j = 0;
			int k = 0;
			for (; j < list.size(); j++) {
				int[] c = list.get(j);
				if (c[0] >= cur[0]) {
					if (k < cur[1])
						k++;
					else
						break;
				}
			}
			list.add(j, cur);
		}
		return list.toArray(new int[0][0]);
	}
}
