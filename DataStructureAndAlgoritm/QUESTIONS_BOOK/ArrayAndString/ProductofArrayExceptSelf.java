/*
 * 238. Product of Array Except Self
Medium
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).
Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
package ArrayAndString;

public class ProductofArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol= new Solution();
		int[] nums= {1,2,3,4};
		int[] res= sol.productExceptSelf(nums);
		for (int i : res) {
			System.out.print(i+" ");
		}
	}

	static class Solution {
	     public int[] productExceptSelf(int[] nums) {
	         int[] res = new int[nums.length];
	         
	         for(int i=0;i<res.length;i++){
	             res[i]=1;
	         }
	         
	         int left=1;
	         for(int i=0;i<nums.length;i++){
	             res[i]*=left;
	             left*=nums[i];
	         }
	         
	         int right=1;
	         for(int i=nums.length-1;i>=0;i--){
	             res[i]*=right;
	             right=right* nums[i];
	         }
	         return res;
	     }
	}
}
