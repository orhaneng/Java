/*https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 94. Binary Tree Inorder Traversal
Medium

1486

64

Favorite

Share
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
 */
package queue_stack_DFS_BFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import queue_stack_DFS_BFS.SameTree.TreeNode;

public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		//root.left.left = new TreeNode(3);
		//root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(3);
		//root.right.right = new TreeNode(3);
		
		System.out.println(inorderTraversal(root));
	}
	
	public static List<Integer> inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
	}
	

}
