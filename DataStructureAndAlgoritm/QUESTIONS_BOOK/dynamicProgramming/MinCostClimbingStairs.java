/*https://leetcode.com/problems/min-cost-climbing-stairs/
 * 746. Min Cost Climbing Stairs
Easy

1037

230

Favorite

Share
On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].

 */
package dynamicProgramming;

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };
		System.out.println(minCostClimbingStairs3(arr));
	}

	public static int minCostClimbingStairs(int[] cost) {
		int f1 = 0;
		int f2 = 0;
		for (int i = cost.length - 1; i >= 0; i--) {
			int f0 = cost[i] + Math.min(f1, f2);
			f2 = f1;
			f1 = f0;
		}

		return Math.min(f1, f2);
	}

	public static int minCostClimbingStairs2(int[] cost) {
		for (int i = 2; i < cost.length; i++) {
			cost[i] += Math.min(cost[i - 1], cost[i - 2]);
		}

		return Math.min(cost[cost.length - 1], cost[cost.length - 2]);
	}

	public static int minCostClimbingStairs3(int[] cost) {
		int[] mc = new int[cost.length + 1];
		mc[0] = cost[0];
		mc[1] = cost[1];

		for (int i = 2; i <= cost.length; i++) {
			int costv = (i == cost.length) ? 0 : cost[i];
			mc[i] = Math.min(mc[i - 1] + costv, mc[i - 2] + costv);
		}
		return mc[cost.length];
	}

}
