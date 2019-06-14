import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * /*

input #1
restaraunt_name, food_name
"A", "apple"
"A", "banana"
"A", "apple"
"B", "coke"
"B", "coffee"
"B", "coffee"
"A", "banana"
"A", "orange"

input # int k
2 times a from A
2 times y from restarand B

k=2  we have 2  foods 



find the top k best selling food for each restaraunt

k = 2
output:
A => ["apple", "banana"]
B => ["coke", "coffee"]

k = 3 
output:
A => ["apple", "banana", "orange"]
B => ["coke", "coffee"]
 */

public class uber {
	public static void main(String[] args) {

		List<Order> list = new ArrayList<Order>();
		list.add(new Order("A", "apple"));
		list.add(new Order("A", "banana"));
		list.add(new Order("A", "apple"));
		list.add(new Order("B", "coke"));
		list.add(new Order("B", "coffee"));
		list.add(new Order("B", "coffee"));
		list.add(new Order("A", "banana"));
		list.add(new Order("A", "orange"));

		Map<String, List<String>> map = getMostOrderedItems(list, 3);
		for(Map.Entry<String, List<String>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
	}

	static public class Order {
		String restaurantName;
		String orderName;

		public Order(String restaurantName, String orderName) {
			this.restaurantName = restaurantName;
			this.orderName = orderName;
		}
	}

	static public class food implements Comparator<food> {
		String foodname;
		Integer count;

		public food() {
		}

		@Override
		public int compare(food o1, food o2) {
			if (o1.count > o2.count)
				return 1;
			if (o1.count < o2.count)
				return -1;
			return 0;
		}
	}

	static public Map<String, List<String>> getMostOrderedItems(List<Order> orders, int k) {
		Map<String, Map<String, Integer>> restaurantMap = new HashMap<String, Map<String, Integer>>();
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		for (Order order : orders) {
			if (!restaurantMap.containsKey(order.restaurantName)) {
				Map<String, Integer> map = new HashMap<String, Integer>();
				restaurantMap.put(order.restaurantName, map);
			}
			Map<String, Integer> map = restaurantMap.get(order.restaurantName);
			if (map == null) {
				map = new HashMap<String, Integer>();
			}
			map.put(order.orderName, map.getOrDefault(order.orderName, 0) + 1);
		}

		for (Map.Entry<String, Map<String, Integer>> entry : restaurantMap.entrySet()) {
			if (entry.getValue() != null) {
				PriorityQueue<food> queue = new PriorityQueue<food>(k, new food());
				for(Map.Entry<String, Integer> ent:entry.getValue().entrySet()) {
					food food=new food();
					food.foodname=ent.getKey();
					food.count=ent.getValue();
					queue.add(food);
					if(queue.size()>k) {
						queue.remove();
					}
				}
				List<String> item= new ArrayList<String>();
				while(!queue.isEmpty()) {
					food food=queue.remove();
					item.add(food.foodname);
				}
				result.put(entry.getKey(),item);
			}
		}

		return result;
	}

}
