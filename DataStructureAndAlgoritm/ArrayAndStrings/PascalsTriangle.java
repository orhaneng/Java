import java.util.ArrayList;
import java.util.List;

/*
 * given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class PascalsTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> result = generate(5);
		for (List<Integer> list : result) {
			System.out.print("[");
			for (Integer list2 : list) {
				System.out.print(list2);
				System.out.print(",");
			}
			System.out.print("]");
		}
	}
	
	   public static List<List<Integer>> generate(int numRows) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	        if(numRows==0) return result;
	        List<Integer> sublist =new  ArrayList<Integer>();
	        sublist.add(1);
	        result.add(sublist);
	        if(numRows==1) return result;
	        sublist= new ArrayList<Integer>();
	        sublist.add(1);
	        sublist.add(1);
	        result.add(sublist);
	        if(numRows==2) return result;
	        for(int i=1;i<numRows-1;i++){
	            sublist = new  ArrayList<Integer>();
	            sublist.add(1);
	            List<Integer> previous = result.get(i);
	            for(int j=0;j<previous.size()-1;j++){
	                sublist.add(previous.get(j)+previous.get(j+1));
	            }
	            sublist.add(1);
	            result.add(sublist);
	        }
	        return result;
	    }

}
