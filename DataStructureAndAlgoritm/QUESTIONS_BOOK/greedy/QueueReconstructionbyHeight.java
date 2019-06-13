/*
 * 406. Queue Reconstruction by Height
Medium

1587

178

Favorite

Share
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.


Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionbyHeight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol= new Solution();
		int[][] nums= {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
		int[][] res= sol.reconstructQueue(nums);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i][0]+" "+res[i][1]);
		}
	}
	static public class Solution {
	    public int[][] reconstructQueue(int[][] people) {
	        Arrays.sort(people, new Comparator<int[]>() {
	            public int compare(int[] a, int[] b) {
	                if (a[0] != b[0]) {
	                    return a[0] - b[0];
	                } else {
	                    return b[1] - a[1];
	                }
	            } 
	        });
	        List<Integer> list = new ArrayList<>();
	        for (int i = 0; i < people.length; i++) {
	            list.add(i);
	        }
	        int[][] res = new int[people.length][2];
	        for (int i = 0; i < people.length; i++) {
	            int index = list.get(people[i][1]);
	            res[index][0] = people[i][0];
	            res[index][1] = people[i][1];
	            list.remove(people[i][1]);
	        }
	        return res;
	    }
	}

}
