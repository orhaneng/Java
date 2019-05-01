package homework4;

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

		String[] colorArr = new String[g.getnumV()];
		for (int i = 0; i < colorArr.length; i++) {
			colorArr[i] = Colors.GREEN.toString();
		}
		int startingId = g.graphHasNode(start);
		helper(colorArr, startingId);

		reverseArray(dfsorder);

		for (int i = 0; i < dfsorder.length; i++) {
			System.out.print(g.getNodeRealName(dfsorder[i])+"-");
		}
		System.out.println();
		System.out.println("workdone"+work[0]);


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
				String name = g.getNodeRealName(k);
				work[0] = work[0] + 1;
				helper(colorArr, k);
				work[0] = work[0] + 1;
			}
			for (int i = 0; i < dfsorder.length; i++) {
				if (dfsorder[i] == 0) {
					dfsorder[i] = nodeIndex;
					break;
				}
			}
			colorArr[nodeIndex] = Colors.RED.toString();
		} else if (colorArr[nodeIndex] == Colors.BLUE.toString()) {
			cycle[0]=true;
			System.out.println("cycle");
			work[0] = work[0] - 1;

			return;
		} else if (colorArr[nodeIndex] == Colors.RED.toString()) {

		}
		
		//0-1-6-4-3-5-2-
		//0-2-5-6-1-4-2
	}
	
	private int controlUnvisitedV(int k, String[] colorArr) {
		int nf = g.numFanout(k);
		for (int j = 0; j < nf; j++) {
			int index = g.getNodeFanout(k, j);
				int fin = g.numFanin(index);
				for (int i = 0; i < fin; i++) {
					if(colorArr[g.getNodeFanin(index, i)]==Colors.BLUE.toString()) {
						return g.getNodeFanin(index, i);
					}
				}
		}
		return -1;
		
	}

	public static void main(String[] args) {
		System.out.println("GraphDfs.java starts");
		System.out.println("Use GraphTester.java to test");
		System.out.println("GraphDfs.java Ends");
	}
}