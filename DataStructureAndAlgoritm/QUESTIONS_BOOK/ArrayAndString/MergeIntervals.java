/*https://leetcode.com/problems/merge-intervals/
 * 56. Merge Intervals
Medium

2132

165

Favorite

Share
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
package ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] arr ={{1,3},{2,6},{8,10},{15,18}};
		int[][] arr ={{1,4},{4,5}}; 
		Solution sol=new Solution();
		int[][] res=(sol.merge(arr));
		for (int[] is : res) {
			System.out.print("{"+is[0]+","+is[1]+"} ");
		}
	}
	static class Solution {
	    public int[][] merge(int[][] intervals) {
	        if(intervals.length<=1) return intervals;
	        
	        Arrays.sort(intervals,((i1,i2)->Integer.compare(i1[0],i2[0])));
	        List<int[]> res = new ArrayList<int[]>();
	        int[] newInternal=intervals[0];
	        res.add(newInternal);
	        for(int[] interval:intervals){
	            if(interval[0]<=newInternal[1]){
	                newInternal[1]=Math.max(interval[1],newInternal[1]);
	            }else{
	                newInternal=interval;
	                res.add(newInternal);
	            }
	        }
				return res.toArray(new int[res.size()][]);
	    
	    }
	}

}
