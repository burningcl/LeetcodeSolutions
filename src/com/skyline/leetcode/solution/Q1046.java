package com.skyline.leetcode.solution;

import java.util.PriorityQueue;

/**
 * @author huasong.cl
 */
public class Q1046 {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int stone : stones) {
            heap.offer(stone);
        }
        while (heap.size() > 1) {
            int cur = heap.poll() - heap.poll();
            if (cur > 0) {
                heap.offer(cur);
            }
        }
        return heap.isEmpty() ? 0 : heap.poll();
    }

}
