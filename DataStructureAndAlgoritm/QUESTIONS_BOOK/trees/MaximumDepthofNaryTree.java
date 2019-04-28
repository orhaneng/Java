/*
 * Maximum Depth of N-ary Tree
  Go to Discuss
Given a n-ary tree, find its maximum depth.
The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
For example, given a 3-ary tree:
We should return its max depth, which is 3.
Note:

The depth of the tree is at most 1000.
The total number of nodes is at most 5000.
 */
package trees;

import java.util.ArrayList;
import java.util.List;

import trees.NaryTreePreorderTraversal.Node;

public class MaximumDepthofNaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Node> nullchild = new ArrayList<NaryTreePreorderTraversal.Node>();
		List<Node> children = new ArrayList<NaryTreePreorderTraversal.Node>();
		children.add(new Node(5, nullchild));
		children.add(new Node(6, nullchild));
		Node node3 = new Node(2, children);
		List<Node> children1 = new ArrayList<NaryTreePreorderTraversal.Node>();
		children1.add(node3);
		children1.add(new Node(3, nullchild));
		children1.add(new Node(4, nullchild));
		Node root = new Node(44, nullchild);
		System.out.println(maxDepth(root));
	}

	public static int maxDepth(Node root) {

		return helper(root, 1);
	}

	
	static int maxdept = 0;
	public static int helper(Node root, int count) {
		if (root == null)
			return count;
		for (Node child : root.children) {
			if (child != null) {
				maxdept = Math.max(maxdept, helper(child, count + 1));
			}
		}
		return Math.max(count,maxdept);
	}

}
