/*
 * Minimum Size Subarray Sum
  Go to Discuss
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example: 

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 

 */
public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		System.out.println(minSubArrayLen(7,arr));
	}
	
    public static int minSubArrayLen(int s, int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            int count=0;
            int j=i;
            int sum=0;
            while(sum<=s &&j<nums.length){
                sum=sum+nums[j++];
                ++count;
                if(sum==s){
                	if(max==0) max=count;
                    if(max>count&&count!=0) max=count;
                    sum=0;
                    break;
                }
            }
        }
        return max;
    }

}
