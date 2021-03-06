/*
 * 204. Count Primes
Easy

1017

391

Favorite

Share
Count the number of prime numbers less than a non-negative number, n.

Example:

Input: 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

 */
public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPrimes(10));
	}
    public static int countPrimes(int n) {
        boolean[] notPrime =new boolean[n];
        int count=0;
        for(int i=2;i<n;i++){
            if(notPrime[i]==false){
                count++;
                for(int j=2;i*j<n;j++){
                    notPrime[i*j]=true;
                }
            }
        }
        return count;
    }

}
