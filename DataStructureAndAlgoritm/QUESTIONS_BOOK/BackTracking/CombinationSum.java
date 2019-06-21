/*
 * 39. Combination Sum
Medium

2067

60

Favorite

Share
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 sol=new Solution2();
		int[] arr= {1}; 
		System.out.println(sol.combinationSum(arr, 7));
	}
	static class Solution2{
		public List<List<Integer>> combinationSum(int[] nums, int target) {
		    List<List<Integer>> list = new ArrayList<>();
		    Arrays.sort(nums);
		    backtrack(list, new ArrayList<>(), nums, target, 0);
		    return list;
		}

		private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
		    if(remain < 0) return;
		    else if(remain == 0) list.add(new ArrayList<>(tempList));
		    else{ 
		        for(int i = start; i < nums.length; i++){
		            tempList.add(nums[i]);
		            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
		            tempList.remove(tempList.size() - 1);
		        }
		    }
		}
	}
	
	static class Solution {
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        List<List<Integer>> res=new ArrayList<List<Integer>>();
	        backtracking(candidates,target,0,res,new ArrayList<Integer>(),0,0);
	        return res;
	    }
	    
	    public void backtracking(int[] cand, int target, int sum, List<List<Integer>> res, List<Integer> list,int canindex,int jindex){
	        if(sum>target) return;
	        else if(sum==target){
	            if(list.isEmpty()){	
	                 list.add(cand[canindex]);
	            }
	            if(!res.contains(list))
	            res.add(new ArrayList<Integer>(list));
	            return;
	        }
	        
	        for(int i=canindex;i<cand.length;i++){
	            for(int j=jindex;j<target/cand[i];j++){
	                list.add(cand[i]);
	                backtracking(cand,target,sum+cand[i],res,list,canindex,++jindex);
	                //if(sum==target) {break;}
	                list.remove(list.size()-1);
	            }
	            canindex++;
	            jindex=0;
	        }
	    }
	}

}
