package com.skyline.leetcode.solution;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder
 * -traversal/
 * 
 * @author jairus
 *
 */
public class Q105 {

	public TreeNode buildTree(int[] preorder, int preLow, int[] inorder, int inLow, int len) {
		if (len <= 0) {
			return null;
		}
		int rootVal = preorder[preLow];
		TreeNode root = new TreeNode(rootVal);
		int i = 0;
		for (; i < len && inLow + i < inorder.length; i++) {
			if (inorder[inLow + i] == rootVal) {
				break;
			}
		}
		int leftLen = i;
		root.left = this.buildTree(preorder, preLow + 1, inorder, inLow, leftLen);
		int rightLen = len - i - 1;
		root.right = this.buildTree(preorder, preLow + i + 1, inorder, inLow + i + 1, rightLen);
		return root;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || inorder == null || preorder.length != inorder.length) {
			return null;
		}
		return this.buildTree(preorder, 0, inorder, 0, preorder.length);
	}

	public static void main(String... strings) {
		Q105 q = new Q105();
		Q102 q102 = new Q102();

		int[] preorder = { 1 };
		int[] inorder = { 1 };
		System.out.println(q102.levelOrder(q.buildTree(preorder, inorder)));

		int[] preorder1 = { 1, 2 };
		int[] inorder1 = { 1, 2 };
		System.out.println(q102.levelOrder(q.buildTree(preorder1, inorder1)));

		int[] preorder2 = { 2, 1 };
		int[] inorder2 = { 1, 2 };
		System.out.println(q102.levelOrder(q.buildTree(preorder2, inorder2)));

		int[] preorder3 = { 2, 1, 3 };
		int[] inorder3 = { 1, 2, 3 };
		System.out.println(q102.levelOrder(q.buildTree(preorder3, inorder3)));

		int[] preorder4 = { 3, 2, 1, 6, 4, 5, 7 };
		int[] inorder4 = { 1, 2, 3, 4, 5, 6, 7 };
		System.out.println(q102.levelOrder(q.buildTree(preorder4, inorder4)));

		int[] preorder5 = {};
		int[] inorder5 = {};
		System.out.println(q102.levelOrder(q.buildTree(preorder5, inorder5)));
	}
}
