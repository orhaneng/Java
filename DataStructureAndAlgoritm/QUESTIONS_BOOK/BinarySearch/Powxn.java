/*https://leetcode.com/explore/learn/card/binary-search/137/conclusion/982/
 *   Pow(x, n)
  Go to Discuss
Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
package BinarySearch;

public class Powxn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(myPow(0.44528,0));
	}
	
    public static double myPow(double x, int n) {
        double res=0.0;
        if(n==0) return 1.0;
        for(int i=1;i<Math.abs(n);i++){
            if(n>0)
            res= (res==0?x:res)*x;
            else{
            res= (res==0?(1/x):res)*(1/x);
            }
        }
        return res;
    }

}
