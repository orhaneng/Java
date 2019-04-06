/*https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Longest Substring Without Repeating Characters
  Go to Discuss
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring3("cbccac"));
	}
	
    public static int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        HashSet<Character> set;
        int max=0;
        for(int i=0;i<arr.length;i++){
            set =new  HashSet<Character>();
            set.add(arr[i]);
            for(int j=i;j<arr.length;j++){
                if(set.contains(arr[j])){
                    max = max<set.size()?set.size():max;
                    set =new  HashSet<Character>();
                }else{
                    set.add(arr[j]);
                }
            }
            max = max<set.size()?set.size():max;
        }
        return max;
        //O(N2)
    }
    
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
    
    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

}
