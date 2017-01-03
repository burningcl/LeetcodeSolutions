package com.skyline.leetcode.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * LFUCache
 * 
 * https://leetcode.com/problems/lfu-cache/
 * 
 * @author jairus
 *
 */
public class Q460 {

	public class LFUCache {

		class ListNode<T> {
			T data;
			ListNode<T> pre;
			ListNode<T> next;
		}

		class Data {
			int level;
			int key;
			int value;
		}

		class LevelData {
			int level;
			ListNode<Data> first;
			ListNode<Data> last;
		}

		class MyList<T> {
			ListNode<T> head;
			ListNode<T> tail;

			public void del(ListNode<T> node) {

			}

			public void addAfter(ListNode<T> after, ListNode<T> node) {

			}

			public boolean isTail(ListNode<T> node) {
				return false;
			}

			public boolean isHead(ListNode<T> node) {
				return false;
			}
		}

		int capacity;

		MyList<Data> dataList;

		MyList<LevelData> levelList;

		Map<Integer, ListNode<Data>> dataMap;

		Map<Integer, ListNode<LevelData>> levelMap;

		public LFUCache(int capacity) {
			this.capacity = capacity;
			dataList = new MyList<>();
			levelList = new MyList<>();
			dataMap = new HashMap<>();
			levelMap = new HashMap<>();
		}

		public int get(int key) {
			ListNode<Data> listNode = dataMap.get(key);
			if (listNode == null) {
				return -1;
			}
			int level = listNode.data.level;
			ListNode<LevelData> levelNode = levelMap.get(level);
			ListNode<LevelData> preLevelNode = levelNode;
			if (levelNode.data.first == listNode) {
				if (levelNode.data.last == listNode) {
					preLevelNode = levelNode.pre;
					levelList.del(levelNode);
					levelMap.remove(level);
				} else {
					levelNode.data.first = listNode.next;
				}
			} else if (levelNode.data.last == listNode) {
				levelNode.data.last = listNode.pre;
			}
			dataList.del(listNode);
			listNode.data.level++;
			level++;
			levelNode = null;
			ListNode<LevelData> nextLevelNode = levelMap.get(level);
			if (nextLevelNode != null && nextLevelNode.data.level == level) {
				dataList.addAfter(nextLevelNode.data.last, listNode);
				nextLevelNode.data.last = listNode;
			} else {
				dataList.addAfter(preLevelNode.data.last, listNode);
				levelNode = new ListNode<>();
				LevelData levelData = new LevelData();
				levelData.level = level;
				levelData.first = levelData.last = listNode;
				levelNode.data = levelData;
				levelMap.put(level, levelNode);
				levelList.addAfter(preLevelNode, levelNode);
			}
			return listNode.data.value;

		}

		public void set(int key, int value) {
			ListNode<Data> listNode = dataMap.get(key);
			if (listNode == null) {
				listNode = new ListNode<>();
				Data data = new Data();
				data.key = key;
				data.level = 0;
				data.value = value;
				listNode.data = data;
				if (dataMap.size() < capacity) {
					ListNode<LevelData> levelNode = levelMap.get(0);
					if (levelNode == null) {
						levelNode = new ListNode<LevelData>();
						LevelData levelData = new LevelData();
						levelData.first = listNode;
						levelData.last = listNode;
						levelData.level = 0;
						levelNode.data = levelData;
						levelList.addAfter(null, levelNode);
						levelMap.put(0, levelNode);
						dataList.addAfter(null, listNode);
						dataMap.put(key, listNode);
					} else {
						dataList.addAfter(levelNode.data.last, listNode);
						dataMap.put(key, listNode);
						levelNode.data.last = listNode;
					}
				} else {
					
				}
			} else {

			}
		}

	}

}
