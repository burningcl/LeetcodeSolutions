package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Copy List with Random Pointer
 * 
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * @author jairus
 *
 */
public class Q138 {

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode c1 = null, h1 = null;
		RandomListNode c = head;
		while (c != null) {
			RandomListNode node = map.get(c);
			if (node != null) {
				c1.next = node;
				break;
			}
			node = new RandomListNode(c.label);
			if (c1 == null) {
				c1 = h1 = node;
			} else {
				c1.next = node;
				c1 = c1.next;
			}
			map.put(c, node);
			c = c.next;
		}
		c = head;
		c1 = h1;
		Set<RandomListNode> set = new HashSet<>();
		while (c != null && !set.contains(c)) {
			RandomListNode rand = c.random;
			if (rand != null) {
				RandomListNode rand1 = map.get(rand);
				c1.random = rand1;
			}
			set.add(c);
			c = c.next;
			c1 = c1.next;
		}
		return h1;
	}

	public static void main(String... strings) {
		RandomListNode h = new RandomListNode(1);
		h.random = h;
		h.next = h;
		Q138 q = new Q138();
		System.out.println(q.copyRandomList(h).label);
		System.out.println(q.copyRandomList(h).random.label);
		System.out.println(q.copyRandomList(h).next.label);
	}
}
