package trees;

import trees.isBalanced.Node;

public class isFull {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(6);
		root.right.right.left = new Node(6);
		root.right.right.right = new Node(6);
		System.out.println(isFull(root));

	}

	public static boolean isFull(Node node) {
		if (node == null) {
			return true;
		}

		if ((node.right == null && node.left != null) || (node.right != null && node.left == null)) {
			return false;
		}

		return isFull(node.left) && isFull(node.right);
	}

	public static class Node {
		int data;
		Node right, left;

		public Node(int data) {
			this.data = data;
		}
	}

}
