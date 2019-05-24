/*
 * 22. Generate Parentheses
Medium

2687

166

Favorite

Share
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.generateParenthesis(3));
	}

	static class Solution {
		public List<String> generateParenthesis(int n) {
			List<String> list = new ArrayList<String>();

			helper(list, n, "", 0, 0);
			return list;
		}

		public void helper(List<String> list, int n, String text, int in, int out) {
			if (text.length() == n * 2) {
				list.add(text.toString());
				return;
			}

			if (in < n)
				helper(list, n, text + "(", in + 1, out);
			if (out < in)
				helper(list, n, text + ")", in, out + 1);
		}
	}

}
