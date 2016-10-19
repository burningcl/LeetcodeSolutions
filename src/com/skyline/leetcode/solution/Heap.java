package com.skyline.leetcode.solution;

public class Heap {
	protected int[] array = null;

	protected int size;

	public Heap(int max) {
		array = new int[max];
		size = 0;
	}

	private void swap(int i, int j) {
		if (i < 0 || j < 0) {
			return;
		}
		array[i] = array[i] ^ array[j];
		array[j] = array[i] ^ array[j];
		array[i] = array[i] ^ array[j];
	}

	public void inset(int val) {
		int index = size++;
		array[index] = val;
		shiftUp(index);
	}

	protected void shiftUp(int index) {
		while (index > 0) {
			int pIndex = (index - 1) / 2;
			if (array[pIndex] > array[index]) {
				swap(pIndex, index);
				index = pIndex;
			} else {
				break;
			}
		}
	}

	protected int shiftDown(int index) {
		while (index < size) {
			int lIndex = index * 2 + 1;
			int rIndex = index * 2 + 2;
			int sIndex = -1;
			if (lIndex < size && rIndex < size) {
				sIndex = array[lIndex] < array[rIndex] ? lIndex : rIndex;
			} else if (lIndex < size) {
				sIndex = lIndex;
			} else if (rIndex < size) {
				sIndex = rIndex;
			} else {
				break;
			}
			array[index] = array[sIndex];
			index = sIndex;
		}
		return index;
	}

	public int peek() {
		int index = 0;
		int val = array[index];
		index = shiftDown(index);
		swap(index, size - 1);
		shiftUp(index);
		size--;
		return val;
	}

	public static void main(String... strings) {
		int[] array = { -3, 2, 2, -9, -10, -5, -4, -2, -1, 1, 3, 4, -10, -9, -8, 3, 4, -5, -3, 3, 4, -9, -8, -5, -4, -2,
				-1, 3 };
		Heap heap = new Heap(array.length);
		for (int num : array) {
			heap.inset(num);
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(heap.peek());
		}
	}
}