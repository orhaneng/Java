package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapperCollectExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//https://www.youtube.com/watch?v=t9LZdu5iLPE&list=PLTyWtrsGknYdqY_7lwcbJ1z4bvc5yEEZl&index=3

		List<String> names = Arrays.asList("Peter", "Sam", "Greg", "Ryan");
		// names.stream().filter(name
		// ->!name.equals("Sam")).forEach(System.out::println);;
//  --------------------map short lambda example-------------------------
//		names.stream().filter(MapperCollectExample::isNotSam).map(User::new).forEach(System.out::println);
//-------------------------------------------------------------------------

//   ------------map example with long function interface------------------------		
//		names.stream().filter(MapperExample::isNotSam).map(new Function<String, User>() {
//			@Override
//			public User apply(String name) {
//				User user = new User("name");
//				return user;
//			}
//		}).forEach(System.out::println);
//  --------------------------------------------------------------

//collector example		
		List<User> UserList = names.stream().filter(MapperCollectExample::isNotSam).map(User::new)
				.collect(Collectors.toList());
		;
	}

	public static boolean isNotSam(String name) {
		if (!name.equals("Sam"))
			return true;
		return false;
	}

	static class User {
		private int age = 30;
		private String name;

		public User(String name) {
			this.name = name;
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
	}
}
