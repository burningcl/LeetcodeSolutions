package com.skyline.leetcode.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Design Phone Directory
 * https://leetcode.com/problems/design-phone-directory/?tab=Description
 * Created by chenliang on 2017/3/1.
 */
public class Q379 {

    public class PhoneDirectory {

        boolean[] avbArray;

        Queue<Integer> queue;

        /**
         * Initialize your data structure here
         *
         * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
         */
        public PhoneDirectory(int maxNumbers) {
            avbArray = new boolean[maxNumbers];
            Arrays.fill(avbArray, true);
            queue = new LinkedList<>();
            for (int i = 0; i < maxNumbers; i++) {
                queue.add(i);
            }
        }

        /**
         * Provide a number which is not assigned to anyone.
         *
         * @return - Return an available number. Return -1 if none is available.
         */
        public int get() {
            if (queue.size() <= 0) {
                return -1;
            }
            int num = queue.poll();
            avbArray[num] = false;
            return num;
        }

        /**
         * Check if a number is available or not.
         */
        public boolean check(int number) {
            if (number < 0 || number >= avbArray.length) {
                return false;
            }
            return avbArray[number];
        }

        /**
         * Recycle or release a number.
         */
        public void release(int number) {
            if (number < 0 || number >= avbArray.length) {
                return;
            }
            if (avbArray[number]) {
                return;
            }
            avbArray[number] = true;
            queue.add(number);
        }
    }

}
