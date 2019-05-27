package com.skyline.leetcode.solution;

/**
 * @author huasong.cl
 */
public class Q1021 {

    public String removeOuterParentheses(String S) {
        int start = 0;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                sb.append(S.substring(start+1, i));
                start=i+1;
            }
        }
        return sb.toString();
    }

}
