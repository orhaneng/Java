import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol=new Solution();
		int[] nums= {4,3,2,7,8,2,3,1}; 
		System.out.println(sol.findDisappearedNumbers(nums));
	}
	
	static class Solution {
	    public List<Integer> findDisappearedNumbers(int[] nums) {
	        List<Integer> list = new ArrayList<Integer>();
	        if(nums==null) return list;
	        for(int i = 0; i < nums.length; i++) {
	            int val = Math.abs(nums[i]) - 1;
	            if(nums[val] > 0) {
	                nums[val] = -nums[val];
	            }
	        }
	        
	        for(int i=0;i<nums.length;i++){
	            if(nums[i]>0)
	                list.add(i+1);
	        }
	        return list;
	    }
	}

}
