/*
 * Add Binary
  Go to Discuss
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 */
public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "1010", b = "1011";
		// System.out.println(b.substring(0,0));
		System.out.println(addBinary(a, b));

	}

	public static String addBinary(String a, String b) {
		int aindex = a.length() - 1;
		int bindex = b.length() - 1;
		StringBuilder result = new StringBuilder();
		int inc = 0;
		while (aindex >= 0 || bindex >= 0) {
			int sum = 0;
			int avalue = 0;
			int bvalue = 0;
			if (aindex >= 0) {
				avalue = Character.getNumericValue(a.charAt(aindex));
			}
			if (bindex >= 0) {
				bvalue = Character.getNumericValue(b.charAt(bindex));
			}
			sum = bvalue + avalue + inc;
			if (sum == 2) {
				result.append("0");
				inc = 1;
			}
			if (sum == 3) {
				result.append("1");
				inc = 1;
			} else if (sum < 2) {
				result.append(sum);
				if (aindex - 1 >=0 || bindex - 1 >=0)
					inc = 0;
			}
			--aindex;
			--bindex;
		}
		if (inc == 1) {
			result.append("1");
		}
		return result.reverse().toString();
	}
}
