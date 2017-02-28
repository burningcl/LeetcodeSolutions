package com.skyline.leetcode.solution;

import java.util.*;

/**
 * Binary Tree Vertical Order Traversal
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/?tab=Description
 * Created by chenliang on 2017/2/28.
 */
public class Q314 {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        //this.verticalOrder(root, map, 0);
        Queue<Wrap> queue = new LinkedList<>();
        queue.add(new Wrap(root, 0));
        int min = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            Wrap cur = queue.poll();
            List<Integer> subList = map.get(cur.key);
            if (subList == null) {
                subList = new ArrayList<>();
                map.put(cur.key, subList);
            }
            subList.add(cur.node.val);
            min = Integer.min(cur.key, min);
            max = Integer.max(cur.key, max);
            if (cur.node.left != null) {
                queue.add(new Wrap(cur.node.left, cur.key - 1));
            }
            if (cur.node.right != null) {
                queue.add(new Wrap(cur.node.right, cur.key + 1));
            }
        }
        for (int i = min; i <= max; i++) {
            list.add(map.get(i));
        }
        return list;
    }

    public class Wrap {
        TreeNode node;
        int key;

        public Wrap(TreeNode node, int key) {
            this.node = node;
            this.key = key;
        }
    }


}
