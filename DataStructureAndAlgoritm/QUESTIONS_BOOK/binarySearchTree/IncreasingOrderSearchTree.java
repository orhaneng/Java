/*https://leetcode.com/problems/increasing-order-search-tree/
 * 897. Increasing Order Search Tree
Easy

228

266

Favorite

Share
Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

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
            \
             7
              \
               8
                \
                 9  

 */
package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

import binarySearchTree.SearchBinarySearchTree.TreeNode;

public class IncreasingOrderSearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);
		root.right.right = new TreeNode(8);
		root.right.right.left=new TreeNode(7);
		root.right.right.right=new TreeNode(9);

		TreeNode node = increasingBST(root);
	}
	
    public static TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList();
        inorder(root,vals);
        TreeNode ans=new TreeNode(0); 
        TreeNode cur=ans;
        for(int v:vals){
        cur.right= new TreeNode(v);
            cur=cur.right;
        }
        return ans.right;
    }
    
    public static void inorder(TreeNode node, List<Integer> vals){
        if(node ==null) return;
        inorder(node.left,vals);
        vals.add(node.val);
        inorder(node.right,vals);
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
