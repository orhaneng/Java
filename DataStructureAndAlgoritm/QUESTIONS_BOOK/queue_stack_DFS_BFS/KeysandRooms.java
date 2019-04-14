/*https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1391/
 *   Keys and Rooms
  Go to Discuss
There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room. 

Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.

Initially, all the rooms start locked (except for room 0). 

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.

Example 1:

Input: [[1],[2],[3],[]]
Output: true
Explanation:  
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.
Example 2:

Input: [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can't enter the room with number 2.
Note:


 */
package queue_stack_DFS_BFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KeysandRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> rooms = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		rooms.add(list);
		list = new ArrayList<Integer>();
		list.add(3);
		list.add(0);
		list.add(1);
		rooms.add(list);
		list = new ArrayList<Integer>();
		list.add(2);
		rooms.add(list);
		list = new ArrayList<Integer>();
		list.add(0);

		rooms.add(list);
		System.out.println(canVisitAllRooms(rooms));
	}
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack();
        stack.push(0);

        //At the beginning, we have a todo list "stack" of keys to use.
        //'seen' represents at some point we have entered this room.
        while (!stack.isEmpty()) { // While we have keys...
            int node = stack.pop(); // Get the next key 'node'
            for (int nei: rooms.get(node)) // For every key in room # 'node'...
                if (!seen[nei]) { // ...that hasn't been used yet
                    seen[nei] = true; // mark that we've entered the room
                    stack.push(nei); // add the key to the todo list
                }
        }

        for (boolean v: seen)  // if any room hasn't been visited, return false
            if (!v) return false;
        return true;
    }

}
