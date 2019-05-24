package homework7;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * File Name: GraphDijkstra.java Implements Dijkstra's algorithms
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

/*
 * To compile you require: IntUtil.java RandomInt.java Graph.java GraphTest.javs
 * GraphDijkstra.java
 */

class GraphDijkstra {
	// DATA GIVEN
	private String t; // Title
	private String dotFile; // Write tree as a dot file
	private Graph g;
	String start;
	String end;
	int[] work;
	double[] cost;
	int[] parent;
	int[] w;
	// boolean[] z;
	Set<Integer> z;
	PriorityQueue<Node> minheap;
	// DATA REQUIRED FOR WORK
	// You can have any number of private variables and classes

	GraphDijkstra(String t, String dotFile, Graph g, String start, String end, int[] work, double[] cost) {
		this.t = t;
		this.dotFile = dotFile;
		this.g = g;
		this.start = start;
		this.end = end;
		this.work = work;
		this.cost = cost;
		this.w = new int[g.getnumV()];
		this.z = new HashSet<Integer>();
		this.parent = new int[g.getnumV()];

		minheap = new PriorityQueue<Node>(g.getnumV(), new Node());
		// You can initialze your data structure here
		DijkstraAlg();
	}

	private void DijkstraAlg() {
		System.out.println("------------" + t + "-----------------");
		int n = g.getnumV();

		for (int i = 0; i < g.getnumV(); i++) {
			w[i] = Integer.MAX_VALUE;
			parent[i] = i;
		}
		printout(-1);
		int startingId = g.graphHasNode(start);
		w[startingId] = 0;
		minheap.add(new Node(startingId, 0));

		while (z.size() != g.getnumV()) {
			int node = minheap.remove().node;
			String p2 = g.getNodeRealName(node);
			z.add(node);
			int nf = g.numFanout(node);
			for (int j = 0; j < nf; j++) {
				int k = g.getNodeFanout(node, j);
				if (z.contains(k))
					continue;
				p2 = g.getNodeRealName(k);
				double newDistnance = g.getNodeFanoutEdgeWeight(node, j) + w[node];
				if (w[k] > newDistnance) {
					w[k] = (int) newDistnance;
					parent[k] = node;
				}

				minheap.add(new Node(k, w[k]));
			}
			printout(node);
		}

	}

	private void printout(int index) {
		if (index != -1) {
			String p2 = g.getNodeRealName(index);
			System.out.println("Working on Vertex:" + p2);
		}
		for (int i = 0; i < w.length; i++) {
			System.out.print(g.getNodeRealName(i) + "    ");
		}
		System.out.println();

		for (int i = 0; i < w.length; i++) {
			if (z.contains(i))
				System.out.print("T" + "    ");
			else
				System.out.print("F" + "    ");
		}

		System.out.println();
		for (double d : w) {
			System.out.print((((int) d) == Integer.MAX_VALUE ? "L" : d) + "  ");
		}
		System.out.println();
		for (int i = 0; i < parent.length; i++) {
			System.out.print(g.getNodeRealName(parent[i]) + "    ");
		}
		System.out.println();
	}

	class Node implements Comparator<Node> {
		public int node;
		public int cost;

		public Node() {
		}

		public Node(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compare(Node node1, Node node2) {
			if (node1.cost < node2.cost)
				return -1;
			if (node1.cost > node2.cost)
				return 1;
			return 0;
		}
	}

	public static void main(String[] args) {
		System.out.println("GraphDijkstra.java starts");
		System.out.println("Use GraphTest.java to test");
		System.out.println("GraphDijkstra.java Ends");
	}
}