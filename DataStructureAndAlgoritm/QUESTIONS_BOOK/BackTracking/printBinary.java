package BackTracking;

public class printBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printBinary(3,"");
	}
	
	public static void printBinary(int digit,String prefix) {
		if(digit==0) {
			System.out.println(prefix);
		}else {
			printBinary(digit-1,prefix+"0");
			printBinary(digit-1,prefix+"1");
		}
	}
}
