/*https://leetcode.com/problems/backspace-string-compare/
 * 844. Backspace String Compare
Easy

573

42

Favorite

Share
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

 */
package queue_stack_DFS_BFS;

import java.util.Stack;

public class BackspaceStringCompare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(backspaceCompare("a#c","b"));

	}
    public static  boolean backspaceCompare(String S, String T) {
        Stack<Character> stack = new Stack<Character>();
        Stack<Character> stack2 = new Stack<Character>();

        char[] arr = S.toCharArray();
        
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]=='#') { i--;continue;}
            stack.add(arr[i]);
        }
        
        char[] arr2 = T.toCharArray();
        
        for(int i=arr2.length-1;i>=0;i--){
            if(arr2[i]=='#') { i--;continue;}
            stack2.add(arr2[i]);
        }
        return stack.equals(stack2);
    }
}
