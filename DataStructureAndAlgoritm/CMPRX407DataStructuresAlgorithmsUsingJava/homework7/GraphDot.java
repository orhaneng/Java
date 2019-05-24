package homework7;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * File Name: GraphDot.java Writes graph as a dot file
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

/*
 * To compile you require: IntUtil.java RandomInt.java Graph.java GraphTest.javs
 * GraphDot.java
 */

class GraphDot {
	private Graph g;
	private String fname;
	// You can have any number of private variables
	private String[][] e;

	GraphDot(Graph g, String s) {
		this.g = g;
		this.fname = s;
		writeDot();
	}

	private void writeDot() {

		/*
		 * StringBuilder text = new StringBuilder(); String[] namelist =
		 * fname.split("/"); String name = (namelist != null ? namelist[namelist.length
		 * - 1] : "").replace(".dot", ""); text.append("digraph " + name + " {");
		 * text.append("\n"); for (int i = 0; i < g.getnumV(); i++) { String n =
		 * g.getRealName(i); for (int j = 0; j < g.numFanout(i); j++) { int fo =
		 * g.getNodeFanout(i, j); double cost = g.getNodeFanoutEdgeWeight(i, j); String
		 * nf = g.getRealName(fo); text.append(n + " -> " + nf); if (cost != 0) {
		 * text.append(" [ label=" + cost + "]"); } text.append("\n"); } }
		 * text.append("}"); writeDotFile(fname, text);
		 */
		try {
			FileWriter o = new FileWriter(fname);
			GraphTest.GraphType t = g.getType();
			o.write("## jagadeesh");
			o.write("dot - tpdf" + fname + "-o" + fname + ".pdf\n");
			o.write("digraph g{\n");
			if (t == GraphTest.GraphType.UNDIRECTED || t == GraphTest.GraphType.WEIGHTED_UNDIRECTED) {
				o.write("edge [dir=none, color=red]\n");
			} else {
				o.write("edge [color=red]\n");
			}

			int n = g.getnumV();
			for (int i = 0; i < g.getnumV(); i++) {
				String p1 = g.getNodeRealName(i);
				int nf = g.numFanout(i);
				for (int j = 0; j < nf; j++) {
					int k = g.getNodeFanout(i, j);
					String p2 = g.getNodeRealName(k);
					double w = g.getNodeFanoutEdgeWeight(i, j);
					if ((t == GraphTest.GraphType.WEIGHTED_UNDIRECTED)
							|| (t == GraphTest.GraphType.WEIGHTED_DIRECTED)) {
						if ((t == GraphTest.GraphType.WEIGHTED_DIRECTED) || (i < k)) {
							o.write("  " + p1 + " -> " + p2 + " [label = " + w + "]\n");
						}
					} else {
						if ((t == GraphTest.GraphType.DIRECTED) || (i < k)) {
							o.write("  " + p1 + " -> " + p2 + "\n");
						}
					}
				}
			}
			o.write("}");
			o.flush();
			o.close();

		} catch (Exception ex) {

		}
	}

	public static void writeDotFile(String path, StringBuilder text) {

		File file = new File(path);
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(text.toString());
		} catch (IOException e) {

		} finally {
			if (writer != null)
				try {
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public static void main(String[] args) {
		System.out.println("GraphDot.java starts");
		System.out.println("Use GraphTester.java to test");
		System.out.println("GraphDot.java Ends");
	}
}