package com.skyline.leetcode.solution;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author huasong.cl
 */
public class Q881 {

//    public int numRescueBoats(int[] people, int limit) {
//        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//        for (int weight : people) {
//            int cnt = treeMap.getOrDefault(weight, 0);
//            treeMap.put(weight, cnt + 1);
//        }
//        int total = 0;
//        int pre = 0;
//        while (!treeMap.isEmpty()) {
//            Map.Entry<Integer, Integer> aEntry = treeMap.ceilingEntry(pre);
//            if (aEntry == null || aEntry.getValue() <= 0) {
//                break;
//            }
//            Map.Entry<Integer, Integer> bEntry = treeMap.floorEntry(limit - aEntry.getKey());
//            if (bEntry == null) {
//                total += aEntry.getValue();
//                treeMap.remove(aEntry.getKey());
//            } else if (aEntry.getKey() == bEntry.getKey()) {
//                total += aEntry.getValue() / 2;
//                if (aEntry.getValue() % 2 != 0) {
//                    total++;
//                }
//                treeMap.remove(aEntry.getKey());
//            } else {
//                int cnt = Integer.min(aEntry.getValue(), bEntry.getValue());
//                total += cnt;
//                int aCnt = aEntry.getValue() - cnt;
//                if (aCnt <= 0) {
//                    treeMap.remove(aEntry.getKey());
//                } else {
//                    treeMap.put(aEntry.getKey(), aCnt);
//                }
//                int bCnt = bEntry.getValue() - cnt;
//                if (bCnt <= 0) {
//                    treeMap.remove(bEntry.getKey());
//                } else {
//                    treeMap.put(bEntry.getKey(), bCnt);
//                }
//            }
//        }
//        return total;
//    }

//    public int numRescueBoats(int[] people, int limit) {
//        Arrays.sort(people);
//        int low = 0;
//        int high = people.length - 1;
//        int total = 0;
//        while (low <= high) {
//            if (people[low] + people[high] <= limit) {
//                ++low;
//            }
//            --high;
//            ++total;
//        }
//        return total;
//    }

    public int numRescueBoats(int[] people, int limit) {
        int[] array = new int[limit + 1];
        for (int weight : people) {
            array[weight]++;
        }
        int low = 1;
        int high = limit;
        int total = 0;
        while (low <= high) {
            if (array[low] == 0) {
                low++;
            } else if (array[high] == 0) {
                high--;
            } else if (low + high <= limit) {
                if (low == high) {
                    total += array[low] / 2;
                    if (array[low] % 2 != 0) {
                        total++;
                    }
                    break;
                } else {
                    int cnt = Integer.min(array[low], array[high]);
                    total += cnt;
                    array[low] -= cnt;
                    array[high] -= cnt;
                }
            } else {
                total += array[high--];
            }
        }
        return total;
    }

}
