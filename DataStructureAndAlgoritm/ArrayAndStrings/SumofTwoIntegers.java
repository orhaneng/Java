/*371. Sum of Two Integers
Easy

741

1285

Favorite

Share
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = -2, b = 3
Output: 1
*/
public class SumofTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSum(5, 4));
	}
    public static int getSum(int a, int b) {
        while (b != 0)  
        { 
            // carry now contains common 
            // set bits of x and y 
            int carry = a & b; 
  
            // Sum of bits of x and  
            // y where at least one  
            // of the bits is not set 
            a = a ^ b; 
  
            // Carry is shifted by  
            // one so that adding it  
            // to x gives the required sum 
            b = carry << 1; 
        } 
        return a; 
    }

}
