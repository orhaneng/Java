import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Arrays.sort(ar);
        
        int count=0,i= 0;
        while(i<n-1) {
        	System.out.println(ar[i]+"-"+ar[i+1]);
            if(ar[i]==ar[i+1]){
                count++;
                i++;
            }
            i++;
        }
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

    	 int[] intArray = new int[]{ 1,1,2,2,3,3 ,4,5,6,4}; 
        int result = sockMerchant(10,intArray);

        System.out.println(result);
    }
}
