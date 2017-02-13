package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

/**
 * LRU Cache
 * <p>
 * https://leetcode.com/problems/lru-cache/
 *
 * @author jairus
 */
public class Q146 {

//	public class LRUCache {
//
//		class ListNode {
//			ListNode pre;
//			ListNode next;
//			int key;
//			int value;
//
//			public ListNode(int key, int value) {
//				this.key = key;
//				this.value = value;
//			}
//		}
//
//		ListNode head;
//
//		ListNode tail;
//
//		Map<Integer, ListNode> map;
//
//		int capacity;
//
//		public LRUCache(int capacity) {
//			head = null;
//			tail = null;
//			map = new HashMap<>();
//			this.capacity = capacity;
//		}
//
//		public int get(int key) {
//			ListNode cur = map.get(key);
//			if (cur == null) {
//				return -1;
//			}
//			if (tail != cur) {
//				this.delNode(cur);
//				this.addNode(cur);
//			}
//			return cur.value;
//		}
//
//		public void set(int key, int value) {
//			ListNode cur = map.get(key);
//			if (cur != null) {
//				cur.value = value;
//				if (cur != tail) {
//					this.delNode(cur);
//					this.addNode(cur);
//				}
//			} else {
//				if (map.size() < capacity) {
//					cur = new ListNode(key, value);
//					this.addNode(cur);
//				} else {
//					cur = head;
//					map.remove(cur.key);
//					cur.key = key;
//					cur.value = value;
//					this.delNode(cur);
//					this.addNode(cur);
//				}
//				map.put(key, cur);
//			}
//		}
//
//		public void delNode(ListNode cur) {
//			if (cur == null) {
//				return;
//			}
//			ListNode pre = cur.pre;
//			ListNode next = cur.next;
//			if (head == cur) {
//				if (tail == cur) {
//					head = tail = null;
//				} else {
//					next.pre = null;
//					cur.next = null;
//					head = next;
//				}
//			} else if (tail == cur) {
//				pre.next = null;
//				cur.pre = null;
//				tail = pre;
//			} else {
//				pre.next = next;
//				next.pre = pre;
//				cur.next = null;
//				cur.pre = null;
//			}
//		}
//
//		public void addNode(ListNode cur) {
//			if (cur == null) {
//				return;
//			}
//			if (head == null) {
//				head = tail = cur;
//			} else {
//				tail.next = cur;
//				cur.pre = tail;
//				tail = cur;
//			}
//		}
//	}

    public class LRUCache {

        int capacity;

        LinkedHashMap<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new LinkedHashMap<Integer, Integer>() {
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    return size() > capacity;
                }
            };
        }

        public int get(int key) {
            Integer val = map.remove(key);
            if (val != null)
                map.put(key, val);
            return val == null ? -1 : val;
        }

        public void set(int key, int value) {
            map.remove(key);
            map.put(key, value);
        }
    }
}
