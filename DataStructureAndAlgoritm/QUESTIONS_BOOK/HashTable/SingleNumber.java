/*
 *   Single Number
  Go to Discuss
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:
Input: [2,2,1]
Output: 1
Example 2:
Input: [4,1,2,1,2]
Output: 4

we use bitwise XOR to solve this problem :
first , we have to know the bitwise XOR in java
0 ^ N = N
N ^ N = 0
So..... if N is the single number
N1 ^ N1 ^ N2 ^ N2 ^..............^ Nx ^ Nx ^ N
= (N1^N1) ^ (N2^N2) ^..............^ (Nx^Nx) ^ N
= 0 ^ 0 ^ ..........^ 0 ^ N
= N
 */
package HashTable;

public class SingleNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {4,1,2,1,2};
		System.out.println(singleNumber(arr));
	}
	
    public static int singleNumber(int[] nums) {
    	int res=0;
    	for(int i:nums) {
    		res^=i;
    	}
    	return res;
    }

}
