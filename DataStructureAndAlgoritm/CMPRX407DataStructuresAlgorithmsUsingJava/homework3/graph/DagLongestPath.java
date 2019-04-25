package homework3.graph;


/**
 * File Name: DagLongestPath.java 
 * Longest path in a DAG
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

/*
 * To compile you require: IntUtil.java RandomInt.java Graph.java GraphTest.javs GraphTopologicalSort.java DagLongestPath.java
 */

class DagLongestPath{
	//inputs
	private String t ;
	private Graph g ;
	//output
	double [] w ;
	//DATA REQUIRED FOR WORK
	//You can have any number of private variables and classes


	DagLongestPath(String t, Graph g, double [] w) {
		this.t = t ;
		this.g = g ;
		this.w = w ;
		//You can initialze your data structure here
		DagLongestPathAlg();
	}

	private void DagLongestPathAlg() {
		//WRITE CODE
		//YOU CAN HAVE ANY NUMBER OF private functions
	}

	public static void main(String[] args) {
		System.out.println("DagLongestPath.java starts");
		System.out.println("Use GraphTester.java to test");
		System.out.println("DagLongestPath.java Ends");
	}
}