import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/*
 * Name: OMER ORHAN
 * X419-01: Homework 3
	1.-Reverse a queue using recursion.
 	2.-Check for balanced parenthesis on a given string.
 */
public class Homework3 {
	
	static Queue<Integer> queuenew= new LinkedList<Integer>();
	//1.-Reverse a queue using recursion.
	public static Queue<Integer> reverse(Queue<Integer> queue){
		//If it is end of the queue, return queue
		if(queue.size()==0) {
			return queue;
		}
		//remove element and go to recursive
		Integer value = queue.remove();
		queue = reverse(queue);
		queuenew.add(value);
		return queue;
	}
	
	//2.-Check for balanced parenthesis on a given string.
	public static boolean checkparenthesis(String text) {
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < text.length(); i++) {
			if(text.charAt(i)=='{'||text.charAt(i)=='<'||text.charAt(i)=='['
					||text.charAt(i)=='(') {
				stack.add(Character.toString(text.charAt(i)));
			}
			//if it is closing symbols, check with the correct one
			// if there is not match, return false
			else if(text.charAt(i)=='}'||text.charAt(i)=='>'||text.charAt(i)==']'
					||text.charAt(i)==')'){
				
				if(text.charAt(i)=='}') {
					if((int)stack.peek().charAt(0)!= (int)"{".charAt(0))
					{
						return false;
					}	
				}
				if(text.charAt(i)=='>') {
					if((int)stack.peek().charAt(0)!= (int)"<".charAt(0))
					{
						return false;
					}	
				}
				if(text.charAt(i)==']') {
					if((int)stack.peek().charAt(0)!= (int)"[".charAt(0))					{
						return false;
					}	
				}
				if(text.charAt(i)==')') {
					if((int)stack.peek().charAt(0)!= (int)"(".charAt(0))					{
						return false;
					}	
				}
				
				stack.pop();
			}
		}
		//if stack is not empty, return false
		if(stack.size()!=0) return false;
		else return true;
	}
	
}
