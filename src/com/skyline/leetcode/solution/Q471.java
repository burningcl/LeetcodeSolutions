package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Encode String with Shortest Length
 * https://leetcode.com/problems/encode-string-with-shortest-length/?tab=Description
 * Created by chenliang on 2017/2/27.
 */
public class Q471 {

    public String encode(String s) {
        if (s == null || s.length() <= 3) {
            return s;
        }
        return this.encode(s, new HashMap<>()).toString();
    }

    class EncodedString {
        public String pattern;
        public int cnt;

        public String string;

        public EncodedString(String pattern, int cnt) {
            this.pattern = pattern;
            this.cnt = cnt;
        }

        @Override
        public String toString() {
            if (string != null) {
                return string;
            }
            String str = new StringBuilder().append(cnt).append('[').append(pattern).append(']').toString();
            if (str.length() > pattern.length() * cnt) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < cnt; i++) {
                    builder.append(pattern);
                }
                string = builder.toString();
            } else {
                string = str;
            }
            return string;
        }

    }

    public EncodedString encode(final String s, Map<String, EncodedString> cache) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        if (s.length() <= 1) {
            EncodedString es = new EncodedString(s, 1);
            cache.put(s, es);
            return es;
        }
        String string = s;
        EncodedString es = new EncodedString(s, 1);
        for (int i = 1; i <= s.length() - 1; i++) {
            String left = s.substring(0, i);
            EncodedString esLeft = this.encode(left, cache);
            String right = s.substring(i, s.length());
            EncodedString esRight = this.encode(right, cache);
            EncodedString est = null;
            if (esLeft.pattern.equals(esRight.pattern)) {
                est = new EncodedString(esLeft.pattern, esLeft.cnt + esRight.cnt);
                if (string.length() >= est.toString().length()) {
                    string = est.toString();
                    es = est;
                }
            } else {
                est = new EncodedString(esLeft.toString() + esRight.toString(), 1);
                if (string.length() > est.toString().length()) {
                    string = est.toString();
                    es = est;
                }
            }
        }
        cache.put(s, es);
        return es;
    }

    public static void main(String... strings) {
        Q471 q = new Q471();
        System.out.println(q.encode("accaccacc"));
    }

}
