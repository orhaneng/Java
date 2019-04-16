/*https://leetcode.com/explore/learn/card/binary-search/135/template-iii/945/
 *   Find K Closest Elements
  Go to Discuss
Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
Note:
The value k is positive and will always be smaller than the length of the sorted array.
Length of the given array is positive and will not exceed 104
Absolute value of elements in the array and x will not exceed 104
 */
package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		int[] arr= {1,2,3,4,5};
		System.out.println(findClosestElements(list, 4, 3));
	}
	
	
	public static List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
	    int lo = 0, hi = arr.size() - k;
	    while (lo < hi) {
	        int mid = (lo + hi) / 2;
	        if (x - arr.get(mid) > arr.get(mid+k) - x)
	            lo = mid + 1;
	        else
	            hi = mid;
	    }
	    return arr.subList(lo, lo + k);
	}

}
