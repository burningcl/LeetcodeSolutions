package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Strong Password Checker
 * https://leetcode.com/problems/strong-password-checker/
 * Created by chenliang on 2017/2/6.
 */
public class Q420 {

//    public static final int IDX_UP = 0;
//    public static final int IDX_LOW = 1;
//    public static final int IDX_NUM = 2;
//
//    public int strongPasswordChecker(String s) {
//        if (s == null || s.length() <= 0) {
//            return 6;
//        }
//
//        char curChar = ' ';
//        int curCharCnt = 0;
//
//        boolean[] available = new boolean[3];
//        List<boolean[]> list = new ArrayList<>();
//        list.add(new boolean[3]);
//        for (int i = 0; i < s.length() - 1; i++) {
//            char c = s.charAt(i);
//            boolean[] array = new boolean[3];
//            available[IDX_UP] |= isUp(c);
//            available[IDX_LOW] |= isLow(c);
//            available[IDX_NUM] |= isNum(c);
//            System.arraycopy(available, 0, array, 0, 3);
//            list.add(array);
//        }
//
//        Arrays.fill(available, false);
//
//        return this.strongPasswordChecker(s, s.length() - 1, available, list, curChar, curCharCnt, 6, 20);
//    }
//
//    public boolean isUp(char c) {
//        return (c >= 'A' && c <= 'Z');
//    }
//
//    public boolean isLow(char c) {
//        return (c >= 'a' && c <= 'z');
//    }
//
//    public boolean isNum(char c) {
//        return (c >= '0' && c <= '9');
//    }
//
//    public int strongPasswordChecker(String s,
//                                     int index,
//                                     boolean[] available,
//                                     List<boolean[]> list,
//                                     char curChar,
//                                     int curCharCnt,
//                                     int minLen,
//                                     int maxLen) {
//        if (index < 0) {
//            int cnt = 0;
//            for (int i = 0; i < 3; i++) {
//                if (!available[i]) {
//                    cnt++;
//                }
//            }
//            return Integer.max(minLen, cnt);
//        }
//
//        char c = s.charAt(index);
//
//        if (curChar == c && curCharCnt == 2) {
//            if (index <= minLen) {
//                if (!available[IDX_UP] && !isUp(c) && !list.get(index)[IDX_UP]) {
//                    available[IDX_UP] = true;
//                } else if (!available[IDX_LOW] && !isLow(c) && !list.get(index)[IDX_LOW]) {
//                    available[IDX_LOW] = true;
//                } else if (!available[IDX_NUM] && !isNum(c) && !list.get(index)[IDX_NUM]) {
//                    available[IDX_NUM] = true;
//                }
//
//                if (index == minLen) {
//                    // 转换当前位置上的字符
//                    // System.out.println("change: "+index);
//                    return this.strongPasswordChecker(s, index - 1, available, list, ' ', 0, minLen - 1, maxLen - 1) + 1;
//                } else {
//                    // 当前位置上加上一个字符
//                    // System.out.println("add: "+index);
//                    return this.strongPasswordChecker(s, index, available, list, ' ', 0, minLen - 1, maxLen - 1) + 1;
//                }
//            } else {
//                if (index >= maxLen) {
//                    // 删除当前位置上的字符
//                    // System.out.println("del: "+index);
//                    return this.strongPasswordChecker(s, index - 1, available, list, curChar, curCharCnt, minLen, maxLen) + 1;
//                } else {
//                    if (!available[IDX_UP] && !isUp(c) && !list.get(index)[IDX_UP]) {
//                        available[IDX_UP] = true;
//                    } else if (!available[IDX_LOW] && !isLow(c) && !list.get(index)[IDX_LOW]) {
//                        available[IDX_LOW] = true;
//                    } else if (!available[IDX_NUM] && !isNum(c) && !list.get(index)[IDX_NUM]) {
//                        available[IDX_NUM] = true;
//                    }
//                    // System.out.println("change: "+index);
//                    return this.strongPasswordChecker(s, index - 1, available, list, ' ', 0, minLen - 1, maxLen - 1) + 1;
//                }
//            }
//        }
//
//        if (minLen <= 0 && index >= maxLen
//                && (
//                (isUp(c) && available[IDX_UP])
//                        || (isLow(c) && available[IDX_LOW])
//                        || (isNum(c) && available[IDX_NUM])
//        )
//                ) {
//            // 删除当前位置的字符
//            // System.out.println("del: "+index);
//            return this.strongPasswordChecker(s, index - 1, available, list, curChar, curCharCnt, minLen, maxLen) + 1;
//        }
//
////        for (int i = 0; i < 3; i++) {
////            if (!available[i] && !list.get(index)[i]) {
////                available[i] = true;
////                // 转换当前位置上的字符
////                return this.strongPasswordChecker(s, index - 1, available, list, ' ', 0, minLen - 1, maxLen - 1) + 1;
////            }
////        }
//
//        available[IDX_UP] |= isUp(c);
//        available[IDX_LOW] |= isLow(c);
//        available[IDX_NUM] |= isNum(c);
//        curCharCnt = curChar != c ? 1 : curCharCnt + 1;
//        // System.out.println("pass: "+index);
//        return this.strongPasswordChecker(s, index - 1, available, list, c, curCharCnt, minLen - 1, maxLen - 1);
//    }


