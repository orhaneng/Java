import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * X419-01: Homework 4
1.-Given an unsorted array with N elements find the k-th highest given that k << N.
Test case:
List = 10, 2, 32, 40, 5, 1, 70
4th largest= 10
Time complexity:O(N)
Space complexity:O(N)
 */
public class Homework4 {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(10, 2, 32, 40, 5, 1, 70);
		System.out.println(findKthElement(list, 4));
	}

	public static Integer findKthElement(List<Integer> list, int k) {
		if (k > list.size())
			return null;
		PriorityQueue minHeap = new PriorityQueue();
		for (Integer item : list) {
			minHeap.add(item);
		}

		for (int i = 0; i < list.size(); i++) {
			Integer in = (Integer) minHeap.poll();
			if (i == k - 1)
				return in;
		}

		return null;

	}

}
