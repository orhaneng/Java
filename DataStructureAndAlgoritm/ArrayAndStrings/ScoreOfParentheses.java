import java.util.Stack;

/*
 * 856. Score of Parentheses
Medium

477

21

Favorite

Share
Given a balanced parentheses string S, compute the score of the string based on the following rule:

() has score 1
AB has score A + B, where A and B are balanced parentheses strings.
(A) has score 2 * A, where A is a balanced parentheses string.
 

Example 1:

Input: "()"
Output: 1
Example 2:

Input: "(())"
Output: 2
Example 3:

Input: "()()"
Output: 2
Example 4:

Input: "(()(()))"
Output: 6

 */
public class ScoreOfParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(scoreOfParentheses("(()(()))"));
	}
	
	public static int scoreOfParentheses(String S) {
	    Stack<Integer> stack = new Stack();
	    stack.push(0); // The score of the current frame

	    for (char c: S.toCharArray()) {
	        if (c == '(')
	            stack.push(0);
	        else {
	            int v = stack.pop();
	            int w = stack.pop();
	            stack.push(w + Math.max(2 * v, 1));
	        }
	    }

	    return stack.pop();
	}

}
