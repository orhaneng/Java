/*
 *   Construct Binary Tree from Inorder and Postorder Traversal
  Go to Discuss
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */
package binarySearchTree;

import java.util.HashMap;

public class ConstructBinaryTreeInorderPostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] inorder = { 9, 3, 15, 20, 7 };
		int[] postorder = { 9, 15, 7, 20, 3 };

		TreeNode res = buildTreePostIn(inorder, postorder);
		System.out.println(res);

	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length)
			return null;
		HashMap<Integer, Integer> map = new HashMap();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return buildBinaryTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
	}

	public static TreeNode buildBinaryTree(int[] inorder, int inorderStart, int inorderEnd, int[] postorder,
			int postorderStart, int postorderEnd, HashMap<Integer, Integer> map) {

		if (postorderStart > postorderEnd || inorderStart > inorderEnd)
			return null;

		TreeNode node = new TreeNode(postorder[postorderEnd]);
		int rootIndex = map.get(postorder[postorderEnd]);
		TreeNode leftChild = buildBinaryTree(inorder, inorderStart, rootIndex - 1, postorder, postorderStart,
				postorderStart + rootIndex - inorderStart - 1, map);
		TreeNode rightChild = buildBinaryTree(inorder, rootIndex + 1, inorderEnd, postorder,
				postorderStart + rootIndex - inorderStart, postorderEnd - 1, map);
		node.left = leftChild;
		node.right = rightChild;
		return node;

	}
}