    public static final int MAX_LEN = 20;

    public static final int MIN_LEN = 6;

    int upCnt = 0;

    int lowCnt = 0;

    int digCnt = 0;

    char curChar = ' ';

    int curCharCnt = 0;

    public int strongPasswordChecker(String s) {

        if (s == null || s.length() <= 0) {
            return MIN_LEN;
        }

        curChar = ' ';
        curCharCnt = 0;
        upCnt = 0;
        lowCnt = 0;
        digCnt = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                upCnt++;
            } else if (Character.isDigit(c)) {
                digCnt++;
            } else {
                lowCnt++;
            }
        }

        int changeCnt = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == curChar) {
                if (curCharCnt == 2) {
                    int len = upCnt + lowCnt + digCnt;
                    if (len > MAX_LEN) {
                        int del = len - MAX_LEN;
                    } else if (len < MIN_LEN) {
                        addDiff();
                        System.out.println("add, c: " + c + ", i: " + i + ", upCnt: " + upCnt + ", lowCnt: " + lowCnt + ", digCnt: " + digCnt);
                    } else {
                        del(c);
                        addDiff();
                        System.out.println("change, c: " + c + ", i: " + i + ", upCnt: " + upCnt + ", lowCnt: " + lowCnt + ", digCnt: " + digCnt);
                    }
                    changeCnt++;
                } else {
                    curCharCnt++;
                }
            } else {
                curChar = c;
                curCharCnt = 1;
            }
        }

        int lastAdd = 0;
        if (upCnt == 0) {
            upCnt++;
            changeCnt++;
            lastAdd++;
        }
        if (lowCnt == 0) {
            lowCnt++;
            changeCnt++;
            lastAdd++;
        }
        if (digCnt == 0) {
            digCnt++;
            changeCnt++;
            lastAdd++;
        }

        int len = upCnt + lowCnt + digCnt;
        if (len > MAX_LEN) {
            int delCnt = len - MAX_LEN;
            if (delCnt > lastAdd) {
                changeCnt += delCnt - lastAdd;
            }
        } else if (len < MIN_LEN) {
            changeCnt += MIN_LEN - len;
        }
        return changeCnt;
    }

    public void del(char c) {
        if (Character.isUpperCase(c)) {
            upCnt--;
        } else if (Character.isDigit(c)) {
            digCnt--;
        } else {
            lowCnt--;
        }
    }

    public void addDiff() {
        curChar = ' ';
        curCharCnt = 0;
        if (upCnt == 0) {
            upCnt = 1;
            return;
        }
        if (lowCnt == 0) {
            lowCnt = 1;
            return;
        }
        if (digCnt == 0) {
            digCnt = 1;
            return;
        }
        digCnt++;
    }


    public static void main(String... strings) {
        Q420 q = new Q420();
        System.out.println(q.strongPasswordChecker("ABABABABABABABABABAB1") == 2);
        System.out.println(q.strongPasswordChecker("...") == 3);
        System.out.println(q.strongPasswordChecker("aaaabbaaabbaaa123456A") == 3);
    }
}
