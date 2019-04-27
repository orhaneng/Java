/*
 *   Delete Node in a BST
  Go to Discuss
Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.

One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

    5
   / \
  4   6
 /     \
2       7

Another valid answer is [5,2,6,null,4,null,7].

    5
   / \
  2   6
   \   \
    4   7
 */
package binarySearchTree;

import binarySearchTree.InsertintoBinarySearchTree.TreeNode;

public class DeleteNodeBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		deleteNode2(root, 3);
		
	}
	
    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val<key) {
        	deleteNode(root.left, key);
        }else if(root.val>key) {
        	deleteNode(root.right, key);
        }else {
        	if(root.left==null&&root.left==null) {
        		root=null;
        	}else if(root.right==null) {
        		root.left = root.left;
        	}else if(root.left==null) {
        		root = root.right;
        	}else {
        		int newData = getMin(root.right);
        		root.val= newData;
        		deleteNode(root.right,newData);
        	}
        }
        return root;
    }
    public static TreeNode deleteNode2(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode2(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode2(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode2(root.right, root.val);
        }
        return root;
    }

    private static TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
    public static int getMin(TreeNode root) {
    	if(root.left==null) {
    		return root.val;
    	}
    	return getMin(root.left);
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
