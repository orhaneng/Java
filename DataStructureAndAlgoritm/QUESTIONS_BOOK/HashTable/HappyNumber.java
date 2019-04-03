/*
 * Happy Number
  Go to Discuss
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 

Input: 19
Output: true
Explanation: 
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
 */
package HashTable;

import java.util.HashSet;

public class HappyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isHappy(19));
	}
    public static boolean isHappy(int n) {
    	HashSet<Integer> set = new HashSet<Integer>();    	
    	int sum, remain;
    	while(set.add(n)) {
    		sum=0;
    		while(n>0) {
    			remain= n%10;
    			sum=sum+remain*remain;
    			n/=10;
    		}
    		if(sum==1) {
    			return true;
    		}
    		else {
    			n=sum;
    		}
    	}
    	return false;
    }

}
