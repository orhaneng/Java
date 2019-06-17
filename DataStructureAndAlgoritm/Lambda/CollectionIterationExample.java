import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carrol", 42),
				new Person("Thomas", "Carlye", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Matthem", "Arnold", 39));

		// inside of foreach we use consumer
		// people.forEach((p) -> System.out.println(p));
		// people.forEach(System.out::println);

		people.forEach((p) -> {
			System.out.println(p.getAge() + "-" + p.getFirstName());
		});

	}

}
