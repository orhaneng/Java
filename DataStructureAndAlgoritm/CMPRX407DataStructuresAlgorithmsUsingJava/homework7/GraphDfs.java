package homework7;

import java.awt.Color;
import java.util.ArrayList;

/**
 * File Name: GraphDfs.java Depth First Search on a graph
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

/*
 * To compile you require: IntUtil.java RandomInt.java Graph.java GraphTest.javs
 * GraphDfs.java
 */

class GraphDfs {
	private String t;
	private Graph g;
	String start;
	// Output
	boolean[] cycle;
	int[] work;
	int[] size;
	int[] dfsorder;

	enum Colors {
		RED, GREEN, BLUE;
	}

	// You can have any number of private variables
	// Data used to solve the problem

	GraphDfs(String t, Graph g, String start, boolean[] cycle, int[] work, int[] size, int[] dfsorder) {
		this.t = t;
		this.g = g;
		this.start = start;
		this.cycle = cycle;
		this.dfsorder = dfsorder;
		this.work = work;
		// You can have any number of private variables and classes
		// you have to create an array
		dfsAlg();
	}

	private void dfsAlg() {
		System.out.println(t);
		System.out.println("Num Vertices =" + g.getnumV());
		System.out.println("Num Edges =" + g.getnumE());

		String[] colorArr = new String[g.getnumV()];
		for (int i = 0; i < colorArr.length; i++) {
			colorArr[i] = Colors.GREEN.toString();
			dfsorder[i] = -1;
		}
		int startingId = g.graphHasNode(start);
		helper(colorArr, startingId);

		reverseArray(dfsorder);
		System.out.println("Work Done = " + work[0]);
		System.out.println("Has Cycle = " +cycle[0]);
		System.out.print("DFS topological order = ");
		for (int i = 0; i < dfsorder.length; i++) {
			System.out.print(g.getNodeRealName(dfsorder[i]) + " ");
		}
		System.out.println();

	}

	private void reverseArray(int[] arr) {
		int begin = 0;
		int end = arr.length - 1;
		while (begin < end) {
			int temp = arr[begin];
			arr[begin] = arr[end];
			arr[end] = temp;
			begin++;
			end--;
		}
	}

	private void helper(String[] colorArr, int nodeIndex) {
		if (colorArr[nodeIndex] == Colors.GREEN.toString()) {
			colorArr[nodeIndex] = Colors.BLUE.toString();
			int nf = g.numFanout(nodeIndex);
			for (int j = 0; j < nf; j++) {
				int k = g.getNodeFanout(nodeIndex, j);
				work[0] = work[0] + 1;
				helper(colorArr, k);
				work[0] = work[0] + 1;
			}
			for (int i = 0; i < dfsorder.length; i++) {
				if (dfsorder[i] == -1) {
					dfsorder[i] = nodeIndex;
					break;
				}
			}
			colorArr[nodeIndex] = Colors.RED.toString();
		} else if ((g.getType() == GraphTest.GraphType.UNDIRECTED
				|| g.getType() == GraphTest.GraphType.WEIGHTED_UNDIRECTED)) {
			if (g.getnumE() / 2 >= g.getnumV()) {
				cycle[0] = true;
			}

		} else if (colorArr[nodeIndex] == Colors.BLUE.toString() && (g.getType() == GraphTest.GraphType.DIRECTED
				|| g.getType() == GraphTest.GraphType.WEIGHTED_DIRECTED)) {

			cycle[0] = true;
			work[0] = work[0] - 1;
			return;
		} else if (colorArr[nodeIndex] == Colors.RED.toString()) {

		}
	}

	public static void main(String[] args) {
		System.out.println("GraphDfs.java starts");
		System.out.println("Use GraphTester.java to test");
		System.out.println("GraphDfs.java Ends");
	}
}