package com.skyline.leetcode.solution;

import java.util.Arrays;

/**
 * Heaters
 * 
 * https://leetcode.com/problems/heaters/
 * 
 * @author jairus
 *
 */
public class Q475 {

	public int findRadius(int[] houses, int[] heaters) {
		if (houses == null || houses.length <= 0 || heaters == null || heaters.length <= 0) {
			return 0;
		}
		Arrays.sort(heaters);
		int low = 0;
		int high = heaters.length - 1;
		int radius = 0;
		int mid = 0;
		int r = 0;
		for (int house : houses) {
			low = 0;
			high = heaters.length - 1;
			while (low <= high) {
				mid = (low + high) / 2;
				if (heaters[mid] == house) {
					break;
				} else if (heaters[mid] > house) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			if (low > high) {
				if (high == heaters.length - 1) {
					r = house - heaters[high];
				} else if (low == 0) {
					r = heaters[0] - house;
				} else {
					r = Math.min(house - heaters[high], heaters[low] - house);
				}

				if (r > radius) {
					radius = r;
				}
			}
		}
		return radius;
	}

	public static void main(String[] args) {
		Q475 q = new Q475();
		int[] ho1 = { 1, 2, 3 };
		int[] he1 = { 2 };
		System.out.println(q.findRadius(ho1, he1));

		int[] ho2 = { 1, 2, 3, 4 };
		int[] he2 = { 1, 4 };
		System.out.println(q.findRadius(ho2, he2));

		int[] ho3 = { 282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923 };
		int[] he3 = { 823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840,
				143542612 };
		System.out.println(q.findRadius(ho3, he3));
	}

}
