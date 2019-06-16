import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class UnitExerciseSolutionJava8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> people =Arrays.asList(
				new Person("Charles", "Dickens", 60), new Person("Lewis", "Carrol", 42),
				new Person("Thomas", "Carlye", 51), new Person("Charlotte", "Bronte", 45),
				new Person("Matthem", "Arnold", 39));
		// 1. sort list by last name
		Collections.sort(people,(p1,p2)-> p1.getLastName().compareTo(p2.getLastName()));
		// 2. create a method that prints all elements in the list
		performConditionally(people, p->true, p-> System.out.println(p));
		// 3. create a method that prints all people that have last name beginning with C
		performConditionally(people,p->p.getLastName().startsWith("C"),p-> System.out.println(p));
		
		deneme();
	}

	private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person person : people) {
			if(predicate.test(person))
				consumer.accept(person);
		}
	}
	
	static public class Student{
		public Student(int age) {
			this.age=age;
		}
		int age;
	}
	private static void deneme() {
		PriorityQueue<Student> queue= new PriorityQueue<Student>(5,(s1,s2)->s2.age-s1.age);
		List<Student> list= Arrays.asList(
				new Student(12),
				new Student(1),
				new Student(10));
		for (Student student : list) {
			queue.add(student);
		}
		while(!queue.isEmpty()) {
			System.out.println(queue.remove().age);
		}
	}
}
