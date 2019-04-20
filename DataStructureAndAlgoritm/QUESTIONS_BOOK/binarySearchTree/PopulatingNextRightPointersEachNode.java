/*
 * 116. Populating Next Right Pointers in Each Node
Medium
947
79
Favorite
Share
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
Example:
Input: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":{"$id":"6","left":null,"next":null,"right":null,"val":6},"next":null,"right":{"$id":"7","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
Output: {"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":{"$id":"6","left":null,"next":null,"right":null,"val":7},"right":null,"val":6},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"7","left":{"$ref":"5"},"next":null,"right":{"$ref":"6"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"7"},"val":1}
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B.
 */
package binarySearchTree;

public class PopulatingNextRightPointersEachNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root= new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left= new Node(4);
		root.left.right= new Node(5);
		root.right.left= new Node(6);
		root.right.right= new Node(7);	
		connect(root);


	}
	static class Node {
		  int val;
		  Node left;
		  Node right;
		  Node next;
		  public Node(int val) {
			  this.val=val;
		  }
		}
	

	public static void connect(Node root) {
		Node level_start = root;
		while (level_start != null) {
			Node cur = level_start;
			while (cur != null) {
				if (cur.left != null)
					cur.left.next = cur.right;
				if (cur.right != null && cur.next != null)
					cur.right.next = cur.next.left;

				cur = cur.next;
			}
			level_start = level_start.left;
		}
	}

}
