/*https://leetcode.com/problems/longest-palindromic-substring/
 * 5. Longest Palindromic Substring
Medium

3744

356

Favorite

Share
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */
package dynamicProgramming;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol=new Solution();
		System.out.println(sol.longestPalindrome(""));
	}

	public static class Solution {
		public String longestPalindrome(String s) {
			if(s.isEmpty()) return s;	
			int n = s.length();
			String res = null;

			boolean[][] dp = new boolean[n][n];

			for (int i = n - 1; i >= 0; i--) {
				for (int j = i; j < n; j++) {
					dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

					if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
						res = s.substring(i, j + 1);
					}
				}
			}

			return res;
		}
	}
}
