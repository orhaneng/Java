/*
 * 125. Valid Palindrome
Easy

574

1679

Favorite

Share
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false

 */
public class ValidPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama"));
	}

	static class Solution {
		public boolean isPalindrome(String s) {
			int start = 0;
			int end = s.length() - 1;
			s = s.toLowerCase();
			while (start < end) {
				if (!Character.isLetterOrDigit(s.charAt(start))) {
					start++;
					continue;
				} else if (!Character.isLetterOrDigit(s.charAt(end))) {
					end--;
					continue;
				} else {
					if (!(s.charAt(end) == s.charAt(start))) {
						return false;
					}
					start++;
					end--;
				}
			}
			return true;
		}
	}
}
