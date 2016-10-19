package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Frog Jump
 * 
 * https://leetcode.com/problems/frog-jump/
 * 
 * @author jairus
 *
 */
public class Q403 {

	// public class Jump {
	//
	// public int index;
	//
	// public int size;
	//
	// public Jump(int index, int size) {
	// this.index = index;
	// this.size = size;
	// }
	// }
	//
	// public boolean canCross(int[] stones) {
	// if (stones == null || stones.length <= 0 || stones[0] != 0) {
	// return false;
	// }
	// Stack<Jump> stack = new Stack<>();
	// Set<Integer> set = new HashSet<>();
	// int last = stones[stones.length - 1];
	// for (int i = 0; i < stones.length; i++) {
	// set.add(stones[i]);
	// }
	// stack.push(new Jump(0, 0));
	// while (!stack.isEmpty()) {
	// Jump lastJump = stack.pop();
	// int index = lastJump.index;
	// if (index == last) {
	// return true;
	// }
	//
	// int size = lastJump.size;
	// System.out.println(index+", "+size);
	// for (int i = -1; i <= 1; i++) {
	// int newSize = size + i;
	// if (newSize <= 0) {
	// continue;
	// }
	// int newIndex = index + newSize;
	// if (!set.contains(newIndex)) {
	// continue;
	// }
	// if (newIndex == last) {
	// return true;
	// }
	// stack.push(new Jump(newIndex, newSize));
	// }
	// }
	// return false;
	// }

	public boolean canCross(int[] stones) {
		if (stones == null || stones.length <= 0 || stones[0] != 0) {
			return false;
		}
		int n = stones.length;
		Map<Integer, Set<Integer>> map = new HashMap<>();
		Set<Integer> set0 = new HashSet<>();
		set0.add(0);
		map.put(0, set0);
		for (int i = 1; i < n; i++) {
			Set<Integer> set = new HashSet<>();
			int valI = stones[i];
			map.put(valI, set);
			for (int j = i - 1; j >= 0; j--) {
				int valJ = stones[j];
				int div = valI - valJ;
				Set<Integer> setJ = map.get(valJ);
				for (int k = -1; k <= 1; k++) {
					int d = div + k;
					if (setJ.contains(d)) {
						set.add(div);
						break;
					}
				}
			}
		}
		Set<Integer> set = map.get(stones[n - 1]);
		return set != null && !set.isEmpty();
	}

	public static void main(String... strings) {
		Q403 q = new Q403();
		int[] stones = { 0, 1, 3, 5, 6, 8, 12, 17 };
		System.out.println(q.canCross(stones));
		int[] stones1 = { 0, 1, 2, 3, 4, 8, 9, 11 };
		System.out.println(q.canCross(stones1));
		int[] stones2 = { 0 };
		System.out.println(q.canCross(stones2));
		int[] stones3 = new int[1000];
		for (int i = 0; i <= 998; i++) {
			stones3[i] = i;
		}
		stones3[999] = 1000;
		long t1 = System.currentTimeMillis();
		System.out.println(q.canCross(stones3));
		long t2 = System.currentTimeMillis();
		System.out.println(t2 - t1);
	}
}
