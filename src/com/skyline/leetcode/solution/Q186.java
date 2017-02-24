package com.skyline.leetcode.solution;

/**
 * Reverse Words in a String II
 * https://leetcode.com/problems/reverse-words-in-a-string-ii/?tab=Description
 * Created by chenliang on 2017/2/24.
 */
public class Q186 {

    public void reverseWords(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        int start = 0;
        for (int i = 0; i <= s.length; i++) {
            if (i == s.length || s[i] == ' ') {
                this.reverseWords(s, start, i - 1);
                start = i + 1;
            }
        }
        this.reverseWords(s, 0, s.length - 1);
    }

    private void reverseWords(char[] s, int left, int right) {
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

}
