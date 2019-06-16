import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] someNumbers = { 1, 2, 3, 4 };
		int key = 0;
		process(someNumbers, key, (v, k) -> {
			try {
				System.out.println(v / k);
			} catch (Exception e) {
				System.out.println("error");
			}
		});
	}

	private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> consumer) {
		for (int i : someNumbers) {
			consumer.accept(i, key);
		}

	}

}
