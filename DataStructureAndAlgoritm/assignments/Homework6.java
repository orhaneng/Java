/*
 * Create a recursive function that takes a string of digits and counts the possible 
 * ways in which the string can be partition into a sequence of even numbers:
input 10 ==> only one way to partition into even numbers 10
input 22 ==> 2 2 
                     22 
result is 2
input 333 => result is 0

TEST CASES
-DIGIT=22
 COUNT=2
-DIGIT=1234
 EVEN NUMBERS:2,4,12,34,234
 COUNT=5  
TIME COMPLEXITY:O(NLOGN)
MEMORY COMPLEXITY:O(1)
 */
public class Homework6 {

	public static void main(String[] args) {
		System.out.println(divideDigit("1234", 0, 1, 0));
	}

	public static int divideDigit(String digits, int start_index, int lenght, int count) {
		if (lenght == digits.length()) {
			return count;
		}
		// CHECK EVEN FOR EVERY ELEMENT
		int number = Integer.parseInt(digits.substring(start_index, start_index + lenght));
		if (number % 2 == 0) {// IF NUMBER IS EVEN ADD COUNT
			System.out.println(number);
			count++;
		}
		if (start_index + lenght == digits.length()) {
			// IF INDEX IS END OF THE DIGIT, INCREASE LENGHT AND CONTROL LARGER STRING
			lenght = lenght + 1;
			start_index = 0;
		} else {
			// CONTROL EACH STRING
			start_index = start_index + 1;
		}
		return divideDigit(digits, start_index, lenght, count);
	}

}
