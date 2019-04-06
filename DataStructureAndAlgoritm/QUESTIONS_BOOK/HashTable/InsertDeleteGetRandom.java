/*
 * Insert Delete GetRandom O(1)
  Go to Discuss
Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();
 */
package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomizedSet randomSet = new RandomizedSet();

		// Inserts 1 to the set. Returns true as 1 was inserted successfully.
		System.out.println(randomSet.insert(1));

		// Returns false as 2 does not exist in the set.
		System.out.println(randomSet.remove(2));

		// Inserts 2 to the set, returns true. Set now contains [1,2].
		System.out.println(randomSet.insert(2));

		// getRandom should return either 1 or 2 randomly.
		System.out.println(randomSet.getRandom());

		// Removes 1 from the set, returns true. Set now contains [2].
		System.out.println(randomSet.remove(1));

		// 2 was already in the set, so return false.
		System.out.println(randomSet.insert(2));

		// Since 2 is the only number in the set, getRandom always return 2.
		System.out.println(randomSet.getRandom());
	}

	static class RandomizedSet {

		Map<Integer, Integer> map;
		ArrayList<Integer> nums;
		java.util.Random rand = new java.util.Random();

		public RandomizedSet() {
			map = new HashMap<Integer, Integer>();
			nums = new ArrayList<Integer>();
		}

		public boolean insert(int val) {
			if (!map.containsKey(val)) {
				map.put(val, nums.size());
				nums.add(nums.size(), val);
				return true;
			}
			return false;
		}

		public boolean remove(int val) {
			if (map.containsKey(val)) {
				int loc = map.get(val);
				if (loc < nums.size() - 1) {
					int last =nums.get(nums.size() - 1);
					nums.add(loc, last);
					map.put(loc, last);
				}
				map.remove(val);
		        nums.remove(nums.size() - 1);
				return true;
			} else {
				return false;
			}
		}

		public int getRandom() {
			return nums.get(rand.nextInt(nums.size()));

		}
	}

}
