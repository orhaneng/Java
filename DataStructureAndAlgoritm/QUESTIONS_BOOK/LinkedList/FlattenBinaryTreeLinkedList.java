/*
 * 114. Flatten Binary Tree to Linked List
Medium

1501

192

Favorite

Share
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

 */
package LinkedList;

public class FlattenBinaryTreeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node= new TreeNode(1);
		node.left=new TreeNode(2);
		node.right=new TreeNode(5);
		node.left.left=new TreeNode(3);
		node.left.right=new TreeNode(4);
		node.right.right=new TreeNode(6);
		Solution sol=new Solution();
		sol.flatten(node);
		node=node;
	}
	
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
	 public static class TreeNode {
		     int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
      } 
	static class Solution {
	    public void flatten(TreeNode root) {
	        if(root==null){
	            return;
	        }   
	        helper(root);
	        
	    }
	    public TreeNode helper(TreeNode node){
	        if(node==null){
	            return null;
	        }   
	        TreeNode left=helper(node.left);
	        TreeNode right=helper(node.right);
	        if(left!=null &&right!=null){
	            node.right=left;
	            TreeNode temp=node;
	            while(temp.right!=null) {
	            	temp=temp.right;
	            }
	            temp.right=right;
	        }else if(left ==null &&right!=null){
	            node.right=right;
	        }else if(left!=null &&right==null){
	            node.right=left;
	        }
	        node.left=null;
	        return node;
	    }
	    
	}

}
