/*https://leetcode.com/problems/n-repeated-element-in-size-2n-array/
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of these 
 * elements is repeated N times.
Return the element repeated N times.
Example 1:
Input: [1,2,3,3]
Output: 3
Example 2:
Input: [2,1,2,5,3,2]
Output: 2
Example 3:
Input: [5,1,5,2,5,3,5,4]
Output: 5

time complexity =O(N)
MEMORY O(N)
 */

package HashTable;

import java.util.HashSet;

public class NRepeatedElementinSize2NArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A= {5,1,5,2,5,3,5,4};
		System.out.println(repeatedNTimes(A));
	}
    public static int repeatedNTimes(int[] A) {
        HashSet hashSet = new HashSet();
        for(int i:A){
            if(hashSet.contains(i)) return i;
            else hashSet.add(i);
        }
        return 0;
    }

}
