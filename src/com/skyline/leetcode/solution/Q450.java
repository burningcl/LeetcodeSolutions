package com.skyline.leetcode.solution;

import java.util.Stack;

/**
 * Delete Node in a BST
 * 
 * https://leetcode.com/problems/delete-node-in-a-bst/
 * 
 * @author jairus
 *
 */
public class Q450 {

	public TreeNode deleteNode(TreeNode root, int key) {
		TreeNode[] nodes = this.find(root, null, key);
		if (nodes == null) {
			return root;
		}
		TreeNode parent = nodes[0];
		TreeNode node = nodes[1];
		if (node.left == null && node.right == null) {
			if (parent == null) {
				return null;
			} else if (parent.left == node) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		} else if (node.left != null) {
			parent = node.left;
			TreeNode curNode = parent.right;
			if (curNode == null) {
				node.val = parent.val;
				node.left = parent.left;
				parent.left = null;
			} else {
				while (curNode.right != null) {
					parent = curNode;
					curNode = parent.right;
				}
				node.val = curNode.val;
				parent.right = curNode.left;
				curNode.left = null;
			}
		} else {
			parent = node.right;
			TreeNode curNode = parent.left;
			if (curNode == null) {
				node.val = parent.val;
				node.right = parent.right;
				parent.right = null;
			} else {
				while (curNode.left != null) {
					parent = curNode;
					curNode = parent.left;
				}
				node.val = curNode.val;
				parent.left = curNode.right;
				curNode.right = null;
			}
		}
		return root;
	}

	public TreeNode[] find(TreeNode root, TreeNode parent, int key) {
		if (root == null) {
			return null;
		} else if (root.val == key) {
			TreeNode[] nodes = new TreeNode[2];
			nodes[0] = parent;
			nodes[1] = root;
			return nodes;
		} else if (root.val < key) {
			return this.find(root.right, root, key);
		} else {
			return this.find(root.left, root, key);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
