/*https://leetcode.com/problems/univalued-binary-tree/
 * 965. Univalued Binary Tree
Easy

150

25

Favorite

Share
A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.

 

Example 1:


Input: [1,1,1,1,1,null,1]
Output: true
Example 2:


Input: [2,2,2,5,2]
Output: false
 

Note:


 */
package binarySearchTree;

import binarySearchTree.SearchBinarySearchTree.TreeNode;

public class UnivaluedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(1);
		root.right.right = new TreeNode(1);
		System.out.println(isUnivalTree(root));
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
    public static boolean isUnivalTree(TreeNode root) {
        if(root==null) return true;
        
        if(root.right!=null &&root.val!=root.right.val){
            return false;
        }
        if(root.left!=null &&root.val!=root.left.val){
            return false;
        }
        
        return isUnivalTree(root.left)&&isUnivalTree(root.right);
    }

}
