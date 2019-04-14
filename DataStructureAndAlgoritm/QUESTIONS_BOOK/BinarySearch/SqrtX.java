/*https://leetcode.com/explore/learn/card/binary-search/125/template-i/950/
 *   Sqrt(x)
  Go to Discuss
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.

 */
package BinarySearch;

public class SqrtX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(mySqrt(9));
	}
    public static int mySqrt(int x) {
    	if(x<= 0) return 0;
    	int l=1,r=x,res=1;
    	
    	while(l<r) {
    		int mid=l+(r-l)/2;
    		if(mid>x/mid) {
    			r=mid;
    		}else {
    			res=mid;
    			l=mid+1;
    		}
    	}
    	return res;
    }
}
