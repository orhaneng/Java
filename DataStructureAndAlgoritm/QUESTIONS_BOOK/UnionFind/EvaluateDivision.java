/*
 * 399. Evaluate Division
Medium

1320

106

Favorite

Share
Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
 

The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 */
package UnionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] values = { 2.0, 3.0 };
		List<List<String>> equations =(Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"))); 
		List<List<String>> queries = (Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"), Arrays.asList("a", "e"),
				Arrays.asList("a", "a"), Arrays.asList("x", "x")));
		Solution sol=new Solution();
		double[] doublelist = sol.calcEquation(equations, values, queries);
		for (double d : doublelist) {
			System.out.println(d);
		}
	}

	static class Solution {
		public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
			double[] res = new double[queries.size()];
			Map<String, String> root = new HashMap<>();
			Map<String, Double> dist = new HashMap<>();
			for (int i = 0; i < equations.size(); i++) {
				String r1 = find(root, dist, equations.get(i).get(0));
				String r2 = find(root, dist, equations.get(i).get(1));
				root.put(r1, r2);
				dist.put(r1, dist.get(equations.get(i).get(1)) * values[i] / dist.get(equations.get(i).get(0)));
			}
			for (int i = 0; i < queries.size(); i++) {
				if (!root.containsKey(queries.get(i).get(0)) || !root.containsKey(queries.get(i).get(1))) {
					res[i] = -1.0;
					continue;
				}
				String r1 = find(root, dist, queries.get(i).get(0));
				String r2 = find(root, dist,queries.get(i).get(1));
				if (!r1.equals(r2)) {
					res[i] = -1.0;
					continue;
				}
				res[i] = (double) dist.get(queries.get(i).get(0)) / dist.get(queries.get(i).get(1));
			}
			return res;
		}

		private String find(Map<String, String> root, Map<String, Double> dist, String s) {
			if (!root.containsKey(s)) {
				root.put(s, s);
				dist.put(s, 1.0);
				return s;
			}
			if (root.get(s).equals(s))
				return s;
			String lastP = root.get(s);
			String p = find(root, dist, lastP);
			root.put(s, p);
			dist.put(s, dist.get(s) * dist.get(lastP));
			return p;
		}
	}
}
