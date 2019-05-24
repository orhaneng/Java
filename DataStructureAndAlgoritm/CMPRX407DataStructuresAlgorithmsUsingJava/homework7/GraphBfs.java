package homework7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * File Name: GraphBfs.java Breadth First Search on a graph
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

/*
 * To compile you require: IntUtil.java RandomInt.java Graph.java GraphTest.javs
 * GraphBfs.java
 */

class GraphBfs {
	private String t;
	private Graph g;
	String start;
	// Output
	private int[] work;
	private int[] size;
	private int[] bfsorder;
	private int[] bfspath;
	// You can have any number of private variables and classes

	GraphBfs(String t, Graph g, String start, int[] work, int[] size, int[] bfsorder, int[] bfspath) {
		this.t = t;
		this.g = g;
		this.start = start;
		this.work = work;
		this.size = size;
		this.bfsorder = bfsorder;
		this.bfspath = bfspath;
		// You can initialze your data structure here
		bfsAlg();
	}

	public class Node {
		int level;
		int from;

		public Node(int level, int from) {
			this.level = level;
			this.from = from;
		}
	}

	private void bfsAlg() {

		Node[] nodeList = new Node[g.getnumV()];

		for (int i = 0; i < nodeList.length; i++) {
			nodeList[i] = new Node(-1, -1);
		}
		int index = 0;
		int level = 0;
		int startingId = g.graphHasNode(start);
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(startingId);
		nodeList[startingId].from = startingId;
		nodeList[startingId].level = 0;
		while (!queue.isEmpty()) {
			int node = queue.poll();
			String name = g.getNodeRealName(node);
			bfsorder[index] = node;
			bfspath[index] = nodeList[node].from;
			int nf = g.numFanout(node);
			level++;
			index++;
			work[0]++;
			for (int j = 0; j < nf; j++) {
				work[0]++;
				int k = g.getNodeFanout(node, j);
				name = g.getNodeRealName(k);
				if (nodeList[k].level == -1) {
					nodeList[k].from = node;
					nodeList[k].level = level;
					queue.offer(k);
				}
			}
		}

		System.out.println("file:" + t);
		System.out.println("Num Vertices = " + g.getnumV());
		System.out.println("Num Edges = " + g.getnumE());
		System.out.println("Work = " + work[0]);
		System.out.print("bfsorder = ");
		for (int i = 0; i < bfsorder.length; i++) {
			System.out.print(g.getNodeRealName(bfsorder[i]) + " ");
		}
		System.out.println();
		System.out.print("bfspath = ");
		for (int i = 0; i < bfspath.length; i++) {
			System.out.print(g.getNodeRealName(bfspath[i]) + " ");
		}

		System.out.println();
		findPath();
	}

	private void findPath() {
		int start = bfsorder[0];

		for (int i = 0; i < bfsorder.length; i++) {
			System.out.print(g.getNodeRealName(start));
			helper(start, bfsorder[i]);
			System.out.println();
		}
	}

	private void helper(int start, int value) {
		if (value == start)
			return;
		int valueindex = -1;
		for (int i = 0; i < bfsorder.length; i++) {
			if (bfsorder[i] == value) {
				valueindex = i;
				break;
			}
		}
		helper(start, bfspath[valueindex]);
		System.out.print("->" + g.getNodeRealName(bfsorder[valueindex]));

	}

	public static void main(String[] args) {
		System.out.println("GraphBfs.java starts");
		System.out.println("Use GraphTest.java to test");
		System.out.println("GraphBfs.java Ends");
	}
}
