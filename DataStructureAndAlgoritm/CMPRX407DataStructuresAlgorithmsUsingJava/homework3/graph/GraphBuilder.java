package homework3.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * File Name: GraphBuilder.java All routines that builds Graph
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

/*
 * To compile you require: IntUtil.java RandomInt.java Graph.java GraphTest.javs
 * GraphBuilder.java
 */

class GraphBuilder {
	private Graph g;
	// You can have any number of private variables

	GraphBuilder(Graph g, String f) {
		this.g = g;
		buildGraph(f);
	}

	private void buildGraph(String f) {
		File file = new File(f);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;

			while ((st = br.readLine()) != null) {
				String[] edges = st.split(" ");
				double w = 0.0;
				if (edges.length == 3 && edges[2] != null) {
					w = Double.parseDouble(edges[2]);
				}
				g.createEdge(g.insertOrFind(edges[0], false), g.insertOrFind(edges[1], false), w, true);
				g.createEdge(g.insertOrFind(edges[1], false), g.insertOrFind(edges[0], false), w, false);
				if (g.isUndirectedGraph()) {
					g.createEdge(g.insertOrFind(edges[0], false), g.insertOrFind(edges[1], false), w, false);
					g.createEdge(g.insertOrFind(edges[1], false), g.insertOrFind(edges[0], false), w, true);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		System.out.println("GraphBuilder.java starts");
		System.out.println("Use GraphTester.java to test");
		System.out.println("GraphBuilder.java Ends");
	}
}