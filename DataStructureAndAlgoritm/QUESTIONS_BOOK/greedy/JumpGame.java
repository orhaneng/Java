/*
 * 55. Jump Game
Medium

1982

201

Favorite

Share
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
 */
package greedy;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new  Solution();
		int[] arr= {2,3,1,1,4};
		System.out.println(sol.canJump(arr));
	}
	static class Solution {
	    public boolean canJump(int[] nums) {
	        if(nums==null||nums.length==0) return false;
	        int n =nums.length;
	        int furt=0;
	        for(int i=0;i<n;i++){
	            if(furt<i||furt>=n-1){
	                break;
	            }
	            furt=Math.max(furt,i+nums[i]);
	        }
	        return furt>=n-1;
	    }
	}
}
