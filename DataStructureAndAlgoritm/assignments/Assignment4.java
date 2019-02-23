/*
 * Create a function that flattens a binary tree into a double linked list, 
 * Use the left and right pointers as next and previous pointers respectively. 
 * The function must return the head of the list.
 * 
 */
public class Assignment4 {
	BinaryNode doublyLinkList;
	static BinaryNode prev = null;
	static BinaryNode head;
	static BinaryNode root;

	public static void main(String[] args) {
		BinaryNode root = new BinaryNode(10);
		root.left = new BinaryNode(12);
		root.right = new BinaryNode(15);
		root.left.left = new BinaryNode(25);
		root.left.right = new BinaryNode(30);
		root.right.left = new BinaryNode(36);
		inOrderTraversal(root);
		printThreenode(head);
		

	}

	public static void inOrderTraversal(BinaryNode root) {
		if (root == null)
			return;

		inOrderTraversal(root.left);
		if (prev == null)
			head = root;
		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		inOrderTraversal(root.right);

	}

	public static void printThreenode(BinaryNode node) {
        while (node != null)  
        { 
            System.out.print(node.data + " "); 
            node = node.right; 
        } 
	}
}

class BinaryNode {
	int data;
	BinaryNode left;
	BinaryNode right;

	public BinaryNode(int data) {
		this.data = data;
	}
}
