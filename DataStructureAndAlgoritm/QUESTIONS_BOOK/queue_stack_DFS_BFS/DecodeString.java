/*https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1379/
 * Decode String
  Go to Discuss
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
package queue_stack_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println(decodeString2("3[a]2[bc]"));
	}
	
    public static String decodeString2(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
    public static String decodeString(String s) {
        char[] arr = s.toCharArray();
        StringBuilder result =new StringBuilder();
        Stack<String> stack = new Stack<String>();
        stack.push(String.valueOf(arr[0]));
        int index=0;
        while(!stack.isEmpty()&&index<arr.length) {
        	while(arr[index]!=']') {
            	index++;
        		stack.push(String.valueOf(arr[index]));
        	}
        	if(stack.peek()=="]") {
        		String text= "";
        		while(arr[index]!='['){
        			text=text+String.valueOf(stack.pop());
        		}
        		stack.pop();
        		
        		int repeat =Integer.valueOf(stack.pop());
        		for(int i=0;i<repeat;i++) {
        			result.append(text);
        		}
        	}
        	index++;
        }
        return result.toString();
    }

}
