package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Palindrome Pairs
 * <p>
 * https://leetcode.com/problems/palindrome-pairs/
 *
 * @author jairus
 */
public class Q336 {


    //超时
//    public List<List<Integer>> palindromePairs(String[] words) {
//        List<List<Integer>> list = new ArrayList<>();
//        if (words == null || words.length <= 1) {
//            return list;
//        }
//        Map<String, Integer> map = new HashMap<>();
//        Map<Integer, Set<Integer>> ret = new HashMap<>();
//        for (int i = 0; i < words.length; i++) {
//            map.put(words[i], i);
//            ret.put(i, new HashSet<>());
//        }
//
//        for (int i = 0; i < words.length; i++) {
//            String word = words[i];
//            if (word.length() <= 0) {
//                continue;
//            }
//            String target = this.reverse(word);
//            Integer targetIndex = map.get(target);
//            if (targetIndex != null) {
//                if (targetIndex != i) {
//                    ret.get(i).add(targetIndex);
//                    ret.get(targetIndex).add(i);
//                } else {
//                    targetIndex = map.get("");
//                    if(targetIndex!=null){
//                        ret.get(i).add(targetIndex);
//                        ret.get(targetIndex).add(i);
//                    }
//                }
//            }
//
//            char last = target.charAt(target.length() - 1);
//            String targetBefore = target.substring(0, target.length() - 1);
//            targetIndex = map.get(targetBefore);
//            if (targetIndex != null && targetBefore.length() > 0) {
//                ret.get(targetIndex).add(i);
//            }
//            while (targetBefore.length() > 1 && targetBefore.charAt(targetBefore.length() - 1) == last) {
//                targetBefore = targetBefore.substring(0, targetBefore.length() - 1);
//                targetIndex = map.get(targetBefore);
//                if (targetIndex != null) {
//                    ret.get(targetIndex).add(i);
//                }
//            }
//            char first = target.charAt(0);
//            String targetAfter = target.substring(1);
//            targetIndex = map.get(targetAfter);
//            if (targetIndex != null && targetAfter.length() > 0) {
//                ret.get(i).add(targetIndex);
//            }
//            while (targetAfter.length() > 1 && targetAfter.charAt(0) == first) {
//                targetAfter = targetAfter.substring(1);
//                targetIndex = map.get(targetAfter);
//                if (targetIndex != null) {
//                    ret.get(i).add(targetIndex);
//                }
//            }
//        }
//        for (int i : ret.keySet()) {
//            Set<Integer> set = ret.get(i);
//            for (int j : set) {
//                List<Integer> sub = new ArrayList<>();
//                sub.add(i);
//                sub.add(j);
//                list.add(sub);
//            }
//
//        }
//        return list;
//    }
//
//
//    public String reverse(String str) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = str.length() - 1; i >= 0; i--) {
//            sb.append(str.charAt(i));
//        }
//        return sb.toString();
//    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> list = new ArrayList<>();

        if (words == null || words.length <= 1) {
            return list;
        }
        Set<List<Integer>> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.length() <= 0) {
                continue;
            }
            String target = this.reverse(word);
            Integer targetIndex = map.get(target);
            if (targetIndex != null && targetIndex == i) {
                //本身就是回文
                targetIndex = map.get("");
            }
            if (targetIndex != null) {
                add(set, i, targetIndex);
                add(set, targetIndex, i);
            }

            int end = target.length() - 1;
            for (int j = 0; j < end; j++) {
                if (isPalindrome(target, 0, j)) {
                    String targetT = target.substring(j + 1);
                    if (map.containsKey(targetT)) {
                        add(set, i, map.get(targetT));
                    }
                }
                if (isPalindrome(target, end - j, end)) {
                    String targetT = target.substring(0, end - j);
                    if (map.containsKey(targetT)) {
                       add(set, map.get(targetT), i);
                    }
                }
            }
        }
        list.addAll(set);
        return list;
    }

    public void add(Set<List<Integer>> set, int i, int j) {
        List<Integer> sub = new ArrayList<>();
        sub.add(i);
        sub.add(j);
        set.add(sub);
    }


    public boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public String reverse(String str) {
        char[] cs = str.toCharArray();
        int low = 0;
        int high = cs.length - 1;
        while (low < high) {
            char c = cs[low];
            cs[low] = cs[high];
            cs[high] = c;
            low++;
            high--;
        }
        return String.valueOf(cs);
    }


    public static void main(String[] args) {


    }

}
