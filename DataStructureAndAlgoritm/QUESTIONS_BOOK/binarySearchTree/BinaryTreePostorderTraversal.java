/*
 *   Binary Tree Postorder Traversal
  Go to Discuss
Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
Follow up: Recursive solution is trivial, could you do it iteratively?


 */
package binarySearchTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import binarySearchTree.BinaryTreeInorderTraversal.TreeNode;

public class BinaryTreePostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		System.out.println(postorderTraversal(root));

	}
	

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public static List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> ans = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		if (root == null) return ans;
		
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			ans.addFirst(cur.val);
			if (cur.left != null) {
				stack.push(cur.left);
			}
			if (cur.right != null) {
				stack.push(cur.right);
			} 
		}
		return ans;
	}
}
