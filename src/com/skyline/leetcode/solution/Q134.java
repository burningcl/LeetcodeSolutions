package com.skyline.leetcode.solution;

/**
 * Gas Station
 * 
 * https://leetcode.com/problems/gas-station/
 * 
 * @author jairus
 *
 */
public class Q134 {

	public int canCompleteCircuit1(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length != cost.length) {
			return -1;
		}
		int sum = 0;
		int length = gas.length;
		for (int i = 0; i < length; i++) {
			gas[i] -= cost[i];
			sum += gas[i];
		}
		if (sum < 0) {
			return -1;
		}
		for (int i = 0; i < length; i++) {
			boolean flag = true;
			sum = 0;
			for (int j = 0; j < length; j++) {
				sum += gas[(i + j) % length];
				if (sum < 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				return i;
			}
		}
		return -1;
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length != cost.length) {
			return -1;
		}
		int sum = 0;
		int length = gas.length;
		for (int i = 0; i < length; i++) {
			gas[i] -= cost[i];
			sum += gas[i];
		}
		if (sum < 0) {
			return -1;
		}
		sum = 0;
		int start = 0;
		for (int i = start; i < start + length; i++) {
			sum += gas[i];
			while (sum < 0) {
				start--;
				sum += gas[(start + length) % length];
			}
		}
		return (start + length) % length;
	}

	public static void main(String[] args) {
		Q134 q = new Q134();
		int[] gas = { 1 };
		int[] cost = { 1 };
		System.out.println(q.canCompleteCircuit(gas, cost));

		int[] gas2 = { 1, 2 };
		int[] cost2 = { 1, 2 };
		System.out.println(q.canCompleteCircuit(gas2, cost2));

		int[] gas3 = { 1, 2 };
		int[] cost3 = { 2, 1 };
		System.out.println(q.canCompleteCircuit(gas3, cost3));

		int[] gas4 = { 4 };
		int[] cost4 = { 5 };
		System.out.println(q.canCompleteCircuit(gas4, cost4));

		int[] gas5 = { 0, 0, 0, 0, 1, 2, 4 };
		int[] cost5 = { 1, 1, 1, 1, 1, 1, 1 };
		System.out.println(q.canCompleteCircuit(gas5, cost5));
	}

}
