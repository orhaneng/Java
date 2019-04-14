package queue_stack_DFS_BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthofNaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
	};

	public static int maxDepth(Node root) {
		if (root == null)
			return 0;
		int maxdept = 0;
		for (Node child : root.children) {
			if (child != null) {
				maxdept = Math.max(maxdept, maxDepth(child));
			}
		}
		return maxdept + 1;
	}

	public static int maxDepthBTH(Node root) {
		if (root == null)
			return 0;
		Node node = root;
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(node);
		int dept = 0;

		while (!queue.isEmpty()) {
			dept++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Node poll= queue.poll();
				if(poll!=null) {
					for(Node child:poll.children) {
						queue.add(child);
					}
				}
			}
		}
		return dept;
	}
}
