/*
 * 100. Same Tree
Easy

1063

32

Favorite

Share
Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false

 */
package queue_stack_DFS_BFS;

import java.util.ArrayList;
import java.util.List;

public class SameTree {
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
		TreeNode root1= new TreeNode(1);
		root1.left= new TreeNode(2);
		
		TreeNode root2= new TreeNode(1);
		root2.right= new TreeNode(2);
		
		System.out.println(isSameTree(root1, root2));
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (q == null || p == null) return true;
		if(q==null||p==null) return false;
		if(p.val==q.val) {
			return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);
		}
		return false;
	}

}
