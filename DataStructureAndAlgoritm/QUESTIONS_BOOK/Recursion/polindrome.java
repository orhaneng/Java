package Recursion;

public class polindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text="ma";
		System.out.println(palindrome(text,0,text.length()-1));
	}
	
	public static boolean palindrome(String text, int start, int end) {
		if(start>end) return true;
		if(text.toCharArray()[start]!=text.toCharArray()[end]) {
			return false;
		}
		return palindrome(text,++start,--end);
	}

}
