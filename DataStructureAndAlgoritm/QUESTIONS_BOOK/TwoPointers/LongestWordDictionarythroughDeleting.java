/*https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
 * 524. Longest Word in Dictionary through Deleting
Medium

305

165

Favorite

Share
Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some characters of the given string. If there are more than one possible results, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.

Example 1:
Input:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

Output: 
"apple"
Example 2:
Input:
s = "abpcplea", d = ["a","b","c"]

Output: 
"a"
Note:
All the strings in the input will only contain lower-case letters.
The size of the dictionary won't exceed 1,000.
The length of all the strings in the input won't exceed 1,000.

 */
package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestWordDictionarythroughDeleting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abpcplea";
		List<String> d = new ArrayList<String>();
		d.add("ale");
		d.add("apple");
		d.add("monkey");
		d.add("plea");
		
		System.out.println(findLongestWord(s, d));
		

	}
	
	   public static boolean isSubsequence(String x, String y) {
	        int j = 0;
	        for (int i = 0; i < y.length() && j < x.length(); i++)
	            if (x.charAt(j) == y.charAt(i))
	                j++;
	        return j == x.length();
	    }
	    public static String findLongestWord(String s, List < String > d) {
	        String max_str = "";
	        for (String str: d) {
	            if (isSubsequence(str, s)) {
	                if (str.length() > max_str.length() || (str.length() == max_str.length() && str.compareTo(max_str) < 0))
	                    max_str = str;
	            }
	        }
	        return max_str;
	    }
}
