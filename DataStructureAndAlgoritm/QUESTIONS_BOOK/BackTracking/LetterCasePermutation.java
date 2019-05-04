/*
 * 784. Letter Case Permutation
Easy

589

73

Favorite

Share
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
 */
package BackTracking;

import java.util.LinkedList;
import java.util.List;

public class LetterCasePermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		System.out.println(sol.letterCasePermutation("a1b2"));
	}
	
	static class Solution {
	    public List<String> letterCasePermutation(String S) {
	        if (S == null) {
	            return new LinkedList<>();
	        }
	        
	        List<String> res = new LinkedList<>();
	        helper(S.toCharArray(), res, 0);
	        return res;
	    }
	    
	    private void helper(char[] chs, List<String> res, int pos) {
	    	System.out.println((new String(chs))+"--"+res);
	        if (pos == chs.length) {
	            res.add(new String(chs));
	            return;
	        }
	        if (chs[pos] >= '0' && chs[pos] <= '9') {
	            helper(chs, res, pos + 1);
	            return;
	        }
	        
	        chs[pos] = Character.toLowerCase(chs[pos]);
	        helper(chs, res, pos + 1);
	        
	        chs[pos] = Character.toUpperCase(chs[pos]);
	        helper(chs, res, pos + 1);
	    }
	}
}
