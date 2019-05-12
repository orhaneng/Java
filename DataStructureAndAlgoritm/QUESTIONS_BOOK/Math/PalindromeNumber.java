/*
 * 9. Palindrome Number
Easy

1379

1280

Favorite

Share
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

 */
package Math;

public class PalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(121));
	}

	public static boolean isPalindrome(int x) {
		int result = 0;
		int temp = x;
		while (temp != 0) {
			result = result * 10 + temp % 10;
			temp = temp / 10;
		}

		if (x < 0) {
			result = 0 - result;
		}

		if (result == x) {
			return true;
		}
		return false;
	}

}
