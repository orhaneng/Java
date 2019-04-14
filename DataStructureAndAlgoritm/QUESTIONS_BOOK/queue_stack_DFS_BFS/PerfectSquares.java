package queue_stack_DFS_BFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numSquares(12 ));
	}

	public static int numSquares(int n) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		int dept = 0;
		queue.offer(n);
		while (!queue.isEmpty()) {
			dept++;
			int size = queue.size();
			for (int j = 0; j < size; j++) {
				int poll = queue.poll();
				if (!set.add(poll))
					continue;
				for (int i = 1; i <= Math.sqrt(poll); i++) {
					int less = poll - i * i;
					if (less == 0)
						return dept;
					queue.add(less);
				}
			}
		}
		return 0;
	}

	public static int numSquares2(int n) {
		int max = (int) Math.sqrt(n);

		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= max; j++) {
				if (i == j * j) {
					dp[i] = 1;
				} else if (i > j * j) {
					dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
				}
			}
		}

		return dp[n];
	}
}
