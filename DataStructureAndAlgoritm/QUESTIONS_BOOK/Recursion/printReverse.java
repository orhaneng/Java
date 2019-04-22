package Recursion;

public class printReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		printReverse("orhan".toCharArray());
	}

	private static void printReverse(char[] str) {
		helper(0, str);
	}

	private static void helper(int index, char[] str) {
		if (str == null || index >= str.length) {
			return;
		}
		helper(index + 1, str);
		System.out.print(str[index]);
	}

}
