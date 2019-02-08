import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * X419-01: Homework 3
	1.-Reverse a queue using recursion.
 	2.-Check for balanced parenthesis on a given string.
 */
public class Homework3 {

	 static Queue<Integer> queuenew= new LinkedList<Integer>();

	public static void main(String[] args) {
		Queue<Integer> queue= new LinkedList<Integer>();
		queue.add(5);
		queue.add(3);
		queue.add(9);
		queue.add(1);
		//print(queue);
		//reverse(queue);
		//print(queuenew);
		
		final String text = "public static void print(Queue<Integer> queue) {	\n" + 
				"		for(Integer s : queue) { \n" + 
				"			  System.out.println(s.toString()); \n" + 
				"			}\n" + 
				"	}";
		System.out.println(checkparenthesis(text));

	}

	public static void print(Queue<Integer> queue) {	
		for(Integer s : queue) { 
			  System.out.println(s.toString()); 
			}
	}
	public static Queue<Integer> reverse(Queue<Integer> queue){
		if(queue.size()==0) {
			return queue;
		}
		Integer value = queue.remove();
		queue = reverse(queue);
		queuenew.add(value);
		return queue;
	}
	
	public static boolean checkparenthesis(String text) {
		
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < text.length(); i++) {
			if(text.charAt(i)=='{') {
				stack.add(Character.toString(text.charAt(i)));
			}
			else if(text.charAt(i)=='}'){
				stack.pop();
			}
		}
		
		if(stack.size()!=0) return false;
		else return true;
	}
	
}
