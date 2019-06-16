import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UnitExerciseSolutionJava7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> people =Arrays.asList(
				new Person("Charles", "Dickens", 60), new Person("Lewis", "Carrol", 42),
				new Person("Thomas", "Carlye", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Matthem", "Arnold", 39));
		// 1. sort list by last name

		Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
		// 2. create a method that prints all elements in the list
		printAll(people);
		// 3. create a method that prints all people that have last name beginning with
		// C
		//printLastNameBeginningWithC(people,new Condition());
		printConditionally(people,new Condition() {

			@Override
			public boolean test(Person s) {
				// TODO Auto-generated method stub
				return s.getLastName().startsWith("C");
			}
			
		});

	}

	private static void printConditionally(List<Person> people, Condition condition) {
		// TODO Auto-generated method stub
		for (Person person : people) {
			if(condition.test(person))
			System.out.println(person);
		}
	}

	private static void printAll(List<Person> people) {
		// TODO Auto-generated method stub
		for (Person person : people) {
			System.out.println(person);
		}
	}
}
interface Condition{
	boolean test(Person s);
}
