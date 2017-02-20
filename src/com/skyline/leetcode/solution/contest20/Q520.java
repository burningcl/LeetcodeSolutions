package com.skyline.leetcode.solution.contest20;

/**
 * Created by chenliang on 2017/2/19.
 */
public class Q520 {

    public boolean detectCapitalUse(String word) {
        if (word == null || word.length() <= 0) {
            return false;
        }
        boolean firstUpperCase = Character.isUpperCase(word.charAt(0));
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        for (int i = 1; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                hasUpperCase = true;
            } else {
                hasLowerCase = true;
            }
        }
        if (firstUpperCase) {
            if (hasUpperCase && hasLowerCase) {
                return false;
            } else {
                return true;
            }
        } else {
            return !hasUpperCase;
        }
    }

    public static void main(String... strings) {
        Q520 q = new Q520();
        System.out.println(q.detectCapitalUse("USA"));
        System.out.println(q.detectCapitalUse("usa"));
        System.out.println(q.detectCapitalUse("Google"));
        System.out.println(q.detectCapitalUse("aGGG"));
        System.out.println(q.detectCapitalUse("G"));
    }
}
