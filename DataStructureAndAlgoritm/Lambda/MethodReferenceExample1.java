//https://www.youtube.com/watch?v=lwwIZuwYmNI&list=PLqq-6Pq4lTTa9YGfyhyW2CqdtW9RtY-I3&index=21
public class MethodReferenceExample1 {

	public static void main(String[] args) {
		//Thread thread= new Thread(()->printMessage());
		Thread thread= new Thread(MethodReferenceExample1::printMessage);
		thread.run();
	}
	
	public static void printMessage() {
		System.out.println("hello");
	}
}
 