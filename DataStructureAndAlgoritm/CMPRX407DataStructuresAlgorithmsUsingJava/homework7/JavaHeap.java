package homework7;

import java.util.Comparator;
import java.util.PriorityQueue;



/**
 * File Name: JavaHeap.java 
 * 
 * 
 * To Compile: IntUtil.java RandomInt.java GraphM.java GraphMTester.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2018
 */

class JavaHeap{
	private class Node {
		private int num ;
		Node(int num) {
			this.num = num ;	
		}
	}
	private class NodeComparator implements Comparator<Node> {
		private boolean ascend ;
		NodeComparator(boolean ascend) {
			this.ascend = ascend ;
		}
    @Override
    public int compare(Node x, Node y) {
    	int v = x.num - y.num ;
    	return (ascend)? v: -(v) ;
    }
  }
	
	void testmin(boolean ascend) {
		Comparator<Node> comparator = new NodeComparator(ascend);
		PriorityQueue<Node> minheap = new PriorityQueue<Node>(10,comparator);
		for (int i = 10; i >= 0; --i) {
			Node n = new Node(i) ;
			minheap.add(n) ;
		}
		while (minheap.isEmpty() == false) {
			Node n = minheap.peek() ;
	    minheap.remove();
	    System.out.print(n.num + " ");
		}
		System.out.println() ;
    
	}
	
	public static void main(String[] args) {
		System.out.println("JavaHeap Starts");
		JavaHeap j = new JavaHeap() ;
		System.out.println("Testing minheap");
		j.testmin(true) ;
		System.out.println("Testing maxheap");
		j.testmin(false) ;
		System.out.println("JavaHeap ENDS");
	}
}
