package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		tryna(root);
		root=root;

	}
	
	public static void tryna(TreeNode root) {
		root.left =root.left.left;
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		if (root == null)
			return null;
		List<Integer> list = new ArrayList<Integer>();
		preorder(root, list);
		return list;
	}

	public static void preorder(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		list.add(root.val);
		preorder(root.left,list);
		preorder(root.right,list);
	}
}
