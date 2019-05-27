package com.skyline.leetcode.solution;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author huasong.cl
 */
public class Q1054 {

//    public int[] rearrangeBarcodes(int[] barcodes) {
//        if (barcodes == null || barcodes.length <= 2) {
//            return barcodes;
//        }
//        Arrays.sort(barcodes);
//        int length = barcodes.length;
//        int half = length >> 1;
//        int count = 1;
//        for (int i = length - 2; i >= 0; i--) {
//            if (barcodes[i] == barcodes[length - 1]) {
//                count++;
//            } else {
//                break;
//            }
//        }
//        if (count > half) {
//            for (int i = 0; i < half; i++) {
//                int t = barcodes[i];
//                barcodes[i] = barcodes[length - i - 1];
//                barcodes[length - i - 1] = t;
//            }
//        }
//        int[] ret = new int[length];
//        int k = 0;
//        for (int i = 0, j = length - 1; i <= j; i++, j--) {
//            ret[k++] = barcodes[i];
//            if (i < j) {
//                ret[k++] = barcodes[j];
//            }
//        }
//        return ret;
//    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        if (barcodes == null || barcodes.length <= 2) {
            return barcodes;
        }
        Arrays.sort(barcodes);
        PriorityQueue<int[]> heap = new PriorityQueue<>((int[] o1, int[] o2) -> Integer.compare(o2[0], o1[0]));
        int count = 1;
        int pre = barcodes[0];
        for (int i = 1; i < barcodes.length; i++) {
            if (barcodes[i] != pre ) {
                int[] item = {count, pre};
                //System.out.println(count + ", " + pre);
                heap.offer(item);
                pre = barcodes[i];
                count = 1;
            } else {
                count++;
            }
        }
        int[] item = {count, pre};
        heap.offer(item);

        int i = 0;
        while (!heap.isEmpty()) {
            int[] array0 = heap.poll();
            if (heap.isEmpty()) {
                barcodes[i++] = array0[1];
            } else {
                int[] array1 = heap.poll();
                if (i == 0 || array0[1] != barcodes[i - 1]) {
                    barcodes[i++] = array0[1];
                    barcodes[i++] = array1[1];
                } else {
                    barcodes[i++] = array1[1];
                    barcodes[i++] = array0[1];
                }
                array0[0]--;
                array1[0]--;
                if (array0[0] > 0) {
                    heap.offer(array0);
                }
                if (array1[0] > 0) {
                    heap.offer(array1);
                }
            }
        }
        return barcodes;
    }

}
