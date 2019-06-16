
public class first {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		MyLambda ablockOfCode = (int a, int b) -> a + b;
		StringLength length = s -> s.length();
		printLambda(s -> s.length());
	}
	
	public static void printLambda(StringLength s) {
		System.out.println(s.getLength("orhan"));
	}

}

interface MyLambda {
	int add(int a, int b);
}

interface StringLength {
	int getLength(String s);
}