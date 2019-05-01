/*
 * 1) Write a function to validate whether parentheses are balanced
Expecting true for the following strings

(if (zero? x) max (/ 1 x))
I told him (that it’s not (yet) done). (But he wasn’t listening)
Expecting false for the following strings

:-)
())(
The following methods are useful for this challenge chars.isEmpty chars.head chars.tail Hint: you can define an inner function if you need to pass extra parameters to your function.

To convert a String to List[Char] ==> "ucsc school".toList

Extra credit: write another implementation that uses pattern match with list extraction pattern
 */
package ArrayAndString;

import java.util.HashSet;
import java.util.Stack;

public class parenthesesAreBalanced {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "I told him (that it’s not (yet) done). (But he wasn’t listening)";
		System.out.println(isBalanced(text));
	}
	
	public static boolean isBalanced(String text) {
		Stack<Character> stack = new Stack<Character>();
		char[] arr= text.toCharArray();	
		for(int i=0;i<arr.length;i++) {
			if(arr[i]=='(') stack.push('(');
			else if(arr[i]==')') {
				if(!stack.isEmpty())
				stack.pop();
				else return false;
			}
		}
		if(!stack.isEmpty()) return false;
		return true;
	}
	
	
	

}
