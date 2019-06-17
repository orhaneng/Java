package stream;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LoggingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream.of("One", "Two", "Tree").filter(obj -> !obj.equals("One")).peek(obj -> System.out.println(obj))
				.collect(Collectors.toList());
		
		IntStream.of(1,23,4,5,6,7).skip(2).filter(obj -> obj>5).forEach(p -> System.out.println(p));
	}

}
