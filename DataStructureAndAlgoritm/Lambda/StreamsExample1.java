import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carrol", 42),
				new Person("Thomas", "Carlye", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Matthem", "Arnold", 39));
		people.stream().filter(p->p.getLastName().startsWith("C")).forEach(p -> System.out.println(p));
		List<String> list = new ArrayList<>();
		
		long count = people.stream().filter(p -> p.getLastName().startsWith("C")).count();
		System.out.println(count);
	}

}
