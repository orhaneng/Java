/*https://leetcode.com/explore/learn/card/queue-stack/239/conclusion/1387/
 *   Implement Stack using Queues
  Go to Discuss
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
Example:

MyStack stack = new MyStack();

stack.push(1);
stack.push(2);  
stack.top();   // returns 2
stack.pop();   // returns 2
stack.empty(); // returns false
Notes:

You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
package queue_stack_DFS_BFS;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 MyStack obj = new MyStack();
		 obj.push(2);
		 obj.push(3);
		 obj.push(4);

		 int param_2 = obj.pop();
		 int param_3 = obj.top();
		 boolean param_4 = obj.empty();
	}
	
	static class MyStack {
	     private Queue<Integer> queue = new LinkedList<>();

	     public void push(int x) {
	         queue.add(x);
	         for (int i=1; i<queue.size(); i++)
	             queue.add(queue.remove());
	     }

	     public int pop() {
	         return queue.remove();
	     }

	     public int top() {
	         return queue.peek();
	     }

	     public boolean empty() {
	         return queue.isEmpty();
	     }
	}

}
