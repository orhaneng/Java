import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*https://leetcode.com/problems/word-break/
 * 139. Word Break
Medium

2196

122

Favorite

Share
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 * 
 */
public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol=new Solution();
		List<String> dict=new ArrayList();
		dict.add("leet");
		dict.add("code");
		System.out.println(sol.wordBreak("leetcode", dict));
	}
	static public class Solution {
	    public boolean wordBreak(String s, List<String> dict) {
	        
	        boolean[] f = new boolean[s.length() + 1];
	        
	        f[0] = true; 
	        //Second DP 
	        for(int i=1; i <= s.length(); i++){
	            for(int j=0; j < i; j++){
	                if(f[j] && dict.contains(s.substring(j, i))){
	                    f[i] = true;
	                    break;
	                }
	            }
	        }
	        
	        return f[s.length()];
	    }
	}

}
