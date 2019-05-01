package homework4;

import java.util.ArrayList;

/**
 * File Name: GraphDfs.java 
 * Depth First Search on a graph
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

/*
 * To compile you require: IntUtil.java RandomInt.java Graph.java GraphTest.javs GraphDfs.java
 */

class GraphDfs{
	private String t ;
	private Graph g ;
	String start;
	//Output
	boolean [] cycle;
	int [] work ;
	int [] size ;
	int [] dfsorder;

	//You can have any number of private variables
	//Data used to solve the problem


	GraphDfs(String t, Graph g, String start, boolean [] cycle, int [] work, int [] size, int [] dfsorder) {
		this.t = t ;
		this.g = g ;
		this.start = start;
		this.cycle = cycle ;
		//You can have any number of private variables and classes
		//you have to create an array
		dfsAlg() ;
	}

	private void dfsAlg(){
		//WRITE CODE
		//YOU CAN HAVE ANY NUMBER OF private functions
	}

	public static void main(String[] args) {
		System.out.println("GraphDfs.java starts");
		System.out.println("Use GraphTester.java to test");
		System.out.println("GraphDfs.java Ends");
	}
}