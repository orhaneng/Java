package homework4;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * File Name: GraphTSP.java 
 * Breadth First Search on a graph
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

/*
 * To compile you require: IntUtil.java RandomInt.java Graph.java GraphTest.javs GraphTSP.java
 */

class GraphTSP{
	private String t ;
	private Graph g ;
	String start;
	//Output
	private int [] work ;
	private double [] cost ;
	//You can have any number of private variables and classes

	GraphTSP(String t, Graph g, String start, int [] work, double[] cost) {
		this.t = t ;
		this.g = g ;
		this.start = start;
		this.work = work ;
		this.cost = cost ;
		//You can initialize your private variables below
		//call your algorithm
		tspAlg() ;
	}

	private void tspAlg() {
		//WRITE CODE
		//YOU CAN HAVE ANY NUMBER OF private functions
	}

	public static void main(String[] args) {
		System.out.println("GraphTSP.java starts");
		System.out.println("Use GraphTest.java to test");
		System.out.println("GraphTSP.java Ends");
	}
}
