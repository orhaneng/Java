package homework3.graph;

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

		StringBuilder text = new StringBuilder();
		String[] namelist = fname.split("/");
		String name = (namelist != null ? namelist[namelist.length - 1] : "").replace(".dot", "");
		text.append("digraph " + name + " {");
		text.append("\n");
		for (int i = 0; i < g.getnumV(); i++) {
			String n = g.getRealName(i);
			for (int j = 0; j < g.numFanout(i); j++) {
				int fo = g.getNodeFanout(i, j);
				double cost = g.getNodeFanoutEdgeWeight(i, j);
				String nf = g.getRealName(fo);
				text.append(n + " -> " + nf);
				if (cost != 0) {
					text.append(" [ label=" + cost + "]");
				}
				text.append("\n");
			}
		}
		text.append("}");
		writeDotFile(fname, text);
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