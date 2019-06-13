package HashTable;

import java.util.HashSet;
import java.util.Set;

public class hashset_exercize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		Integer[] arr=set.toArray(new Integer[] {});
		for (Integer integer : arr) {
			System.out.println(integer);
		}
	}

}
