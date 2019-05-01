package homework4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * File Name: GraphTopologicalSort.java 
 * Topological Sort on a Graph
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

/*
 * To compile you require: IntUtil.java RandomInt.java Graph.java GraphTest.javs GraphTopologicalSort.java
 */

class GraphTopologicalSort{
	private String t ;
	private Graph g ;
	//Output
	boolean [] cycle;
	int [] work ;
	int [] size ;
	int [] topoorder;
	//DATA REQUIRED FOR WORK
	//You can have any number of private variables and classes

	GraphTopologicalSort(String t, Graph g, boolean [] cycle, int [] work, int [] size, int [] topoorder) {
		this.t = t ;
		this.g = g ;
		this.cycle = cycle ;
		this.work = work ;
		this.size = size ;
		this.topoorder = topoorder ;
		//You can initialze your data structure here
		toposort() ;
	}

	private void toposort() {
		//WRITE CODE
		//YOU CAN HAVE ANY NUMBER OF private functions
	}


	public static void main(String[] args) {
		System.out.println("GraphTopologicalSort.java starts");
		System.out.println("Use GraphTester.java to test");
		System.out.println("GraphTopologicalSort.java Ends");
	}
}
