/*https://leetcode.com/problems/invert-binary-tree/
 * 226. Invert Binary Tree
Easy

1705

27

Favorite

Share
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
package trees;

import binarySearchTree.DeleteNodeBST.TreeNode;

public class InvertBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        if(root.left!=null||root.right!=null){
        TreeNode temp= root.right;
        root.right=root.left;
        root.left=temp;
        }
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}