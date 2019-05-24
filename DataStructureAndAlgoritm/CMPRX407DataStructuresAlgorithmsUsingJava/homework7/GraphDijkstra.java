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
		minheap = new PriorityQueue<Node>(g.getnumV(), new Node());
		// You can initialze your data structure here
		DijkstraAlg();
	}

	private void DijkstraAlg() {
		// WRITE CODE
		// YOU CAN HAVE ANY NUMBER OF private functions
		/*
		 * n = number_of_vertices w[n] = weight array initialized to infinite.
		 * w[startingpoint] = 0 ; z[n] = visited array initilalized to false do { v =
		 * get_a_vertex_that has_minimum_weight_and_not_visited (w[v] is minimum and
		 * z[v] is false) if (!v) DONE RETURN for_all_fanouts(v,f) { relax(v,f,w(v,f)) ;
		 * } z[v] = true ; //v is true }while(1)
		 */
		int n = g.getnumV();

		for (int i = 0; i < g.getnumV(); i++) {
			w[i] = Integer.MAX_VALUE;
			z.add(i);
		}
		int startingId = g.graphHasNode(start);
		w[startingId] = 0;
		minheap.add(new Node(startingId, 0));

		while (z.size() != g.getnumV()) {
			int node = minheap.remove().node;
			z.add(node);
			int nf = g.numFanout(node);
			for (int j = 0; j < nf; j++) {
				int k = g.getNodeFanout(node, j);
				double newDistnance = g.getNodeFanoutEdgeWeight(nf, k) + w[nf];
				if (w[k] > newDistnance) {
					w[k] = (int) newDistnance;
				}
				minheap.add(new Node(k, w[k]));
			}
		}

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