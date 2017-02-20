package com.skyline.leetcode.solution;

/**
 * Largest Palindrome Product
 * https://leetcode.com/problems/largest-palindrome-product/?tab=Description
 * Created by chenliang on 2017/2/18.
 */
public class Q479 {

    public int largestPalindrome(int n) {
        long leftPart = 0;
        int max = 1;
        for (int i = 0; i < n; i++) {
            leftPart = leftPart * 10 + 9;
            max *= 10;
        }
        long leftPartS = leftPart;
        for (; leftPart >= 1; leftPart--) {
            long test = leftPart * max;
            long leftPartT = leftPart;
            long rightPart = 0;
            while (leftPartT > 0) {
                rightPart = rightPart * 10 + leftPartT % 10;
                leftPartT /= 10;
            }
            test += rightPart;
            int min = (int) Math.sqrt(test);
            for (int i = max - 1; i >= min; i--) {
                if (test % i == 0)
                    return (int) (test % 1337);
            }
        }
        leftPart = leftPartS;
        for (; leftPart >= 1; leftPart--) {
            long test = leftPart * max / 10;
            long leftPartT = leftPart % (max / 10);
            long rightPart = 0;
            while (leftPartT > 0) {
                rightPart = rightPart * 10 + leftPartT % 10;
                leftPartT /= 10;
            }
            test += rightPart;
            int min = (int) Math.sqrt(test);
            //System.out.println(test + ", " + max + ", " + min);
            for (int i = max - 1; i >= min; i--) {
                if (test % i == 0)
                    return (int) (test % 1337);
            }
        }
        return 0;
    }
}
