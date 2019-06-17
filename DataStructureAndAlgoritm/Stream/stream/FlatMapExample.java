package stream;

import java.util.Arrays;
import java.util.List;

public class FlatMapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<User> users = Arrays.asList(
				new User("Peter", 20, Arrays.asList("1", "2")),
				new User("Sam", 40, Arrays.asList("3", "5", "6")), 
				new User("Ryan", 60, Arrays.asList("6")),
				new User("Adam", 70, Arrays.asList("7", "8")));
		users.stream().map(user -> user.phoneNumbers.stream()).flatMap(stream -> stream.filter(pno -> pno.equals("5")))
				.findAny().ifPresent(System.out::println);
	}

	static class User {
		private int age = 30;
		private String name;
		private List<String> phoneNumbers;

		public User(String name, int age, List<String> phoneNumbers) {
			this.name = name;
			this.age = age;
			this.phoneNumbers = phoneNumbers;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return name + "-" + age;
		}

		public List<String> getPhoneNumbers() {
			return phoneNumbers;
		}

		public void setPhoneNumbers(List<String> phoneNumbers) {
			this.phoneNumbers = phoneNumbers;
		}
	}

}
