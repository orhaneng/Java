/*https://www.programcreek.com/2014/05/leetcode-moving-average-from-data-stream-java/
 * LeetCode – Moving Average from Data Stream (Java)
 
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 */
package queue_stack;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAveragefromDataStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MovingAverage avag = new MovingAverage(4);
		System.out.println(avag.next(4));
		System.out.println(avag.next(10));
		System.out.println(avag.next(20));
		System.out.println(avag.next(3));
		System.out.println(avag.next(1));

	}

	static class MovingAverage {
		int sum;
		int size = 0;
		Queue<Integer> list;

		MovingAverage(int size) {
			this.size = size;
			list = new LinkedList<Integer>();
		}

		public int next(int val) {
			if (list.size() >= size) {
				sum -= list.remove();
			}
			sum += val;
			list.add(val);

			return sum / list.size();
		}
	}
}
