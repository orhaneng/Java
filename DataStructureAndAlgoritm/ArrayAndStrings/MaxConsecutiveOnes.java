/*https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1301/
 *   Go to Discuss
Given a binary array, find the maximum number of consecutive 1s in this array.

Example 1:
Input: [1,1,0,1,1,1]
Output: 3
Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
TIME O(N)
SPACE O(1)
 */
public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,1,0,1,1,1};
		System.out.println(findMaxConsecutiveOnes(input));
	}

    public static int findMaxConsecutiveOnes(int[] nums) {
        int count=0;
        int maxcount=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                ++count;
                if(count>maxcount) maxcount=count;
            }else{
                count=0;
            }
        }
        return maxcount;
    }
}
