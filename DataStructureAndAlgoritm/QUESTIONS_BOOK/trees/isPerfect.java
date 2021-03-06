package trees;
/*
 * 
 * Check whether a given binary tree is perfect or not
Given a Binary Tree, write a function to check whether the given 
Binary Tree is a prefect Binary Tree or not.

A Binary tree is Perfect Binary Tree in which all internal nodes have two 
children and all leaves are at same level.

Examples:
The following tree is a perfect binary tree

               10
           /       \  
         20         30  
        /  \        /  \
      40    50    60   70


               18
           /       \  
         15         30  
The following tree is not a perfect binary tree

      1
    /    \
   2       3
    \     /  \   
     4   5    6

 */

import trees.isFull.Node;

public class isPerfect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		int dept = 1;
		System.out.println(isPerfect(root, dept, getDept(root)));
		*/
		
	    Node root = null;  
	    root = new Node(10);  
	    root.left = new Node(20);  
	    root.right = new Node(30);  
	  
	    root.left.left = new Node(40);  
	    root.left.right = new Node(50);  
	    root.right.left = new Node(60);  
	    root.right.right = new Node(70);  
	    int dept = 1;
	    
	    if (isPerfect(root, dept, getDept(root)) == true)  
	        System.out.println("Yes");  
	    else
	        System.out.println("No"); 
	}

	public static int getDept(Node node) {
		if (node == null) {
			return 0;
		}
		return 1 + getDept(node.left);
	}

	public static boolean isPerfect(Node node, int dept, int realdept) {
		if (node == null) {
			return true;
		}
		if ((node.left == null || node.right == null) && dept != realdept) {
			System.out.println(dept);
			return false;
		}
		return isPerfect(node.left, dept + 1, realdept) && isPerfect(node.right, dept + 1, realdept);
	}

	public static class Node {
		int data;
		Node right, left;

		public Node(int data) {
			this.data = data;
		}
	}

}
