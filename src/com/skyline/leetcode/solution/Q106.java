package com.skyline.leetcode.solution;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-
 * postorder-traversal/
 * 
 * @author jairus
 *
 */
public class Q106 {

	public TreeNode buildTree(int[] inorder, int inStart, int[] postorder, int postStart, int len) {
		if (len <= 0) {
			return null;
		}
		int rootVal = postorder[postStart + len - 1];
		TreeNode root = new TreeNode(rootVal);
		int i = 0;
		for (; i < len; i++) {
			if (inorder[inStart + i] == rootVal) {
				break;
			}
		}
		root.left = this.buildTree(inorder, inStart, postorder, postStart, i);
		root.right = this.buildTree(inorder, inStart + i + 1, postorder, postStart + i, len - i - 1);
		return root;
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length) {
			return null;
		}
		return this.buildTree(inorder, 0, postorder, 0, inorder.length);
	}

	public static void main(String... strings) {
		Q106 q = new Q106();
		Q102 q102 = new Q102();

		int[] inorder = { 1 };
		int[] postorder = { 1 };
		System.out.println(q102.levelOrder(q.buildTree(inorder, postorder)));

		int[] inorder1 = { 1, 2 };
		int[] postorder1 = { 1, 2 };
		System.out.println(q102.levelOrder(q.buildTree(inorder1, postorder1)));

		int[] inorder2 = { 2, 1 };
		int[] postorder2 = { 1, 2 };
		System.out.println(q102.levelOrder(q.buildTree(inorder2, postorder2)));

		int[] inorder3 = { 2, 1, 3 };
		int[] postorder3 = { 2, 3, 1 };
		System.out.println(q102.levelOrder(q.buildTree(inorder3, postorder3)));

		int[] inorder4 = { 1, 2, 3, 4, 5, 6, 7 };
		int[] postorder4 = { 1, 2, 5, 4, 7, 6, 3 };
		System.out.println(q102.levelOrder(q.buildTree(inorder4, postorder4)));
		//
		int[] inorder5 = {};
		int[] postorder5 = {};
		System.out.println(q102.levelOrder(q.buildTree(inorder5, postorder5)));
	}

}
