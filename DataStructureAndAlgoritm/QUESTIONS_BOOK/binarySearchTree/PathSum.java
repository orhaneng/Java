/*
 *   Path Sum
  Go to Discuss
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
package binarySearchTree;

import binarySearchTree.BinaryTreePreorderTraversal.TreeNode;

public class PathSum {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		root.left.left.right = new TreeNode(7);
		root.left.left.left = new TreeNode(2);

		System.out.println(hasPathSum(root, 22));
	}

	public static boolean hasPathSum(TreeNode root, int sum) {
		return hasPath(root, sum);
	}

	public static boolean hasPath(TreeNode root, int sum) {
		sum = sum - root.val;
		if (sum == 0) {
			return true;
		}
		if (root == null)
			return false;
		if (root.left != null)

		{
			return hasPath(root.left, sum);
		}
		if (root.right != null) {
			return hasPath(root.right, sum);
		}
		return false;
	}

}
