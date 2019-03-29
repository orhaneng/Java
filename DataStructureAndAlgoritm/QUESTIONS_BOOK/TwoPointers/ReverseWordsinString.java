/*
 * Reverse Words in a String
  Go to Discuss
Given an input string, reverse the string word by word.
Example 1:
Input: "the sky is blue"
Output: "blue is sky the"
Example 2:
Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

 */
package TwoPointers;

public class ReverseWordsinString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("a good example"));
	}

	public static String reverseWords(String s) {
		s = s.trim();
		String[] arr = s.split(" ");
		StringBuilder builder = null;
		int begin = 0;
		int end = arr.length - 1;

		while (begin < end) {
			if ( "".equals(arr[begin])) {
				begin++;
				continue;
			}
			String temp = arr[begin];
			arr[begin] = arr[end];
			arr[end] = temp;
			begin++;
			end--;
		}
		builder = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if (arr.length - 1 == i)
				builder.append(arr[i]);
			else
				builder.append(arr[i] + " ");
		}
		return builder.toString();
	}

}
