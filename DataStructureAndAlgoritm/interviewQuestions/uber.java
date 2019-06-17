import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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
2 times y from restaurant B

k=2  we have 2  foods 



find the top k best selling food for each restaurant

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

//		Map<String, List<String>> map = getMostOrderedItems(list, 3);
//		for(Map.Entry<String, List<String>> entry : map.entrySet()) {
//			System.out.println(entry.getKey() + "-" + entry.getValue());
//		}
		//Map<String, List<Order>> map = getMostOrderedItems2(list, 3);
		trying();
	}

	static public class Order {
		public String restaurantName;
		public String getRestaurantName() {
			return restaurantName;
		}

		public void setRestaurantName(String restaurantName) {
			this.restaurantName = restaurantName;
		}

		public String getOrderName() {
			return orderName;
		}

		public void setOrderName(String orderName) {
			this.orderName = orderName;
		}

		public String orderName;

		public Order(String restaurantName, String orderName) {
			this.restaurantName = restaurantName;
			this.orderName = orderName;
		} 
	}

	static public class food implements Comparator<food> {
		String foodname;
		Long count;

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

//	static public Map<String, List<String>> getMostOrderedItems(List<Order> orders, int k) {
//		Map<String, Map<String, Integer>> restaurantMap = new HashMap<String, Map<String, Integer>>();
//		Map<String, List<String>> result = new HashMap<String, List<String>>();
//		for (Order order : orders) {
//			if (!restaurantMap.containsKey(order.restaurantName)) {
//				Map<String, Integer> map = new HashMap<String, Integer>();
//				restaurantMap.put(order.restaurantName, map);
//			}
//			Map<String, Integer> map = restaurantMap.get(order.restaurantName);
//			if (map == null) {
//				map = new HashMap<String, Integer>();
//			}
//			map.put(order.orderName, map.getOrDefault(order.orderName, 0) + 1);
//		}
//
//		for (Map.Entry<String, Map<String, Integer>> entry : restaurantMap.entrySet()) {
//			if (entry.getValue() != null) {
//				PriorityQueue<food> queue = new PriorityQueue<food>(k, new food());
//				for(Map.Entry<String, Integer> ent:entry.getValue().entrySet()) {
//					food food=new food();
//					food.foodname=ent.getKey();
//					food.count=ent.getValue();
//					queue.add(food);
//					if(queue.size()>k) {
//						queue.remove();
//					}
//				}
//				List<String> item= new ArrayList<String>();
//				while(!queue.isEmpty()) {
//					food food=queue.remove();
//					item.add(food.foodname);
//				}
//				result.put(entry.getKey(),item);
//			}
//		}
//
//		return result;
//	}
	static public Map<String, List<Order>> getMostOrderedItems2(List<Order> orders, int k) {
		Map<String, List<String>> result = new HashMap<String, List<String>>();

		Map<String,Map<String,Long>> collectorMapOfLists = orders.stream()    
				  .collect(Collectors.groupingBy(Order::getRestaurantName, 
					        Collectors.groupingBy(Order::getOrderName, Collectors.counting())));
//
//
//		Map<String,Object> collectorMapOfLists = orders.stream()    
//				  .collect(Collectors.groupingBy(Order::getRestaurantName, 
//						  Collectors.collectingAndThen(Collectors.groupingBy(Order::getOrderName, Collectors.counting()),map->{
//             				 map.values().removeIf(l -> l>0);
//             				 return map.keySet();
//             				 })));

//		Map<String,Long> ka = collectorMapOfLists.entrySet()
//                .stream().map(p1-> p1.getValue().
//                		entrySet().stream().filter(p2 -> p2.getValue()>=k));
//        
//		 collectorMapOfLists.entrySet()
//                .stream().map(p1-> p1.getValue().
//                		entrySet()).forEach(p2->p2.stream().map(p3->p3.getValue()));;
		//System.out.println(map);
        
		//map=map;
                        java.util.List<String> strings = Arrays.asList("Zohne", "Redy", "Zohne", "Redy", "Stome");
                		java.util.Set<String> grupingThanFilter = strings.stream().collect(Collectors.collectingAndThen(Collectors
                				 .groupingBy(Function.identity(), Collectors.counting()),map->{
                				 map.values().removeIf(l -> l<=2);
                				 return map.keySet();
                				 }));
                				grupingThanFilter.forEach(System.out::println);
		return null;
	}
	
	static public void trying() {
        java.util.List<String> allWords = Arrays.asList("Zohne", "Zohne", "Zohne", "Zohne", "Zohne", "Redy", "Zohne", "Redy", "Stome");
        java.util.Set<String> grupingThanFilter = allWords.stream().collect(Collectors.collectingAndThen(Collectors
        		 .groupingBy(Function.identity(), Collectors.counting()),map->{
        		 map.values().removeIf(l -> l>=2);
        		 return map.keySet();
        		 }));
        		grupingThanFilter.forEach(System.out::println);
	}
	
}
