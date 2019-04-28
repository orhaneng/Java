package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Node> nullchild  = new ArrayList<NaryTreePreorderTraversal.Node>();
		List<Node> children = new ArrayList<NaryTreePreorderTraversal.Node>();
		children.add(new Node(5, nullchild));
		children.add(new Node(6, nullchild));
		Node node3 = new Node(2, children);
		List<Node> children1 = new ArrayList<NaryTreePreorderTraversal.Node>();
		children1.add(node3);
		children1.add(new Node(3, nullchild));
		children1.add(new Node(4, nullchild));
		Node root = new Node(1, children1);
		System.out.println(preorderIterative(root));

	}
	static List<Integer> result = new ArrayList<Integer>();

	public static List<Integer> preorder(Node root) {
		if (root == null)
			return result;
		int size = root.children.size();
		result.add(root.val);
		for(int i=0;i<size;i++) {
			preorder(root.children.get(i));
		}
		return result;
	}
	
	public static List<Integer> preorderIterative(Node root){
		List<Integer> result = new ArrayList<Integer>();
		Stack<Node> stack = new Stack<Node>();
		if(root==null) return result;
		
		stack.push(root);
		
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			result.add(node.val);
			int size= node.children.size();
			for (int i = size-1; i >=0; i--) {
				stack.add(node.children.get(i));
			}
		}
		return result;
		
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
