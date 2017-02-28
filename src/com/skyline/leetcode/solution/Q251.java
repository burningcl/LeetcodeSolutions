package com.skyline.leetcode.solution;

import java.util.Iterator;
import java.util.List;

/**
 * Flatten 2D Vector
 * https://leetcode.com/problems/flatten-2d-vector/?tab=Description
 * Created by chenliang on 2017/2/25.
 */
public class Q251 {

    public class Vector2D implements Iterator<Integer> {

        int x = 0;

        int y = 0;

        List<List<Integer>> vec2d;

        public Vector2D(List<List<Integer>> vec2d) {
            x = 0;
            while (x < vec2d.size() && vec2d.get(x).size() <= 0) {
                x++;
            }
            y = 0;
            this.vec2d = vec2d;
        }

        @Override
        public Integer next() {
            int ret = vec2d.get(x).get(y);
            y++;
            if (y >= vec2d.get(x).size()) {
                x++;
                while (x < vec2d.size() && vec2d.get(x).size() <= 0) {
                    x++;
                }
                y = 0;
            }
            return ret;
        }

        @Override
        public boolean hasNext() {
            return x >= vec2d.size() || y >= vec2d.get(x).size() ? false : true;
        }
    }

}
