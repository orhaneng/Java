/*7. Reverse Integer
Easy

2129

3228

Favorite

Share
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
 * 
 */
public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse2(-123));
	}

	public static int reverse(int x) {
		String text = Integer.toString(x);
		boolean negative = false;
		if (text.charAt(0) == '-') {
			negative = true;
			text = text.substring(1);
		}
		StringBuilder sb = new StringBuilder(text);
		sb = sb.reverse();
		long result = Long.parseLong(sb.toString());
		if (negative)
			result *= -1;
		return (int) result;

	}

	public static int reverse2(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}
}
