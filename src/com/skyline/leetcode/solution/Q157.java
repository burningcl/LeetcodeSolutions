package com.skyline.leetcode.solution;

/**
 * Read N Characters Given Read4
 * https://leetcode.com/problems/read-n-characters-given-read4/?tab=Description
 * Created by chenliang on 2017/2/24.
 */
public class Q157 {


    int read4(char[] buf) {
        return 0;
    }

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        int total = 0;
        int read4 = 4;
        char[] newBuff = new char[n];
        for (; total < n && read4 == 4; ) {
            read4 = this.read4(newBuff);
            int end = read4;
            if (total + read4 > n) {
                end = n - total;
            }
            for (int i = 0; i < end; i++) {
                buf[total + i] = newBuff[i];
            }
            total += read4;
        }

        return Integer.min(total, n);
    }

}
