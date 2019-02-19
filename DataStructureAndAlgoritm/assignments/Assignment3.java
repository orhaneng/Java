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

Test Cases:
list             4  1  2  6  10   3 5
nexthighest      10 10 10 10 5    5 null
next higher      6  2  6  10 null 5 null 

Next Highest
	Time complexity:O(N2)(square)
	Space complexity:O(N)
Next Higher;
	Time complexity:O(N2)(square)
	Space complexity:O(1)

	
	
}
 */
class Node {
	Node next = null;
	Node nextHighest = null;
	Node nextHigher = null;

	int data;

	public Node(int data) {
		this.data = data;
	}
}
public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(4);
		root.next = new Node(1);
		root.next.next = new Node(2);
		root.next.next.next = new Node(6);
		root.next.next.next.next = new Node(10);
		root.next.next.next.next.next = new Node(3);
		root.next.next.next.next.next.next = new Node(5);

		// print(root);

		print(findHigher(root),"Higher");
		
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
					node.nextHighest = null;
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

	public static void print(Node node, String funct) {
		while (node != null) {
			System.out.println(node.data);
			if(funct== "Highest")
			System.out.println(node.nextHighest != null ? node.nextHighest.data : null);
			if(funct== "Higher")
			System.out.println(node.nextHigher != null ? node.nextHigher.data : null);
			System.out.println("--");
			node = node.next;
		}
	}

}


