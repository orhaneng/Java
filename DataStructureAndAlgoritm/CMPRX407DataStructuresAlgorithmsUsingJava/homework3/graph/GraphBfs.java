package homework3.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * File Name: GraphBfs.java 
 * Breadth First Search on a graph
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

/*
 * To compile you require: IntUtil.java RandomInt.java Graph.java GraphTest.javs GraphBfs.java
 */

class GraphBfs{
	private String t ;
	private Graph g ;
	String start;
	//Output
	private int [] work ;
	private int [] size ;
	private int [] bfsorder;
	private int [] bfspath ;
	//You can have any number of private variables and classes


	GraphBfs(String t, Graph g, String start, int [] work, int[] size, int [] bfsorder, int [] bfspath) {
		this.t = t ;
		this.g = g ;
		this.start = start;
		this.work = work ;
		this.size = size ;
		this.bfsorder = bfsorder ;
		this.bfspath = bfspath ;
		//You can initialze your data structure here
		bfsAlg() ;
	}

	private void bfsAlg () {
		//WRITE CODE
		//YOU CAN HAVE ANY NUMBER OF private functions
	}

	public static void main(String[] args) {
		System.out.println("GraphBfs.java starts");
		System.out.println("Use GraphTest.java to test");
		System.out.println("GraphBfs.java Ends");
	}
}
