package trees;

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
