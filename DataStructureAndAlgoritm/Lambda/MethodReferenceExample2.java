import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> people = Arrays.asList(new Person("Charles", "Dickens", 60), new Person("Lewis", "Carrol", 42),
				new Person("Thomas", "Carlye", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Matthem", "Arnold", 39));

		performConditionally(people, p -> true, System.out::println);
	}
	private static void performConditionally(List<Person> people, Predicate<Person> predicate,
			Consumer<Person> consumer) {
		for (Person person : people) {
			if (predicate.test(person))
				consumer.accept(person);
		}
	}

}
