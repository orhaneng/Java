/*
 * 700. Search in a Binary Search Tree
Easy

283

89

Favorite

Share
Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

For example, 

Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2
You should return this subtree:

      2     
     / \   
    1   3
In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.

Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
 */
package binarySearchTree;


public class SearchBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		TreeNode node = searchBST(root, 2);
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
    public static TreeNode searchBST(TreeNode root, int val) {
        
        if (root == null)
            return root;
        if (root.val == val)
            return root;
        else if (root.val > val)
            return searchBST(root.left, val);
        else if (root.val < val)
            return searchBST(root.right, val);
        return null;
    }
    /*
    public static TreeNode searchBST(TreeNode root, int val,boolean flag,TreeNode newnode) {
        if(root==null) return null;        
        if(root.val==val){
            flag=true;
        }
        if(flag){
            TreeNode node = new TreeNode(root.val);
            newnode.left=searchBST(root.left,val,flag,newnode);
            newnode.right=searchBST(root.right,val,flag,newnode);
        }else{
            searchBST(root.left,val,flag,newnode);
            searchBST(root.right,val,flag,newnode);
        }
        return newnode;
    }
    */
}
