/*
 *   K-th Symbol in Grammar
  Go to Discuss
On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).

Examples:
Input: N = 1, K = 1
Output: 0

Input: N = 2, K = 1
Output: 0

Input: N = 2, K = 2
Output: 1

Input: N = 4, K = 5
Output: 1

Explanation:
row 1: 0
row 2: 01
row 3: 0110
row 4: 01101001
 */
package Recursion;


public class KthSymbolinGrammar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(kthGrammar(4, 5));
		System.out.println(Integer.bitCount(5-1));
	}

	public static int kthGrammar(int N, int K) {
		String text;
		String text2 = "";
		text = "0";
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < text.length(); j++) {
				if (text.charAt(j) == '0') {
					text2 = text2 + "01";
				} else {
					text2 = text2 + "10";
				}
			}
			text = text2;
			text2="";
		}
		char[] arr = text.toCharArray();
		return Integer.valueOf(String.valueOf(arr[K-1]));
	}

}
