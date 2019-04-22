package Recursion;

import java.util.HashMap;
import java.util.Map;

public class fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fib(45));
	}

	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static int fib(int N) {
		if (map.containsKey(N)) {
			return map.get(N);
		}
		if (N < 2)
			return N;
		else {
			int result = fib(N - 1) + fib(N - 2);
			map.put(N, result);
			return result;
		}
	}

}
