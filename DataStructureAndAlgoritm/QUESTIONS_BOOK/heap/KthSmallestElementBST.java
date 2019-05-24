/*
 * 230. Kth Smallest Element in a BST
Medium

1109

39

Favorite

Share
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
 */
package heap;

import java.util.PriorityQueue;

import binarySearchTree.BinaryTreePostorderTraversal.TreeNode;

public class KthSmallestElementBST {

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
		Solution sol = new Solution();
		TreeNode root = new TreeNode(1);
		//root.left = new TreeNode();
		root.right = new TreeNode(2);
		//root.left.left = new TreeNode(2);
		//root.left.right = new TreeNode(4);
		//root.left.left.left = new TreeNode(1);

		System.out.println(sol.kthSmallest(root, 2));
	}

	static class Solution {
		public int kthSmallest(TreeNode root, int k) {
			PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
			help(root, k, queue);
			return queue.isEmpty()?root.val:queue.peek();
		}

		public void help(TreeNode root, int k, PriorityQueue<Integer> queue) {
			if (root == null)
				return;
			queue.add(root.val);
			if (queue.size() > k) {
				queue.poll();
			}
			help(root.left, k, queue);
			help(root.right, k, queue);
		}
	}

}
