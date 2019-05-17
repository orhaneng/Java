/*
 * 171. Excel Sheet Column Number
Easy

529

96

Favorite

Share
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
 */
public class ExcelSheetColumnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(titleToNumber2("AAA"));
	}
	
    public static int titleToNumber(String s) {
        s=s.toLowerCase();
        int n = s.length();
        int number=(s.charAt(s.length()-1)-'a')+1;
        int pow=1;
        for(int i=n-2;i>=0;i--){
            number+=Math.pow(26,pow)*((s.charAt(i)-'a')+1);
            pow++;
        }
        return number;
    }
    public static int titleToNumber2(String s) {
        int result = 0;
        for(int i = 0 ; i < s.length(); i++) {
          result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
      }
}
