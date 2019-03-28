/*https://leetcode.com/explore/learn/card/array-and-string/205/array-two-pointer-technique/1151/
 *   Remove Element
  Go to Discuss
Given an array nums and a value val, remove all instances of that value in-place and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example 1:

Given nums = [3,2,2,3], val = 3,

Your function should return length = 2, with the first two elements of nums being 2.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,1,2,2,3,0,4,2], val = 2,

Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.

Note that the order of those five elements can be arbitrary.

It doesn't matter what values are set beyond the returned length.
 */
public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,2,3};
		int[] result = removeElement(nums, 3);
		for (int i : result) {
			System.out.println(i);
		}
	}
	
	public static int[] removeElement(int[] nums, int val) {
        int i = 0;
        for(int j = nums.length - 1;i <= j;){
            if(nums[i] != val) i++;
            else{
                nums[i] = nums[j];
                j--;
            }
        }
        return nums;
    }

}
