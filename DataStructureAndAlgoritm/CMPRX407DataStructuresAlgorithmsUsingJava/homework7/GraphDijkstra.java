package homework7;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
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
	double[] w;
	int heapCount=0;
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
		this.w = new double[g.getnumV()];
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
		String p2 = g.getNodeRealName(startingId);
		minheap.add(new Node(startingId, 0, p2));
		heapCount++;
		work[0]++;
		while (z.size() != g.getnumV()) {
			int node = minheap.remove().node;
			p2 = g.getNodeRealName(node);
			if (z.contains(node))
				continue;
			z.add(node); 
			int nf = g.numFanout(node);
			for (int j = 0; j < nf; j++) {
				int k = g.getNodeFanout(node, j);
				p2 = g.getNodeRealName(k);
				if (z.contains(k))
					continue;
				work[0]++;
				double newDistnance = g.getNodeFanoutEdgeWeight(node, j) + w[node];
				if (w[k] > newDistnance) {
					w[k] = (int) newDistnance;
					parent[k] = node;
				}
				minheap.add(new Node(k, w[k], p2));
				heapCount++;
			}
			printout(node);
		}
		findPath();
		printSummary();
		g.writeDotDijkstra(dotFile + ".dot",w);


	}
	
	private void printSummary() {
		System.err.println(g.getGraphType());
		System.err.println("Num Vertices = "+g.getnumV());
		System.err.println("Num Edges = "+g.getnumE());
		System.err.println("Work done = "+work[0]);
		System.err.println("numberofNodeAddedToHeap = "+heapCount);
		int startingId = g.graphHasNode(end);

		System.err.println("Shortest path from city "+start+" to city "+end+" = "+w[startingId]);

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

	private void findPath() {
		int startindex = parent[g.graphHasNode(start)];

		for (int i = 0; i < w.length; i++) {
			int startingId = g.graphHasNode(start);
			if (startingId == i)
				continue;
			String text = "The best way to go from " + start + " to city " + g.getNodeRealName(i) + " is follows";
			System.out.println(text);
			System.out.print(g.getNodeRealName(startindex));
			helper(startindex, i);
			System.out.print(" Cost = ");
			helperCost(startindex, i, w[i]);
			System.out.println(" = " + w[i]);
			System.out.println();
		}
	}

	private void helper(int start, int value) {
		if (value == start)
			return;
		int valueindex = -1;
		for (int i = 0; i < w.length; i++) {
			if (i == value) {
				valueindex = i;
				break;
			}
		}
		helper(start, parent[valueindex]);
		System.out.print("->" + g.getNodeRealName(value));

	}

	private void helperCost(int start, int value, double totalCost) {
		if (totalCost == 0) {
			return;
		}
		int valueindex = -1;
		String p2 = g.getNodeRealName(value);
		for (int i = 0; i < w.length; i++) {
			if (i == value) {
				valueindex = i;
				break;
			}
		}
		double cost = totalCost - w[parent[valueindex]];
		helperCost(start, parent[valueindex], totalCost - cost);
		if (w[parent[valueindex]] == 0)
			System.out.print(cost);
		else
			System.out.print(" + " + cost);

	}

	class Node implements Comparator<Node> {
		public int node;
		public double cost;
		public String name;

		public Node() {
		}

		public Node(int node, double cost, String name) {
			this.node = node;
			this.cost = cost;
			this.name = name;
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