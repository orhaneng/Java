/*https://leetcode.com/explore/learn/card/queue-stack/230/usage-stack/1361/
 *   Valid Parentheses
  Go to Discuss
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 */
package queue_stack_DFS_BFS;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValid("()"));

	}
    public static  boolean isValid(String s) {
    	if(s==null||s.isEmpty()) return true;
        Stack<Character> stack = new Stack<Character>();
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(!stack.empty() && map.getOrDefault(stack.peek(), 'x')==arr[i]) {
            	stack.pop();
                continue;
            }
            stack.push(arr[i]);
        }
        return stack.empty();
    }

}
