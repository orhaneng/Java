package dynamicProgramming;
/*
 * 338. Counting Bits
Share
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:

Input: 2
Output: [0,1,1]
Example 2:

Input: 5
Output: [0,1,1,2,1,2]
Follow up:

It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class CountingBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] aa = countBits(5);
		for (int i : aa) {
			System.out.println(i);
		}
	}

	public static int[] countBits(int num) {
		int[] f=new int[num+1];
		for (int i = 0; i < f.length; i++) {
			f[i]=f[i>>1]+(i&1);
		}
		return f;
	}
}
