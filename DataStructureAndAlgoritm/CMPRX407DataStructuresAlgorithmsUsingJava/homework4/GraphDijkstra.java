package homework4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * File Name: GraphDijkstra.java 
 * Implements Dijkstra's algorithms
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

/*
 * To compile you require: IntUtil.java RandomInt.java Graph.java GraphTest.javs GraphDijkstra.java
 */

class GraphDijkstra{
	//DATA GIVEN
	private String t ; //Title
	private String dotFile; //Write tree as a dot file
	private Graph g ;
	String start;
	String end;
	int [] work ;
	double [] cost ;
	//DATA REQUIRED FOR WORK
	//You can have any number of private variables and classes

	GraphDijkstra(String t, String dotFile, Graph g, String start,String end, int [] work, double [] cost) {
		this.t = t ;
		this.dotFile = dotFile ;
		this.g = g ;
		this.start = start;
		this.end = end ;
		this.work = work ;
		this.cost = cost ;
		//You can initialze your data structure here
		DijkstraAlg() ;
	}

	private void DijkstraAlg() {
		//WRITE CODE
		//YOU CAN HAVE ANY NUMBER OF private functions
	}

	public static void main(String[] args) {
		System.out.println("GraphDijkstra.java starts");
		System.out.println("Use GraphTest.java to test");
		System.out.println("GraphDijkstra.java Ends");
	}
}