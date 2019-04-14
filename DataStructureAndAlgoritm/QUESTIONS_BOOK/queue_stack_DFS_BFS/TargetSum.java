/*
 *   Target Sum
  Go to Discuss
You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:
Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
Note:
The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
package queue_stack_DFS_BFS;

public class TargetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1, 1, 1, 1, 1};
		System.out.println(findTargetSumWays(num, 3));
	}
	
    public static int findTargetSumWays(int[] nums, int S) {
        return helper(nums, 0, S);
     }
     
     private static int helper(int[] nums, int idx, int S) {
         if (idx == nums.length) {
             return S == 0 ? 1 : 0;
         }
         
         int plus = helper(nums, idx+1, S+nums[idx]);
         int minus = helper(nums, idx+1, S-nums[idx]);
         
         return plus + minus;
     }
	

}
