package com.skyline.leetcode.solution;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Trapping Rain Water
 * <p>
 * https://leetcode.com/problems/trapping-rain-water/
 *
 * @author jairus
 */
public class Q42 {

    // 一个考虑不全的解决方案
    // public int trap(int[] height) {
    // if (height == null || height.length <= 2) {
    // return 0;
    // }
    // int total = 0;
    // for (int i = 0; i < height.length;) {
    // int curHeight = height[i];
    // int j = i + 1;
    // int maxIndex = i;
    // int maxHeight = 0;
    // for (; j < height.length && height[j] < curHeight; j++) {
    // if (height[j] >= maxHeight) {
    // maxHeight = height[j];
    // maxIndex = j;
    // }
    // }
    // if (j < height.length) {
    // total += (j - i) * curHeight;
    // for (; i < j; i++) {
    // total -= height[i];
    // }
    // } else {
    // total += (maxIndex - i) * maxHeight;
    // for (i++; i <= maxIndex; i++) {
    // total -= height[i];
    // }
    // }
    // System.out.println(i +", "+total);
    // }
    // return total;
    // }

//	public int trap(int[] height) {
//		if (height == null || height.length <= 2) {
//			return 0;
//		}
//		int sum = 0;
//		Deque<Integer> stack = new LinkedList<>();
//		stack.push(0);
//		int curHeight = height[0];
//		for (int i = 1; i < height.length; i++) {
//			if (height[i] > height[i - 1]) {
//				while (!stack.isEmpty() && height[stack.peek()] <= height[i]) {
//					int index = stack.pop();
//					sum += (i - index - 1) * (height[index] - curHeight);
//					curHeight = height[index];
//				}
//				if (!stack.isEmpty()) {
//					int index = stack.peek();
//					sum += (i - index - 1) * (height[i] - curHeight);
//				}
//			} else {
//				curHeight = 0;
//			}
//			stack.push(i);
//		}
//		return sum;
//	}

    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int sum = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int curHeight = 0;
        for (int i = 1; i < height.length; i++) {
            int len = 0;
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                len = i - stack.peek() - 1;
                int preHeight = height[stack.pop()];
                sum += len * (preHeight - curHeight);
                curHeight = preHeight;
            }
            if(!stack.isEmpty()) {
                len = i - stack.peek() - 1;
                sum += len * (height[i] - curHeight);
            }
            curHeight = height[i];
            stack.push(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        Q42 q = new Q42();
        System.out.println(q.trap(height) == 6);

        int[] h1 = {4, 2, 3};
        System.out.println(q.trap(h1) == 1);

        int[] h2 = {5, 4, 1, 2};
        System.out.println(q.trap(h2) == 1);

        int[] h3 = {5, 4, 1, 1, 1, 2};
        System.out.println(q.trap(h3) == 3);

        int[] h4 = {5, 2, 1, 2, 1, 5};
        System.out.println(q.trap(h4) == 14);
    }

}
