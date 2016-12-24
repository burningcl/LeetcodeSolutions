package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * LFU Cache
 * 
 * https://leetcode.com/problems/lfu-cache/
 * 
 * @author jairus
 *
 */
public class Q460 {

	public static class LFUCache {

		/**
		 * Entry is the Node of DoubleLinkedList
		 * 
		 * @param <T>
		 */
		public class Entry<T> {

			public T data;

			public Entry<T> pre;

			public Entry<T> next;

			public Entry(T data) {
				this.data = data;
			}

		}

		public class MyList<T> {

			public Entry<T> head;

			public Entry<T> tail;

			public MyList() {
				head = new Entry<>(null);
				tail = new Entry<>(null);
				head.next = tail;
				tail.pre = head;
			}

			public boolean isEmpty() {
				return head.next == tail;
			}

			public Entry<T> addBefore(T data, Entry<T> nextEntry) {
				if (nextEntry == null || nextEntry == head) {
					return null;
				}
				Entry<T> dataEntry = new Entry<>(data);
				Entry<T> preEntry = nextEntry.pre;
				dataEntry.pre = preEntry;
				dataEntry.next = nextEntry;
				preEntry.next = dataEntry;
				nextEntry.pre = dataEntry;
				return dataEntry;
			}

			public void remove(Entry<T> entry) {
				if (entry == null || entry == head || entry == tail) {
					return;
				}
				Entry<T> pre = entry.pre;
				Entry<T> next = entry.next;
				pre.next = next;
				next.pre = pre;
				entry.pre = null;
				entry.next = null;
			}
			
		}

		public static final int IDX_KEY = 0;

		public static final int IDX_VAL = 1;

		/**
		 * 
		 */
		public class BaseCache {

			/**
			 * visit count
			 */
			public int vCnt;

			public MyList<int[]> list;

			public Map<Integer, Entry<int[]>> map;

			public BaseCache() {
				list = new MyList<>();
				map = new HashMap<>();
			}

			public int size() {
				return map.size();
			}

			public Entry<int[]> get(int key) {
				return map.get(key);
			}

			public void set(int key, int value) {
				int[] data = new int[2];
				data[IDX_KEY] = key;
				data[IDX_VAL] = value;
				Entry<int[]> entry = list.addBefore(data, list.tail);
				map.put(key, entry);
			}

			public void remove(int key) {
				Entry<int[]> entry = this.get(key);
				if (entry == null) {
					return;
				}
				map.remove(key);
				list.remove(entry);
			}
		}

		public MyList<BaseCache> list;

		public Map<Integer, Entry<BaseCache>> map;

		public int capacity;

		public int cnt;

		public LFUCache(int capacity) {
			this.list = new MyList<>();
			this.list.head.data = new BaseCache();
			this.list.head.data.vCnt = Integer.MIN_VALUE;
			this.list.tail.data = new BaseCache();
			this.list.tail.data.vCnt = Integer.MAX_VALUE;
			this.map = new HashMap<>();
			this.capacity = capacity;
		}

		public int get(int key) {
			Entry<BaseCache> cacheEntry = map.get(key);
			if (cacheEntry == null) {
				return -1;
			}
			BaseCache baseCache = cacheEntry.data;
			Entry<int[]> entry = baseCache.get(key);
			if (entry == null) {
				// this is an illegal status
				return -1;
			}
			int val = entry.data[IDX_VAL];
			int vCnt = baseCache.vCnt + 1;
			Entry<BaseCache> nextEntry = cacheEntry.next;
			Entry<BaseCache> newEntry = null;
			if (nextEntry.data.vCnt == vCnt) {
				nextEntry.data.set(key, val);
				newEntry = nextEntry;
			} else {
				BaseCache newtCache = new BaseCache();
				newtCache.vCnt = vCnt;
				newtCache.set(key, val);
				newEntry = list.addBefore(newtCache, nextEntry);
			}
			map.put(key, newEntry);
			cacheEntry.data.remove(key);
			if (cacheEntry.data.size() <= 0) {
				list.remove(cacheEntry);
			}
			return val;
		}

		public void set(int key, int value) {
			if (capacity <= 0) {
				return;
			}
			Entry<BaseCache> valEntry = map.get(key);
			if (valEntry == null) {
				if (cnt >= capacity) {
					Entry<BaseCache> firstCacheEntry = list.head.next;
					Entry<int[]> firstItemEntry = firstCacheEntry.data.list.head.next;
					int removeKey = firstItemEntry.data[IDX_KEY];
					firstCacheEntry.data.remove(removeKey);
					map.remove(removeKey);
					if (firstCacheEntry.data.size() <= 0) {
						list.remove(firstCacheEntry);
					}
					cnt--;
				}
				Entry<BaseCache> firstCacheEntry = list.head.next;
				if (firstCacheEntry.data.vCnt == 1) {
					firstCacheEntry.data.set(key, value);
					valEntry = firstCacheEntry;
				} else {
					BaseCache cache = new BaseCache();
					cache.vCnt = 1;
					cache.set(key, value);
					valEntry = list.addBefore(cache, firstCacheEntry);
				}
				map.put(key, valEntry);
				cnt++;
			} else {
				int vCnt = valEntry.data.vCnt + 1;
				valEntry.data.remove(key);
				Entry<BaseCache> nextEntry = valEntry.next;
				if (valEntry.data.size() <= 0) {
					list.remove(valEntry);
				}
				if (nextEntry.data.vCnt == vCnt) {
					nextEntry.data.set(key, value);
					valEntry = nextEntry;
				} else {
					BaseCache cache = new BaseCache();
					cache.vCnt = vCnt;
					cache.set(key, value);
					valEntry = list.addBefore(cache, nextEntry);
				}
				map.put(key, valEntry);
			}
		}
	}
	
	public static void main(String...strings){
		Q460.LFUCache cache=new 	Q460.LFUCache (2);
		cache.set(2, 1);
		System.out.println(cache.list);
		cache.set(2, 2);
	}

}
