/*
 *  Insert into a Binary Search Tree
  Go to Discuss
Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

For example, 

Given the tree:
        4
       / \
      2   7
     / \
    1   3
And the value to insert: 5
You can return this binary search tree:

         4
       /   \
      2     7
     / \   /
    1   3 5
This tree is also valid:

         5
       /   \
      2     7
     / \   
    1   3
         \
          4
 */
package binarySearchTree;

import binarySearchTree.BinarySearchTreeIterator.TreeNode;

public class InsertintoBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		TreeNode res = insertIntoBST(root, 5);
		System.out.println(res);

	}

	public static TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        if(val<root.val){
            if(root.left==null){
                root.left = new TreeNode(val);
                return root;
            }
            insertIntoBST(root.left,val);
        }
        if(val>root.val){
            if(root.right==null){
                root.right= new TreeNode(val);
            }
            insertIntoBST(root.right,val);
        }
        return root;
	}

	public static TreeNode insertIntoBST2(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (root.val > val) {
			root.left = insertIntoBST2(root.left, val);
		} else {
			root.right = insertIntoBST2(root.right, val);
		}
		return root;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

}
