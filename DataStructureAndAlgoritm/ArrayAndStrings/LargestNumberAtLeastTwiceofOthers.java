/*
 *   Largest Number At Least Twice of Others
  Go to Discuss
In a given integer array nums, there is always exactly one largest element.

Find whether the largest element in the array is at least twice as much as every other number in the array.
If it is, return the index of the largest element, otherwise return -1.
Example 1:
Input: nums = [3, 6, 1, 0]
Output: 1
Explanation: 6 is the largest integer, and for every other number in the array x,
6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
Example 2:
Input: nums = [1, 2, 3, 4]
Output: -1
Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.

 */
public class LargestNumberAtLeastTwiceofOthers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {0,0,0,1};
		System.out.println(dominantIndex(arr));
	}
    public static int dominantIndex(int[] nums) {
        int max=0;
        int maxindex=0;
        for(int i=0;i<nums.length;i++){
            if(max<nums[i]){
                max=nums[i];
                maxindex=i;
            }
        }
        
        for(int i:nums){
            if(max!=i&&i!=0 && max/i<2){
                return -1;
            }
        }
        return maxindex;
    }

}
