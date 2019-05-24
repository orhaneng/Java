package heap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * 973. K Closest Points to Origin
Medium

362

41

Favorite

Share
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)

 */
public class KClosestPointsOrigin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = { { 0, 1 }, { 1, 0 } };
		Solution sol = new Solution();
		int[][] res = sol.kClosest(points, 2);
		res = res;
	}

	static class Solution {
		public int[][] kClosest2(int[][] points, int K) {
			int[][] result = new int[K][2];
			PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
			HashMap<Integer, List<Integer>> map = new HashMap();
			for (int i = 0; i < points.length; i++) {
				List<Integer> list = new ArrayList<Integer>();
				int num = points[i][0] * points[i][0] + points[i][1] * points[i][1];
				pQueue.add(num);
				list.add(points[i][0]);
				list.add(points[i][1]);
				List<Integer> maplist = map.getOrDefault(num, new ArrayList<Integer>());
				maplist.add(i);
				map.put(num, maplist);
			}
			int count = 0;
			for (int i = 0; i < K; i++) {
				List<Integer> maplist = map.get(pQueue.remove());
				for (Integer integer : maplist) {
					if (count == K)
						break;
					result[count][0] = points[integer][0];
					result[count][1] = points[integer][1];
					count++;
				}

			}
			return result;
		}

		public int[][] kClosest(int[][] points, int K) {
			PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
					(p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
			for (int[] is : points) {
				pq.offer(is);
				if (pq.size() > K) {
					pq.poll();
				}
			}

			int[][] res = new int[K][2];
			while (K > 0) {
				res[--K] = pq.poll();
			}
			return res;
		}
	}
}
