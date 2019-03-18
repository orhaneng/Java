package Recursion;
/*
 * Given a binary tree, find the length of the longest path where each node in the path 
 * has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges 
between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output:

2

https://leetcode.com/problems/longest-univalue-path/

did not pass the leetcode 
 */

public class LongestUnivaluePath {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		//root.left= new TreeNode(2);
		root.right= new TreeNode(2);
		//root.left.left = new TreeNode(1);
		//root.left.right = new TreeNode(1);
		//root.right.left= new TreeNode(5);
		
		System.out.println(helper(root, 0));
	}
	
	public static int helper(TreeNode root,int count) {
		TreeNode node = root;
		
		if(node== null) {
			return 0;
		}else if(node.left== null && node.right==null) {
			return count;
		}
		
		return Math.max(1+helper(root.left, count),1+helper(root.right, count));
	}

}

      


