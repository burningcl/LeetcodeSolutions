package com.skyline.leetcode.solution;

/**
 * Read N Characters Given Read4 II - Call multiple times
 * https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/?tab=Description
 * Created by chenliang on 2017/2/24.
 */
public class Q158 {

    int read4(char[] buf) {
        return 0;
    }


//    /**
//     * @param buf Destination buffer
//     * @param n   Maximum number of characters to read
//     * @return The number of characters read
//     */
//    public int read(char[] buf, int n) {
//        int total = read4Total - read4Actual;
//        for (int i = 0; i < total; i++) {
//            buf[i] = read4Buff[read4Actual + i];
//        }
//        if (total < n) {
//            read4Total = 4;
//        } else {
//            read4Total = 0;
//        }
//        while (total < n && read4Total == 4) {
//            read4Total = read4(read4Buff);
//            read4Actual = read4Total;
//            if (total + read4Total > n) {
//                read4Actual = n - total;
//            }
//            for (int i = 0; i < read4Actual; i++) {
//                buf[total + i] = read4Buff[i];
//            }
//            total += read4Actual;
//        }
//        return Integer.min(total, n);
//    }


    char[] read4Buff = new char[4];

    int read4Total = 4;

    int read4Actual = 4;

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return The number of characters read
     */
    public int read(char[] buf, int n) {
        if (n <= 0) {
            return 0;
        }
        int total = Integer.min(read4Total - read4Actual, n);
        for (int i = 0; i < total; i++) {
            buf[i] = read4Buff[read4Actual + i];
        }
        read4Actual += total;

        while (total < n && read4Total == 4) {
            read4Total = read4(read4Buff);
            read4Actual = read4Total;
            if (total + read4Total > n) {
                read4Actual = n - total;
            }
            for (int i = 0; i < read4Actual; i++) {
                buf[total + i] = read4Buff[i];
            }
            total += read4Actual;
        }
        return Integer.min(total, n);
    }
}
