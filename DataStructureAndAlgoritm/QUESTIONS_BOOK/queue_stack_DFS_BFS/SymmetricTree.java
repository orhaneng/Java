/*https://leetcode.com/problems/symmetric-tree/
 * 101. Symmetric Tree
Easy

2060

45

Favorite

Share
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
 */
package queue_stack_DFS_BFS;

import java.util.ArrayList;
import java.util.List;

import queue_stack_DFS_BFS.LeafSimilarTrees.TreeNode;

public class SymmetricTree {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		//root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(3);
		//root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(3);
		System.out.println(isSymmetric(root));
	}
	
    public static boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        List<Integer> list1 =new ArrayList<Integer>();
        getList(root.left,list1,false);
        List<Integer> list2 =new ArrayList<Integer>();
        getList(root.right,list2,true);
        
        return list1.equals(list2);
    }
    
    private static void getList(TreeNode root,List<Integer> list, boolean flag){
        if(root==null) return;
        
        list.add(root.val);
        if(flag){
            if(root.right!=null) getList(root.right,list,flag);
            else list.add(null);
            if(root.left!=null) getList(root.left,list,flag); 
            else list.add(null);

        }else{
            if(root.left!=null) getList(root.left,list,flag); 
            else list.add(null);

            if(root.right!=null) getList(root.right,list,flag);
            else list.add(null);


        }

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
