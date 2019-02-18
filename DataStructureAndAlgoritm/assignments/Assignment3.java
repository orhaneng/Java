import java.sql.Struct;

/*
 * InClass Exercise 3
Given a singly linked list with nodes with the following structure: Struct node_t {
Struct node_t * next;
Struct node_t next_highest; Int val;
}
Write a function that takes a single linked list of nodes with next_highest initially 
null and sets that pointer to point to the next node with the highest val following that 
node in the current list.
Repeat the problem above but now making the extra pointer point to next higher: 
Given a singly linked list with nodes with the following structure:
Struct node_t {
 }
Struct node_t * next;
Struct node_t next_highest; Int val;

Repeat the problem above but now making the extra pointer point to next higher:
Given a singly linked list with nodes with the following structure:
Struct node_t {
Struct node_t * next;
Struct node_t next_highest;
Int val;
}
 */
public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(3);
		root.next = new Node(1);
		root.next.next = new Node(10);
		root.next.next.next = new Node(2);
		root.next.next.next.next = new Node(5);

		// print(root);

		print(findHigher(root));
	}

	public static Node findHighestinNext(Node node) {
		Node highest = new Node(node.data);
		while (node != null) {
			if (node.data > highest.data) {
				highest.data = node.data;
			}
			node = node.next;
		}
		return highest;
	}

	public static Node findHighest(Node root) {
		Node node = root;
		Node currentHighest = findHighestinNext(node);
		node.nextHighest = currentHighest;
		while (node != null) {
			if (node.data >= currentHighest.data) {
				if (node.next == null) {
					node.nextHighest = currentHighest;
					return root;
				} else {
					currentHighest = findHighestinNext(node.next);
				}
			}
			node.nextHighest = currentHighest;
			node = node.next;
		}

		return root;
	}

	public static Node findHigher(Node root) {
		Node node = root;
		Node higher = null;
		while (node != null) {
			Node runner = node;
			higher= null;
			while (runner != null) {
				if (node.data < runner.data) {
					higher = runner;
					break;
				}
				runner = runner.next;
			}
			node.nextHigher = higher;
			node = node.next;
		}
		return root;
	}

	public static void print(Node node) {
		while (node != null) {
			System.out.println(node.data);
			System.out.println(node.nextHighest != null ? node.nextHighest.data : "");
			System.out.println(node.nextHigher != null ? node.nextHigher.data : "");
			System.out.println("--");
			node = node.next;
		}
	}

}

class Node {
	Node next = null;
	Node nextHighest = null;
	Node nextHigher = null;

	int data;

	public Node(int data) {
		this.data = data;
	}
}