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

/*
 * Functions;
 * HauffmanNode - definition of Node
 * Hauffman - main function including create queue, list, node
 * writeDot() create Dot files
 * HashCode(  put hashcode in map with inorder traversal
 * decode() decode string
 * encode() encode string 
 * Mycomparator - comparator class for priorityqueue
 */

public class Hauffman {
	String dotfilename;
	String s;
	Map<Character, String> keys = new HashMap<Character, String>();
	String encodeText;
	HauffmanNode root = null;

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

	public Hauffman(String s, boolean show, String dotfilename) { // Time O(NLOGN) SPACE O(N)
		this.dotfilename = dotfilename;
		this.s = s;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		System.out.println("============" + s + "==========");
		// get counts to map
		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		PriorityQueue<HauffmanNode> queue = new PriorityQueue<HauffmanNode>(s.length(), new MyComparator());
		int count = 0;
		List<HauffmanNode> list = new ArrayList<HauffmanNode>();
		// add nodes to queue
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			HauffmanNode node = new HauffmanNode(entry.getValue(), null, null, entry.getKey(), ++count);
			System.out.println(entry.getKey() + " occurs " + entry.getValue() + " times");
			list.add(node);
			queue.add(node);
		}

		System.out.println("==== Tree built in this order===============");
		while (queue.size() > 1) {
			HauffmanNode node1 = queue.poll();
			HauffmanNode node2 = queue.poll();
			HauffmanNode newNode = new HauffmanNode(node1.value + node2.value, node1, node2, '-', ++count);
			list.add(newNode);
			root = newNode;
			queue.add(newNode);
		}
		if (queue.size() == 1) {
			HauffmanNode node1 = queue.poll();
			root = node1;
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

		writeDot();
		if (s.length() == 1) {
			HashCode(root, "0");
		} else {
			HashCode(root, "");
		}
		System.out.println("========Code for each character in " + s + "============");
		for (Map.Entry<Character, String> entry : keys.entrySet()) {
			System.out.println(entry.getKey() + " Has Code " + entry.getValue());
		}

	}

	private void HashCode(HauffmanNode root, String path) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			keys.put(root.ch, path);
		}
		HashCode(root.right, path + "1");
		HashCode(root.left, path + "0");
	}

	private void writeDot() {
		try {
			FileWriter o = new FileWriter(dotfilename);
			o.write("## jagadeesh");
			o.write("dot - tpdf" + dotfilename + "-o" + dotfilename + ".pdf\n");
			o.write("digraph g{\n");
			o.write("label = \"" + s + "\"\n");

			Queue<HauffmanNode> queue = new LinkedList<Hauffman.HauffmanNode>();
			queue.add(root);
			if (s.length() == 1) {
				o.write("\"" + root.id + "\\n" + root.value + "\" \n");

			} else {
				while (!queue.isEmpty()) {
					HauffmanNode node = queue.poll();
					if (node.left != null) {
						queue.add(node.left);
						o.write("\"" + node.id + "\\n" + node.value + "\" ->\"" + node.left.id + "\\n" + node.left.value
								+ (node.left.ch == '-' ? "" : " \\n " + node.left.ch) + "\"" + " [color=red] \n");
					}
					if (node.right != null) {
						queue.add(node.right);
						o.write("\"" + node.id + "\\n" + node.value + "\" ->\"" + node.right.id + "\\n"
								+ node.right.value + (node.right.ch == '-' ? "" : " \\n " + node.right.ch) + "\""
								+ " [color=blue] \n");
					}
				}
			}
			o.write("}");
			o.flush();
			o.close();

		} catch (Exception ex) {

		}
	}

	public String decode() { // TIME O(L) N IS DECODE TEXT LENGTH SPACE (N) INPUT STRING LENGTH
		StringBuilder text = new StringBuilder();
		HauffmanNode node = root;
		for (int i = 0; i < encodeText.length();) {
			HauffmanNode tempNode = node;
			while (tempNode.left != null && tempNode.right != null && i < encodeText.length()) {
				if (encodeText.charAt(i) == '1')
					tempNode = tempNode.right;
				else
					tempNode = tempNode.left;
				i++;
			}
			if (tempNode != null) {
				text.append(tempNode.ch);
			}
			if (encodeText.length() == 1 && encodeText.length() - 1 == i)
				break;
		}

		System.out.println("=======Recoreved String==========");
		System.out.println(text.toString());
		return text.toString();
	}

	public String encode() { // TIME O(N) N IS INPUT TEXT LENGTH SPACE (L) ENCODE STRING LENGTH
		StringBuilder result = new StringBuilder();
		for (char item : s.toCharArray()) {
			result.append(keys.get(item));
		}
		System.out.println("==============Original String================");
		System.out.println(s);
		System.out.println("==============Decoded String================");
		System.out.println(result.toString());
		encodeText = result.toString();
		return result.toString();
	}

	class MyComparator implements Comparator<HauffmanNode> {
		@Override
		public int compare(HauffmanNode x, HauffmanNode y) {
			return x.value - y.value;
		}
	}

}
