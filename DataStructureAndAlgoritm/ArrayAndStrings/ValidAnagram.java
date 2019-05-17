import java.util.Arrays;

/*
 * 242. Valid Anagram
Easy

679

101

Favorite

Share
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?


 */
public class ValidAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isAnagram("anagram", "nagaram"));
	}

	public static boolean isAnagram(String s, String t) {
		char[] sArr = s.toCharArray();
		Arrays.sort(sArr);
		char[] tArr = t.toCharArray();
		Arrays.sort(tArr);
		return Arrays. equals(tArr,sArr);
	}

}
