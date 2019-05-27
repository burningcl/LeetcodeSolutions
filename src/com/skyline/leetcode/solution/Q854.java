package com.skyline.leetcode.solution;

import java.util.*;

/**
 * K-Similar Strings
 *
 * @author huasong.cl
 */
public class Q854 {

//    public int kSimilarity(String A, String B) {
//        if (A.equals(B)) {
//            return 0;
//        }
//        int total = 0;
//        Set<String> vis = new HashSet<>();
//        Queue<String> queue = new LinkedList<>();
//        queue.add(B);
//        while (!queue.isEmpty()) {
//            for (int k = queue.size(); k > 0; k--) {
//                String b = queue.poll();
//                if (A.equals(b)) {
//                    return total;
//                }
//                int i = 0;
//                for (; i < b.length(); i++) {
//                    if (A.charAt(i) != b.charAt(i)) {
//                        break;
//                    }
//                }
//                for (int j = i + 1; j < b.length(); j++) {
//                    if (A.charAt(i) == b.charAt(j)) {
//                        String b1 = swap(b, i, j);
//                        if (vis.add(b1)) {
//                            queue.add(b1);
//                        }
//                    }
//                }
//            }
//            total++;
//        }
//        return total;
//    }
//
//    private String swap(String src, int i, int j) {
//        char[] array = src.toCharArray();
//        char t = array[i];
//        array[i] = array[j];
//        array[j] = t;
//        return String.valueOf(array);
//    }

    int min;

    public int kSimilarity(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }
        min = Integer.MAX_VALUE;
        dfs(A.toCharArray(), B.toCharArray(), 0, 0);
        return min;
    }

    private void dfs(char[] a, char[] b, int i, int len) {
        if (len >= min-1) {
            return;
        }
        for (; i < b.length && a[i] == b[i]; i++) {
        }
        if (i >= b.length) {
            min = Integer.min(min, len);
            return;
        }
        len++;
        for (int j = i + 1; j < b.length; j++) {
            if (a[i] == b[j]) {
                swap(b, i, j);
                dfs(a, b, i + 1, len);
                swap(b, i, j);
            }
        }

    }

    private void swap(char[] array, int i, int j) {
        char t = array[i];
        array[i] = array[j];
        array[j] = t;
    }


//    public static void main(String... args) {
//        char[] a = {'1', '2', '3'};
//
//        char[] b =        a.clone();
//        System.out.println(a.hashCode() + ", " + b.hashCode());
//        System.out.println(Arrays.equals(a, b));
//    }

}
