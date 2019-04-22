/*
 *   Climbing Stairs
  Go to Discuss
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */
package Recursion;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairsfib(50));
	}
	
    static Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    public static int climbStairsrec(int n) {
        if(map.containsKey(n)) return map.get(n);
         if(n<=1) return 1;
        int result= climbStairsrec(n-1)+climbStairsrec(n-2);
        map.put(n,result);
        return result;
    }
    public static int climbStairs(int n) {
        if(n<=1) return 1;
        return climbStairs(n-1)+climbStairs(n-2);
    }

    public static int climbStairsfib(int n) {
        double sqrt5=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }
}
