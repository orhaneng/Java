import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class PascalsTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(5);
		/*
		List<List<Integer>> result = generate(5);
		for (List<Integer> list : result) {
			System.out.print("[");
			for (Integer list2 : list) {
				System.out.print(list2);
				System.out.print(",");
			}
			System.out.print("]");
		}
		*/
	}

	public static void print(int n) {
		List<List<Integer>> res= new ArrayList<List<Integer>>();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for (int i = 0; i < n; i++) {
			List<Integer> inner = new ArrayList<Integer>();
			for (int j = 0; j <= i; j++) {
				String key= String.valueOf(i)+String.valueOf(j);
				int result =pascal(i, j,map );
				map.put(key, result);
				inner.add(result);
			}
			res.add(inner);
		}
		System.out.println(res);
	} 

	public static int pascal(int i, int j,Map<String,Integer> map) {
		String key= String.valueOf(i)+String.valueOf(j);
		if(map.containsKey(key)) {
			return map.get(key);
		}
		if (j == 0 || j == i) {
			return 1;
		} else {
			return pascal(i - 1, j - 1,map) + pascal(i - 1, j,map);
		}
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (numRows == 0)
			return result;
		List<Integer> sublist = new ArrayList<Integer>();
		sublist.add(1);
		result.add(sublist);
		if (numRows == 1)
			return result;
		sublist = new ArrayList<Integer>();
		sublist.add(1);
		sublist.add(1);
		result.add(sublist);
		if (numRows == 2)
			return result;
		for (int i = 1; i < numRows - 1; i++) {
			sublist = new ArrayList<Integer>();
			sublist.add(1);
			List<Integer> previous = result.get(i);
			for (int j = 0; j < previous.size() - 1; j++) {
				sublist.add(previous.get(j) + previous.get(j + 1));
			}
			sublist.add(1);
			result.add(sublist);
		}
		return result;
	}

}
