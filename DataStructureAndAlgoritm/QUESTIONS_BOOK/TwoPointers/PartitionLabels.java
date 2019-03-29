/*https://leetcode.com/problems/partition-labels/
 * 763. Partition Labels
Medium

803

45

Favorite

Share
A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.
Accepted
39,456
Submissions
57,154
Seen this question in a real interview before?

Yes

No
Contributor
awice

 */
package TwoPointers;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
	}

	public static List<Integer> partitionLabels(String S) {
		List<Integer> result = new ArrayList<Integer>();
		char[] arr = S.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			int maxindex = S.lastIndexOf(arr[i]);
			for (int j = i; j <= maxindex; j++) {
				int index = S.lastIndexOf(arr[j]);
				if (index > maxindex)
					maxindex = index;
			}
			result.add(maxindex-i+1);
			i = maxindex;
		}
		return result;
	}

}
