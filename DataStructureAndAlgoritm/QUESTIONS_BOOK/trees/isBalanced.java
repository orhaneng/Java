package trees;
/*
 * How to determine if a binary tree is height-balanced?
A tree where no leaf is much farther away from the root than any other leaf. 
Different balancing schemes allow different definitions of “much farther” and 
different amounts of work to keep them balanced.
Consider a height-balancing scheme where following conditions should be checked
 to determine if a binary tree is balanced.
An empty tree is height-balanced. A non-empty binary tree T is balanced if:
1) Left subtree of T is balanced
2) Right subtree of T is balanced
3) The difference between heights of left subtree and right subtree is not more than 1.

The above height-balancing scheme is used in AVL trees. The diagram below shows two trees, 
one of them is height-balanced and other is not. The second tree is not height-balanced 
because height of left subtree is 2 more than height of right subtree.
 */

public class isBalanced {

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.left.left = new Node(6);
		root.right.left.left.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(isBalanced(root));
	}
	
	public static boolean isBalanced(Node root) {
		if(root == null) return true;
		if( Math.abs(height(root.left) - height(root.right))>1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
		
	}
	public static int height(Node node){
		if(node==null)return 0;
		return 1+Math.max(height(node.left), height(node.right));
	}
	public static class Node {
		int value;
		Node left, right;

		public Node(int value) {
			this.value = value;
		}
	}

}
