package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * All O`one Data Structure
 * 
 * https://leetcode.com/problems/all-oone-data-structure/
 * 
 * @author jairus
 *
 */
public class Q432 {

	public static class AllOne {

		class ListNode {
			ListNode pre;
			ListNode next;
			Set<String> keys = new HashSet<>();

			@Override
			public String toString() {
				return keys + " -> " + next;
			}
		}

		ListNode head, tail;

		Map<String, Integer> map;

		Map<Integer, ListNode> listNodeMap;

		/** Initialize your data structure here. */
		public AllOne() {
			map = new HashMap<>();
			listNodeMap = new HashMap<>();
			head = tail = null;
		}

		public void delListNode(ListNode listNode, int cnt) {
			if (listNode == null) {
				return;
			}
			listNodeMap.remove(cnt);
			if (listNode == head && listNode == tail) {
				// 只有一个元素
				head = tail = null;
				return;
			}
			ListNode pre = listNode.pre;
			ListNode next = listNode.next;
			if (pre == null) {
				// 第一个元素
				head = next;
				next.pre = null;
				listNode.next = null;
			} else if (next == null) {
				// 最后一个元素
				tail = pre;
				pre.next = null;
				listNode.pre = null;
			} else {
				pre.next = next;
				next.pre = pre;
				listNode.pre = listNode.next = null;
			}
		}

		/**
		 * Inserts a new key <Key> with value 1. Or increments an existing key
		 * by 1.
		 */
		public void inc(String key) {
			Integer cnt = map.get(key);
			if (cnt == null) {
				cnt = 1;
				ListNode listNode = listNodeMap.get(cnt);
				if (listNode == null) {
					listNode = new ListNode();
					listNodeMap.put(cnt, listNode);
					if (tail == null) {
						// tail ==null，那head肯定==null
						head = tail = listNode;
					} else {
						tail.next = listNode;
						listNode.pre = tail;
						tail = listNode;
					}
				}
				listNode.keys.add(key);
			} else {
				// 处理原来这个key所在的listNode;
				ListNode listNode = listNodeMap.get(cnt);
				ListNode pre = listNode.pre;
				listNode.keys.remove(key);
				if (listNode.keys.size() <= 0) {
					this.delListNode(listNode, cnt);
				}
				cnt++;
				listNode = listNodeMap.get(cnt);
				if (listNode == null) {
					listNode = new ListNode();
					listNodeMap.put(cnt, listNode);
					if (pre == null) {
						// 当前是最大的元素
						if (head != null) {
							listNode.next = head;
							head.pre = listNode;
						}
						head = listNode;
						if (tail == null) {
							tail = listNode;
						}
					} else {
						ListNode next = pre.next;
						if (next != null) {
							listNode.pre = pre;
							listNode.next = next;
							next.pre = listNode;
							pre.next = listNode;
						} else {
							listNode.pre = pre;
							listNode.next = null;
							pre.next = listNode;
							tail = listNode;
						}
					}
				}
				listNode.keys.add(key);
			}

			map.put(key, cnt);
		}

		/**
		 * Decrements an existing key by 1. If Key's value is 1, remove it from
		 * the data structure.
		 */
		public void dec(String key) {
			Integer cnt = map.get(key);
			if (cnt == null) {
				return;
			}
			ListNode listNode = listNodeMap.get(cnt);
			listNode.keys.remove(key);
			ListNode next = listNode.next;
			if (listNode.keys.size() <= 0)
				this.delListNode(listNode, cnt);
			cnt--;
			if (cnt == 0) {
				map.remove(key);
			} else {
				map.put(key, cnt);
			}
			if (cnt == 0) {
				return;
			}
			listNode = listNodeMap.get(cnt);
			if (listNode == null) {
				listNode = new ListNode();
				listNodeMap.put(cnt, listNode);
				if (next == null) {
					// 当前为最小的元素
					if (tail != null) {
						tail.next = listNode;
						listNode.pre = tail;
					}
					tail = listNode;
					if (head == null) {
						head = listNode;
					}
				} else {
					ListNode pre = next.pre;
					if (pre == null) {
						// 当前为最大的元素
						if (head != null) {
							head.pre = listNode;
							listNode.next = head;
						}
						head = listNode;
					} else {
						listNode.next = next;
						listNode.pre = pre;
						pre.next = listNode;
						next.pre = listNode;
					}
				}
			}
			listNode.keys.add(key);
		}

		/** Returns one of the keys with maximal value. */
		public String getMaxKey() {
			if (head == null) {
				return "";
			} else {
				return head.keys.toArray()[0].toString();
			}
		}

		/** Returns one of the keys with Minimal value. */
		public String getMinKey() {
			if (tail == null) {
				return "";
			} else {
				return tail.keys.toArray()[0].toString();
			}
		}
	}

	public static void main(String... strings) {
		AllOne q = new AllOne();

		/**
		 * ["AllOne","inc","inc","inc","inc","getMaxKey","inc","inc","inc","dec","inc","inc","inc","getMaxKey"]
		 * [[],["hello"],["goodbye"],["hello"],["hello"],[],["leet"],["code"],["leet"],["hello"],["leet"],["code"],["code"],[]]
		 */
		// q.inc("hello");
		// System.out.println(q.head);
		// q.inc("goodbye");
		// System.out.println(q.head);
		// q.inc("hello");
		// System.out.println(q.head);
		// q.inc("hello");
		// System.out.println(q.head);
		// System.out.println(q.getMaxKey());
		// q.inc("leet");
		// System.out.println(q.head);
		// q.inc("code");
		// System.out.println(q.head);
		// q.inc("leet");
		// System.out.println(q.head);
		// q.dec("hello");
		// System.out.println(q.head);
		// q.inc("leet");
		// System.out.println(q.head);
		// q.inc("code");
		// System.out.println(q.head);
		// q.inc("code");
		// System.out.println(q.head);
		// System.out.println(q.getMaxKey());
		q.inc("hello");
		q.inc("hello");
		System.out.println(q.getMaxKey());
		System.out.println(q.getMaxKey());
		q.inc("leet");
		System.out.println(q.getMinKey());
	}
}
