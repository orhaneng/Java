/*https://leetcode.com/problems/course-schedule/
 * 207. Course Schedule
Medium

1816

89

Favorite

Share
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 */
package topologicalSort;

import java.util.ArrayList;

public class CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] pre = { { 1, 0 },{ 2, 6 },{ 1, 7 },{ 6, 4 },{ 7, 0 },{ 0, 5 }};
		Solution sol = new Solution();
		System.out.println(sol.canFinish(8, pre));
	}

	static class Solution {
		public boolean canFinish(int numCourses, int[][] prerequisites) {
			ArrayList[] graph = new ArrayList[numCourses];
			for (int i = 0; i < numCourses; i++)
				graph[i] = new ArrayList();

			boolean[] visited = new boolean[numCourses];
			for (int i = 0; i < prerequisites.length; i++) {
				graph[prerequisites[i][1]].add(prerequisites[i][0]);
			}

			for (int i = 0; i < numCourses; i++) {
				if (!dfs(graph, visited, i))
					return false;
			}
			return true;
		}

		private boolean dfs(ArrayList[] graph, boolean[] visited, int course) {
			if (visited[course])
				return false;
			else
				visited[course] = true;
			;

			for (int i = 0; i < graph[course].size(); i++) {
				if (!dfs(graph, visited, (int) graph[course].get(i)))
					return false;
			}
			visited[course] = false;
			return true;
		}
	}
}
