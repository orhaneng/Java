/*
 *  Find Minimum in Rotated Sorted Array
  Go to Discuss
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
Example 2:

Input: [4,5,6,7,0,1,2]
Output: 0
 */
package BinarySearch;

public class FindMinimumRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {4,5,6,7,0,1,2};
		System.out.println(findMin(arr));
	}
    public  static int findMin(int[] nums) {
    	int left=0;
    	int right=nums.length-1;
    	
    	while(left<right) {
    		int mid = left+(right-left)/2;
    		if(nums[mid]>nums[right]) {
    			left=mid+1;
    		}
    		else {
    			right=mid;
    		}
    	}
    	return left;
    }

}
