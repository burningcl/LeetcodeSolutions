package com.skyline.leetcode.solution;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Heaters
 * <p>
 * https://leetcode.com/problems/heaters/
 *
 * @author jairus
 */
public class Q475 {

//	public int findRadius(int[] houses, int[] heaters) {
//		if (houses == null || houses.length <= 0 || heaters == null || heaters.length <= 0) {
//			return 0;
//		}
//		Arrays.sort(heaters);
//		int low = 0;
//		int high = heaters.length - 1;
//		int radius = 0;
//		int mid = 0;
//		int r = 0;
//		for (int house : houses) {
//			low = 0;
//			high = heaters.length - 1;
//			while (low <= high) {
//				mid = (low + high) / 2;
//				if (heaters[mid] == house) {
//					break;
//				} else if (heaters[mid] > house) {
//					high = mid - 1;
//				} else {
//					low = mid + 1;
//				}
//			}
//			if (low > high) {
//				if (high == heaters.length - 1) {
//					r = house - heaters[high];
//				} else if (low == 0) {
//					r = heaters[0] - house;
//				} else {
//					r = Math.min(house - heaters[high], heaters[low] - house);
//				}
//
//				if (r > radius) {
//					radius = r;
//				}
//			}
//		}
//		return radius;
//	}

    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length <= 0 || heaters == null || heaters.length <= 0) {
            return 0;
        }
        Arrays.sort(heaters);

        int max = 0;
        for (int i = 0; i < houses.length; i++) {
            int house = houses[i];
            int heaterIndex = Arrays.binarySearch(heaters, house);
            if (heaterIndex >= 0) {
                continue;
            }
            heaterIndex = -heaterIndex - 1;
            int min = Integer.min(
                    heaterIndex - 1 >= 0 ? house - heaters[heaterIndex - 1] : Integer.MAX_VALUE,
                    heaterIndex < heaters.length ? heaters[heaterIndex] - house : Integer.MAX_VALUE
            );
            if (min > max) {
                max = min;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Q475 q = new Q475();
        int[] ho1 = {1, 2, 3};
        int[] he1 = {2};
        System.out.println(q.findRadius(ho1, he1));

        int[] ho2 = {1, 2, 3, 4};
        int[] he2 = {1, 4};
        System.out.println(q.findRadius(ho2, he2));

        int[] ho3 = {282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923};
        int[] he3 = {823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840,
                143542612};
        System.out.println(q.findRadius(ho3, he3));

        int[] array = {1, 3, 5, 7, 9};
        System.out.println(Arrays.binarySearch(array, 0));
        System.out.println(Arrays.binarySearch(array, 1));
        System.out.println(Arrays.binarySearch(array, 2));
        System.out.println(Arrays.binarySearch(array, 4));
    }

}
