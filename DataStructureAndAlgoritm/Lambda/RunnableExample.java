import java.util.Arrays;
import java.util.List;

public class RunnableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread myThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Printed inside runnable");
			}
		});
		myThread.run();
		
		Thread myLambdaThread = new Thread(()->System.out.println("Print inside lambda runnable"));
		myLambdaThread.run();
		
		List<String> list = Arrays.asList("sss","dsds");
	}

}
