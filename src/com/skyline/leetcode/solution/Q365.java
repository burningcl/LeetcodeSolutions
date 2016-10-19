package com.skyline.leetcode.solution;

/**
 * Water and Jug Problem
 * 
 * 
 * @author jairus
 *
 */
public class Q365 {

	public boolean canMeasureWater(int x, int y, int z) {
		if (x < 0 || y < 0 || z < 0) {
			return false;
		} else if (z == 0 || x == z || y == z) {
			return true;
		} else if (z > x + y) {
			return false;
		}
		int max = x > y ? x : y;
		int max2 = max > z ? max : z;
		boolean[] array = new boolean[max2 + 1];
		array[0] = true;
		canMeasureWater(x, y, array);
		if (array[z] || array[1]) {
			return true;
		}
		for (int i = 0; i <= z; i++) {
			if (array[i]) {
				continue;
			}
			for (int j = 0; j <= i; j++) {
				if (array[j] && array[i - j]) {
					array[i] = true;
					break;
				}
			}
		}
		return array[z];
	}

	public void canMeasureWater(int x, int y, boolean[] array) {
		while (true) {
			if (x <= 0 || y <= 0) {
				return;
			}
			array[x] = true;
			array[y] = true;
			int d = x - y;
			if (d < 0) {
				d = -d;
			}
			if (x > y) {
				x = d;
			} else {
				y = d;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(new Q365().canMeasureWater(1, 2, 3));
	}

}
