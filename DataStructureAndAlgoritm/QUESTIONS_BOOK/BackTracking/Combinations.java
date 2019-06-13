/*https://leetcode.com/explore/learn/card/recursion-ii/472/backtracking/2798
 *   Combinations
  Go to Discuss
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]	
 */
package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol=new Solution();
		System.out.println(sol.combine(4, 2));
	}
	
	static class Solution {
	    public  List<List<Integer>> combine(int n, int k) {
			List<List<Integer>> combs = new ArrayList<List<Integer>>();
			combine(combs, new ArrayList<Integer>(), 1, n, k);
			return combs;
		}
		public void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
			if(k==0) {  //find solution
				combs.add(new ArrayList<Integer>(comb));
				return;
			}
			for(int i=start;i<=n;i++) {  //validation
				comb.add(i);//replace
				combine(combs, comb, i+1, n, k-1);  //backtrack
				comb.remove(comb.size()-1);//remove
			}
		}
	}

}
