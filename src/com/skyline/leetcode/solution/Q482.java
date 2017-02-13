package com.skyline.leetcode.solution;

/**
 * License Key Formatting
 * https://leetcode.com/problems/license-key-formatting/
 * Created by chenliang on 2017/1/18.
 */
public class Q482 {

    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.length() <= 0 || K <= 0) {
            return "";
        }
        int sLen = S.length();
        int dashCnt = 0;
        for (int i = 0; i < sLen; i++) {
            if (S.charAt(i) == '-') {
                dashCnt++;
            }
        }
        int cLen = sLen - dashCnt;
        int firLen = cLen % K == 0 ? K : cLen % K;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        for (; sb.length() < firLen&& i<sLen; i++) {
            char c = S.charAt(i);
            if (c == '-') {
                continue;
            }
            if (c >= 'a' && c <= 'z') {
                c = (char) (c - 'a' + 'A');
            }
            sb.append(c);
        }
        int j = 0;
        for (; i < sLen; i++) {
            char c = S.charAt(i);
            if (c == '-') {
                continue;
            }
            if (j % K == 0) {
                sb.append('-');
            }
            if (c >= 'a' && c <= 'z') {
                c = (char) (c - 'a' + 'A');
            }
            sb.append(c);
            j++;
        }
        return sb.toString();
    }
}
