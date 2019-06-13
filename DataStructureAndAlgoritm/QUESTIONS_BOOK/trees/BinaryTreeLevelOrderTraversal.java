/*
 * Binary Tree Level Order Traversal
  Go to Discuss
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

 */
package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binarySearchTree.BinaryTreePreorderTraversal.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		Solution sol=new Solution();
		System.out.println(sol.levelOrder(root));
	}
	/**
	 * Definition for a binary tree node.

	 */
	 static public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	static class Solution {
	    public List<List<Integer>> levelOrder(TreeNode root) {
	        List<List<Integer>> res= new ArrayList<List<Integer>>();
	        if(root==null) return res;
	        Queue<TreeNode> queue= new LinkedList<TreeNode>();
	        queue.add(new TreeNode(Integer.MAX_VALUE));
	        queue.add(root);
	        List<Integer> list = new ArrayList<Integer>();
	        while(!queue.isEmpty()){
	            TreeNode node=queue.poll();
	            if(node.val==Integer.MAX_VALUE){
	                res.add(list);
	                list=new ArrayList<Integer>();
	                queue.add(new TreeNode(Integer.MAX_VALUE));
	            }else{
		        list.add(node.val);
	            if(node.left!=null)
	            queue.add(node.left);
	            if(node.right!=null)
	            queue.add(node.right);
	            }
	        }
	        return res;
	    } 
	}

}
