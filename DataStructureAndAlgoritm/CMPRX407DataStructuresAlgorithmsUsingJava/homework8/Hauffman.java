package homework8;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Hauffman {
	String dotfilename;
	String s;

	private class HauffmanNode {
		char ch;
		int value;
		HauffmanNode left;
		HauffmanNode right;
		int id;

		public HauffmanNode(int value, HauffmanNode left, HauffmanNode right, char ch, int id) {
			this.left = left;
			this.right = right;
			this.value = value;
			this.id = id;
			this.ch = ch;
		}
	}

	public Hauffman(String s, boolean show, String dotfilename) {
		this.dotfilename = dotfilename;
		this.s = s;
		Map<Character, Integer> map = new HashMap();

		System.out.println("============" + s + "==========");
		// get counts to map
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		PriorityQueue<HauffmanNode> queue = new PriorityQueue<HauffmanNode>(s.length(), new MyComparator());

		int count = 0;
		List<HauffmanNode> list = new ArrayList();
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			HauffmanNode node = new HauffmanNode(entry.getValue(), null, null, entry.getKey(), ++count);
			System.out.println(entry.getKey() + " occurs " + entry.getValue() + " times");
			list.add(node);
			queue.add(node);
		}

		HauffmanNode root = null;
		System.out.println("==== Tree built in this order===============");
		while (queue.size() > 1) {
			HauffmanNode node1 = queue.poll();
			HauffmanNode node2 = queue.poll();
			HauffmanNode newNode = new HauffmanNode(node1.value + node2.value, node1, node2, '-', ++count);
			list.add(newNode);
			root = newNode;
			queue.add(newNode);
		}

		for (HauffmanNode hauffmanNode : list) {
			if (hauffmanNode.ch != '-')
				System.out.println("Leaf      node " + hauffmanNode.id + " Character is " + hauffmanNode.ch
						+ " Weight is " + hauffmanNode.value);
			else
				System.out.println("Internal  node " + hauffmanNode.id + ": Left "
						+ (hauffmanNode.left.ch == '-' ? ' ' : hauffmanNode.left.ch) + "(" + hauffmanNode.left.value
						+ ")" + " Right " + (hauffmanNode.right.ch == '-' ? ' ' : hauffmanNode.right.ch) + "("
						+ hauffmanNode.right.value + ") Weight is " + hauffmanNode.value);

		}
		System.out.println("==========Tree has " + list.size() + " nodes================");

		writeDot(root);
	}

	private void printforDot(HauffmanNode root) {
		if (root == null)
			return;
		printforDot(root.right);
		if (root.left == null && root.right == null) {
			System.out.println("Leaf  node " + root.id + " Character is " + root.ch + " Weight is " + root.value);
		}
		if (root.left != null || root.right != null) {
			System.out.println("Internal  node " + root.id + " Character is " + root.ch + " Weight is " + root.value);
		}

		printforDot(root.left);

	}

	private void writeDot(HauffmanNode root) {
		try {
			FileWriter o = new FileWriter(dotfilename);
			o.write("## jagadeesh");
			o.write("dot - tpdf" + dotfilename + "-o" + dotfilename + ".pdf\n");
			o.write("digraph g{\n");
			o.write("label = \"" + s + "\"\n");
			
			Queue<HauffmanNode> queue= new LinkedList<Hauffman.HauffmanNode>();
			queue.add(root);
			while(!queue.isEmpty()) {
				HauffmanNode node = queue.poll();
				if(node.left!=null) {
					queue.add(node.left);
					o.write("\""+node.id+"\\n"+node.value+"\" ->\""+node.left.id+"\\n"+node.left.value+(node.left.ch=='-'?"":" \\n "+node.left.ch)+"\""+" [color=red] \n");
				}if(node.right!=null) {
					queue.add(node.right);
					o.write("\""+node.id+"\\n"+node.value+"\" ->\""+node.right.id+"\\n"+node.right.value+(node.right.ch=='-'?"":" \\n "+node.right.ch)+"\""+" [color=blue] \n");
				}
			}
			o.write("}");
			o.flush();
			o.close();

		} catch (Exception ex) {

		}
	}

	class MyComparator implements Comparator<HauffmanNode> {
		@Override
		public int compare(HauffmanNode x, HauffmanNode y) {
			return x.value - y.value;
		}
	}

	public String encode() {
		return null;
	}

	public String decode() {
		return null;
	}

}
