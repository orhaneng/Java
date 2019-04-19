/*
 * Find Smallest Letter Greater Than Target
  Go to Discuss
Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
 */
package BinarySearch;

public class FindSmallestLetterGreaterThanTarget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] letters = {'c', 'f', 'j'};
		System.out.println(nextGreatestLetter(letters, 'c'));

	}

    public static char nextGreatestLetter(char[] letters, char target) {
    	
    	int size = letters.length;
    	if(letters[0]>target) {
    		return letters[0];
    	}
    	else if(letters[size-1]<target){
    		return letters[0];
    	}
    	
    	int left=0;
    	int right=size-1;
    	
    	while(left<=right) {
    		int mid = left+(right-left)/2;
    		
    		if(letters[mid]>target && letters[mid==0?0:mid-1]<target) return letters[mid];
    		else if(letters[mid]<target && letters[mid==size-1?mid:mid+1]>target) return letters[mid+1];
    		else if(letters[mid]==target) return letters[mid==size-1?0:mid+1];
    		if(letters[mid]>target) right=mid-1;
    		else left=mid+1;
    	}
    	
    	return ' ';
    }
}
