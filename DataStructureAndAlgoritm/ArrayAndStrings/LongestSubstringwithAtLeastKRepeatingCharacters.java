import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 395. Longest Substring with At Least K Repeating Characters
Medium

722

62

Favorite
https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
Share
Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution(); 
		System.out.println( sol.longestSubstring("aaabb",3));
	}
	static class Solution {
	    public int longestSubstring(String s, int k) {
	        if(s==null) return 0;
	        Map<Character,Integer> map =new HashMap<Character,Integer>();
	        for(char ch:s.toCharArray()){
	            map.put(ch,map.getOrDefault(ch,0)+1);
	        }
	        List<Character> list=new ArrayList<Character>();
	        for(Map.Entry<Character,Integer> entry:map.entrySet()){
	            if(entry.getValue()<k)
	                list.add(entry.getKey());
	        }
	        int start=0;
	        String res="";
	        for(int i=0;i<s.length();i++){
	            if(list.contains(s.charAt(i))){
	                if(res.length()<i-start){
	                    res=s.substring(start,i);
	                }
	                 if(i<s.length()-1){
	                    start=i+1;
	                }
	            }
	        }
	        return res.length();
	    }
	}
}
