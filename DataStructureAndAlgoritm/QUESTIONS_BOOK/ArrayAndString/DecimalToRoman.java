package ArrayAndString;

import java.util.HashMap;
import java.util.Scanner;

public class DecimalToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int decimal = scanner.nextInt();
		System.out.println(toRoman(decimal));
	}

	private static String toRoman(int num) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1000, "M");
		map.put(900, "CM");
		map.put(500, "D");
		map.put(400, "CD");
		map.put(100, "C");
		map.put(90, "XC");
		map.put(50, "L");
		map.put(40, "XL");
		map.put(10, "X");
		map.put(9, "IX");
		map.put(5, "V");
		map.put(4, "IV");
		map.put(1, "I");
		String[] romanCharacters = { "M", "CM", "D","CD", "C", "XC", "L","XL", "X", "IX", "V", "IV","I" };
		int[] romanValues = { 1000, 900, 500,400, 100, 90, 50,40, 10, 9, 5,4, 1 };
		String result = "";

		
		
		
		
		for (int i = 0; i < romanValues.length; i++) {
			int numberInPlace = num / romanValues[i];
			if (numberInPlace == 0)
				continue;
			result += numberInPlace == 4 && i > 0 ? romanCharacters[i] + romanCharacters[i - 1]
					: new String(new char[numberInPlace]).replace("\0", romanCharacters[i]);
			num = num % romanValues[i];
		}
		return result;
	}

}
