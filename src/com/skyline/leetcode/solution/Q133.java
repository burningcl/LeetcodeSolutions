package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clone Graph
 * 
 * https://leetcode.com/problems/clone-graph/
 * 
 * @author jairus
 *
 */
public class Q133 {

	public UndirectedGraphNode cloneGraph(final UndirectedGraphNode node,
			final Map<UndirectedGraphNode, UndirectedGraphNode> map) {
		if (node == null) {
			return null;
		}
		UndirectedGraphNode newNode = map.get(node);
		if (newNode != null) {
			return newNode;
		}
		newNode = new UndirectedGraphNode(node.label);
		map.put(node, newNode);
		if (node.neighbors == null) {
			return newNode;
		}
		newNode.neighbors = new ArrayList<>();
		for (UndirectedGraphNode neighbor : node.neighbors) {
			newNode.neighbors.add(this.cloneGraph(neighbor, map));
		}
		return newNode;
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		return this.cloneGraph(node, new HashMap<>());
	}
}
