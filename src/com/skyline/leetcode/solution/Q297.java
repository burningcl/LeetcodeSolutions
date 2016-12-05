package com.skyline.leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Serialize and Deserialize Binary Tree
 * 
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * 
 * @author jairus
 *
 */
public class Q297 {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root == null) {
			return "[]";
		}

		List<TreeNode> list = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int end = 0;
		int index = 0;
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			list.add(cur);
			index++;
			if (cur != null) {
				queue.add(cur.left);
				queue.add(cur.right);
				end = index;
			} 
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < end; i++) {
			TreeNode t = list.get(i);
			if (t == null) {
				sb.append("null");
			} else {
				sb.append(t.val);
			}
			if (i < end - 1) {
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.length() <= 2) {
			return null;
		}
		TreeNode root = null;
		String[] vals = data.substring(1, data.length() - 1).split(",");
		if (vals == null || vals.length <= 0) {
			return root;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		int curNodeSonCnt = 0;
		TreeNode curNode = null;
		for (int i = 0; i < vals.length; i++) {
			String val = vals[i];
			TreeNode curSon = null;
			if (!val.equals("null")) {
				int valInt = Integer.valueOf(val);
				curSon = new TreeNode(valInt);
			}
			if(curSon!=null){
				queue.add(curSon);
			}
			if (root == null) {
				root = curSon;
				curNode = curSon;
				continue;
			}
			if(curNodeSonCnt%2==0){
				curNode=queue.poll();
				curNodeSonCnt=0;
			}
			if(curNodeSonCnt==0){
				curNode.left=curSon;
			}else{
				curNode.right=curSon;
			}
			curNodeSonCnt++;
		}
		return root;
	}

	public static void main(String[] args) {
		Q297 q=new Q297();
		
		System.out.println(q.serialize(q.deserialize("[1,2,3,null,null,4,5]")));
		System.out.println(q.serialize(q.deserialize("[1]")));
		System.out.println(q.serialize(q.deserialize("[1,2]")));
		System.out.println(q.serialize(q.deserialize("[1,2,null,3,null,4]")));
		System.out.println(q.serialize(q.deserialize("[1,null,2]")));
		System.out.println(q.serialize(q.deserialize("[1,null,2,null,3,null,4]")));
		System.out.println(q.serialize(q.deserialize("[1,2,3,null,null,4,5,6,7,8,9,10,null,11,12,13,null,null,null,14,15,16,null,17,null,null,18,19,null,null,20]")));
	}

}
