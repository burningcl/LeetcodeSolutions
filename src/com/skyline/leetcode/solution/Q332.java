package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Reconstruct Itinerary
 * 
 * https://leetcode.com/problems/reconstruct-itinerary/
 * 
 * @author jairus
 *
 */
public class Q332 {

	public boolean findItinerary(String[][] tickets, Map<String, int[]> map, List<String> list, boolean[] vset,
			String from) {
		int[] rang = map.get(from);
		for (int i = rang[0]; i <= rang[1]; i++) {
			if (vset[i]) {
				continue;
			}
			String to = tickets[i][1];
			vset[i] = true;
			list.add(to);
			if (list.size() > tickets.length) {
				return true;
			}
			int[] rangTo = map.get(to);
			if (rangTo != null && findItinerary(tickets, map, list, vset, to)) {
				return true;
			}
			list.remove(list.size() - 1);
			vset[i] = false;
		}
		return false;
	}

	public List<String> findItinerary(String[][] tickets) {
		if (tickets == null || tickets.length <= 0)
			return null;
		Arrays.sort(tickets, new Comparator<String[]>() {
			int compare(String o1, String o2) {
				for (int i = 0; i < 3; i++) {
					if (o1.charAt(i) != o2.charAt(i)) {
						return o1.charAt(i) - o2.charAt(i);
					}
				}
				return 0;
			}

			@Override
			public int compare(String[] o1, String[] o2) {
				int c1 = compare(o1[0], o2[0]);
				if (c1 != 0)
					return c1;
				return compare(o1[1], o2[1]);
			}
		});
		Map<String, int[]> map = new HashMap<>();
		for (int i = 0; i < tickets.length; i++) {
			String key = tickets[i][0];
			int[] rang = map.get(key);
			if (rang == null) {
				rang = new int[2];
				rang[0] = i;
				map.put(key, rang);
			}
			rang[1] = i;
		}
		List<String> list = new ArrayList<>();
		String from = "JFK";
		list.add(from);
		this.findItinerary(tickets, map, list, new boolean[tickets.length], from);
		return list;
	}

	public static void main(String[] args) {
		Q332 q = new Q332();
		String[][] tickets = { { "MUC", "LHR" }, { "JFK", "MUC" }, { "SFO", "SJC" }, { "LHR", "SFO" } };
		System.out.println(q.findItinerary(tickets));
		String[][] t2 = { { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL", "JFK" }, { "ATL", "SFO" } };
		System.out.println(q.findItinerary(t2));
		String[][] t3 = { { "JFK", "ATL" }, { "ATL", "JFK" } };
		System.out.println(q.findItinerary(t3));
		String[][] t4 = { { "JFK", "KUL" }, { "JFK", "NRT" }, { "NRT", "JFK" } };
		System.out.println(q.findItinerary(t4));
	}

}
