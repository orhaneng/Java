/*https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 * 590. N-ary Tree Postorder Traversal
Easy

257

36

Favorite

Share
Given an n-ary tree, return the postorder traversal of its nodes' values.

For example, given a 3-ary tree:

 



 

Return its postorder traversal as: [5,6,3,2,4,1].

 
Note:

Recursive solution is trivial, could you do it iteratively?
 */
package binarySearchTree;

import java.util.ArrayList;
import java.util.List;

import binarySearchTree.PopulatingNextRightPointersEachNode.Node;

public class NaryTreePostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Node> children = new ArrayList<NaryTreePostorderTraversal.Node>();
		children.add(new Node(5,children));
		children.add(new Node(6,children));
		Node node3= new Node(3,children);
		List<Node> children1 = new ArrayList<NaryTreePostorderTraversal.Node>();
		children1.add(node3);
		children1.add(new Node(2,children));
		children1.add(new Node(4,children));
		Node root= new Node(1,children1);
		System.out.println(postorder(root));
	}

	public static List<Integer> postorder(Node root) {

		List<Integer> list = new ArrayList<Integer>();
		if (root == null)
			return list;
		/*
		 * Stack<Integer> stack =new Stack<Integer>(); Queue<Node> queue= new
		 * LinkedList<Node>(); queue.offer(root); stack.push(root.val);
		 * while(!queue.isEmpty()){ Node curr= queue.poll(); int size =
		 * curr.children.size(); for(int i=size-1;i>=0;i--){
		 * queue.offer(curr.children.get(i)); stack.push(curr.children.get(i).val); } }
		 * 
		 * while(!stack.isEmpty()){ list.add(stack.pop()); }
		 */

		postorder(root, list);
		return list;
	}

	public static void postorder(Node root, List<Integer> list) {
		if (root == null)
			return;
		int size = root.children.size();
		for (int i = 0; i < size; i++) {
			postorder(root.children.get(i));
			list.add(root.children.get(i).val);
		}
		list.add(root.val);

		return;
	}

	static class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

}
