package com.skyline.leetcode.solution;

import java.util.*;

/**
 * All Paths From Source to Target
 *
 * @author huasong.cl
 */
public class Q797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        Map<Integer, List<List<Integer>>> cache = new HashMap<>();

        int end = graph.length - 1;
        List<List<Integer>> endLists = new ArrayList<>();
        List<Integer> endList = new ArrayList<>();
        endList.add(end);
        endLists.add(endList);
        cache.put(end, endLists);

        List<List<Integer>> ret = this.dfs(graph, cache, 0);
        for(List<Integer> list: ret){
            Collections.reverse(list);
        }
        return ret;

    }

    public List<List<Integer>> dfs(int[][] graph, Map<Integer, List<List<Integer>>> cache, int index) {
        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        List<List<Integer>> ret = new ArrayList<>();
        ;
        int[] connectNodes = graph[index];
        if (connectNodes != null && connectNodes.length > 0) {
            for (int connectNode : connectNodes) {
                List<List<Integer>> subLists = this.dfs(graph, cache, connectNode);
                if (subLists != null && subLists.size() > 0) {
                    for (List<Integer> subList : subLists) {
                        List<Integer> newSubList = new ArrayList<>(subList);
                        newSubList.add(index);
                        ret.add(newSubList);
                    }
                }
            }
        }
        cache.put(index, ret);
        return ret;
    }

}
