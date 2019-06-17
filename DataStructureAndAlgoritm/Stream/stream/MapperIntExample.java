package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import stream.MapperCollectExample.User;

public class MapperIntExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = Arrays.asList("Peter", "Sam", "Greg", "Ryan");
		List<User> UserList = names.stream().filter(MapperCollectExample::isNotSam).map(User::new)
				.collect(Collectors.toList());
		//int sum = UserList.stream().mapToInt(user -> user.getAge()).sum();
		int sum = UserList.stream().mapToInt(User::getAge).sum();
		System.out.println(sum);
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
