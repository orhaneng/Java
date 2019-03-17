/*
 * POWERSET:Write a method to return all subsets of a set.
 */
package Recursion;

import java.util.ArrayList;

public class PowerSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//divideDigit("123456", 0, 1);
		ArrayList<Integer> set = new ArrayList<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		//set.add(4);
		System.out.println(getSubsets(set, 0));
	}
	
	public static int divideDigit(String digits, int start_index, int lenght) {
		if (lenght == digits.length()) {
			return 0;
		}
		// CHECK EVEN FOR EVERY ELEMENT
		String number = digits.substring(start_index, start_index + lenght);
		System.out.println(number);
		if (start_index + lenght == digits.length()) {
			// IF INDEX IS END OF THE DIGIT, INCREASE LENGHT AND CONTROL LARGER STRING
			lenght = lenght + 1;
			start_index = 0;
		} else {
			// CONTROL EACH STRING
			start_index = start_index + 1;
		}
		return divideDigit(digits, start_index, lenght);
	}
	
	static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
		
		ArrayList<ArrayList<Integer>> allsubsets;
		if(set.size()==index) {
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		}
		else {
			allsubsets = getSubsets(set,index+1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset: allsubsets) {
				ArrayList<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(subset);
				newSubset.add(item);
				moresubsets.add(newSubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
}
