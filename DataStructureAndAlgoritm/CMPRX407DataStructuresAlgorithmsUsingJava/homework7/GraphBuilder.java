package homework7;

import java.io.BufferedReader;
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
		int numlines = 0;
		GraphTest.GraphType t = g.getType();
		try {
			BufferedReader br = new BufferedReader(new FileReader(f));
			StringBuilder sb = new StringBuilder();
			String lastline = null;
			int notreadlines = 0;
			while (true) {
				String line1 = br.readLine();
				if (line1 == null) {
					break;
				} else {
					String line = line1.trim();
					lastline = line;
					String delims = "[ ]+";
					String[] s = line.split(delims);
					int l = s.length;
					if (l == 3) {
						++numlines;
						g.u.myassert((t == GraphTest.GraphType.WEIGHTED_UNDIRECTED)
								|| (t == GraphTest.GraphType.WEIGHTED_DIRECTED));
					} else if (l == 2) {
						g.u.myassert((t == GraphTest.GraphType.UNDIRECTED) || (t == GraphTest.GraphType.DIRECTED));
						numlines++;
					} else {
						++notreadlines;
					}
					if (l == 2 || l == 3) {
						for (int j = 0; j < 2; j++) {
							g.insertOrFind(s[j], false);
						}
						double w = 0;
						int p1 = g.insertOrFind(s[0], true);
						int p2 = g.insertOrFind(s[1], true);
						if (l == 3) {
							w = Double.parseDouble(s[2]);
						}
						g.createEdge(p1, p2, w, true);
						g.createEdge(p2, p1, w, false);
						if (((t == GraphTest.GraphType.UNDIRECTED) || (t == GraphTest.GraphType.WEIGHTED_UNDIRECTED))) {
							g.createEdge(p2, p1, w, true);
							g.createEdge(p1, p2, w, false);
						}
					}

				}
			}
		} catch (IOException ex) {
			System.out.println(ex.getStackTrace());
		}
		/*
		 * File file = new File(f); try { BufferedReader br = new BufferedReader(new
		 * FileReader(file)); String st;
		 * 
		 * while ((st = br.readLine()) != null) { String[] edges = st.split(" "); double
		 * w = 0.0; if (edges.length == 3 && edges[2] != null) { w =
		 * Double.parseDouble(edges[2]); } g.createEdge(g.insertOrFind(edges[0], false),
		 * g.insertOrFind(edges[1], false), w, true);
		 * g.createEdge(g.insertOrFind(edges[1], false), g.insertOrFind(edges[0],
		 * false), w, false); if (g.isUndirectedGraph()) {
		 * g.createEdge(g.insertOrFind(edges[0], false), g.insertOrFind(edges[1],
		 * false), w, false); g.createEdge(g.insertOrFind(edges[1], false),
		 * g.insertOrFind(edges[0], false), w, true); } } } catch (IOException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 */

	}

	public static void main(String[] args) {
		System.out.println("GraphBuilder.java starts");
		System.out.println("Use GraphTester.java to test");
		System.out.println("GraphBuilder.java Ends");
	}
}