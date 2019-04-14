/*https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1375/
 * Open the Lock
  Go to Discuss
You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

Example 1:
Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
Example 2:
Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation:
We can turn the last wheel in reverse to move from "0000" -> "0009".
Example 3:
Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
Output: -1
Explanation:
We can't reach the target without getting stuck.
Example 4:
Input: deadends = ["0000"], target = "8888"
Output: -1
 */
package queue_stack_DFS_BFS;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OpentheLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
		String target = "0202";
		System.out.println(openLock(deadends, target));
	}

	public static int openLock(String[] deadends, String target) {
		Queue<String> queue = new LinkedList<>();
		Set<String> visited = new HashSet<String>(Arrays.asList(deadends));
		int depth = -1;
		queue.addAll(Arrays.asList("0000"));
		while (!queue.isEmpty()) {
			depth++;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String node = queue.poll();
				if (node.equals(target)) {
					return depth;
				}
				if (visited.contains(node)) {
					continue;
				}
				visited.add(node);
				queue.addAll(getSuccessors(node));
			}
		}
		return -1;
	}

	private static List<String> getSuccessors(String str) {
		List<String> res = new LinkedList<String>();
		for (int i = 0; i < str.length(); i++) {
			res.add(str.substring(0, i) + (str.charAt(i) == '0' ? 9 : str.charAt(i) - '0' - 1) + str.substring(i + 1));
			res.add(str.substring(0, i) + (str.charAt(i) == '9' ? 0 : str.charAt(i) - '0' + 1) + str.substring(i + 1));
		}
		return res;
	}

}
