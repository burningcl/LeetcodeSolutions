package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huasong.cl
 */
public class Q889 {

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return constructFromPrePost(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }

    public TreeNode constructFromPrePost(int[] pre, int l1, int h1, int[] post, int l2, int h2) {
        if (pre[l1] != post[h2]) {
            return null;
        }
        TreeNode root = new TreeNode(pre[l1]);
        ++l1;
        --h2;
        if (l1 > h1 || l2 > h2) {
            return root;
        }
        int pre1 = pre[l1];
        int m1 = l1;
        int m2 = l2;
        Map<Integer, Integer> map = new HashMap<>();
        for (; m1 <= h1; m1++, m2++) {
            int key1 = pre[m1];
            int key2 = post[m2];
            this.updateMap(map, key1, true);
            this.updateMap(map, key2, false);
            if (pre1 != key2 || map.size() > 0) {
                continue;
            }
            TreeNode left = this.constructFromPrePost(pre, l1, m1, post, l2, m2);
            if (left == null) {
                continue;
            }
            TreeNode right = null;
            if (m1 < h1 && m2 < h2) {
                right = this.constructFromPrePost(pre, m1 + 1, h1, post, m2 + 1, h2);
                if (right == null) {
                    continue;
                }
            }
            root.left = left;
            root.right = right;
            return root;
        }
        return null;
    }

    private void updateMap(Map<Integer, Integer> map, int key, boolean add) {
        int value = map.getOrDefault(key, 0);
        value = add ? value + 1 : value - 1;
        if (value == 0) {
            map.remove(key);
        } else {
            map.put(key, value);
        }
    }

}
