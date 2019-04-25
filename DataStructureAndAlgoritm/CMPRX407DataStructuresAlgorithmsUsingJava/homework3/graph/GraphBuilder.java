package homework3.graph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * File Name: GraphBuilder.java 
 * All routines that builds Graph
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

/*
 * To compile you require: IntUtil.java RandomInt.java Graph.java GraphTest.javs GraphBuilder.java
 */

class GraphBuilder{
	private Graph g ;
	//You can have any number of private variables

	GraphBuilder(Graph g, String f) {
		this.g = g ;
		buildGraph(f) ;
	}

	private void buildGraph(String f) {
		//WRITE YOUR CODE HERE
	}

	public static void main(String[] args) {
		System.out.println("GraphBuilder.java starts");
		System.out.println("Use GraphTester.java to test");
		System.out.println("GraphBuilder.java Ends");
	}
}