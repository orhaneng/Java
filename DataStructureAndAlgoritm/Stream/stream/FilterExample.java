package stream;

import java.util.Arrays;
import java.util.List;

public class FilterExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = Arrays.asList("Peter", "Sam", "Greg", "Ryan");
		//names.stream().filter(name ->!name.equals("Sam")).forEach(System.out::println);;
		names.stream().filter(FilterExample::isNotSam).forEach(System.out::println);;
	}
	public static boolean isNotSam(String name) {
		if(!name.equals("Sam")) return true;
		return false;
	}

}
