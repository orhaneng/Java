/*https://leetcode.com/problems/sort-array-by-parity-ii/
 * 922. Sort Array By Parity II
Easy

224

22

Favorite

Share
Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

You may return any answer array that satisfies this condition.

 

Example 1:

Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.

 */
public class SortArrayByParity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4,2,5,7};
		int[] result =sortArrayByParityII(a);
		for (int i : result) {
			System.out.println(i);
		}
	}
	
    public static int[] sortArrayByParityII(int[] A) { 
        for(int i=0;i<A.length;i++){ 
            if((A[i]%2!=0 && i%2==0)){
                for(int j=i;j<A.length;j++){
                    if(A[j]%2==0){
                        int temp= A[i];
                        A[i]=A[j];
                        A[j]=temp;
                        break;
                    }
                }
                
            }
            if((A[i]%2==0 && i%2!=0)){
                for(int j=i;j<A.length;j++){
                    if(A[j]%2!=0){
                        int temp= A[i];
                        A[i]=A[j];
                        A[j]=temp;
                        break;
                    }
                }
                
            }
        }
        return A;
    }

}
