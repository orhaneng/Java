/*
 * URLify: Write a method to replace all spaces in a string with '%20: 
 * You may assume that the string has sufficient space at the end to hold 
 * the additional characters, and that you are given the "true" length of 
 * the string. (Note: if implementing in Java, please use a character array 
 * so that you can perform this operation in place.)
SOLUTION
EXAMPLE
Input: "Mr John Smith JJ, 13 Output: "Mr%20John%20Smith"
 * 
 * 
 */
public class URLify {

	public static void main(String[] args) {
		String Input= "Mr John Smith";
		String key = "%20";
		String[] inputArr = Input.split(" ");
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<=inputArr.length-1;i++) {
			builder.append(inputArr[i]);
			if(inputArr[i]!=inputArr[inputArr.length-1]) {
				builder.append(key);
			}
		}
		
		System.out.println(builder);
	}

}
