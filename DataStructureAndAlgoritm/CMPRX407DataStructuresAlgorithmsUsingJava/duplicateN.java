
/**
 * File Name: duplicateN.java 
 * duplicateN concrete class
 * 
 * To Compile: IntUtil.java RandomInt.java duplicateN.java duplicateNBase.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2019
 */

class duplicateN extends duplicateNBase{
	duplicateN() {
		//NOTHING CAN BE CHANGED HERE
		testBench();
	}
	
	
	@Override
	protected int nsquare_time_constant_space() {
		//NOTHING CAN BE CHANGED HERE
		return alg_nsquare_time_constant_space();
	}
	
	@Override
	protected int ntime_n_space() {
		//NOTHING CAN BE CHANGED HERE
		return alg_ntime_n_space() ;
	}
	
	@Override
	protected int ntime_constant_space() {
		//NOTHING CAN BE CHANGED HERE
		return alg_ntime_constant_space();
  }
	
	//You can have any number of private data structures and procedure
	//YOU WRITE YOUR CODE BELOW. DO NOT CRAM entire code in one procedure

	/*
	 * Time complexity O(n^2)
	 * Space Complexity O(1)
	 */
	private int alg_nsquare_time_constant_space() {
		int num = 0;
		
	  return num;
	}
	
	/*
		Time complexity O(n)
		Space Complexity O(n)
	*/
	private int alg_ntime_n_space() {
		int num = 0;
		
	  return num;
	}
	
	/*
	 * Time complexity O(n)
	 * Space Complexity O(1)
	 */
	private int alg_ntime_constant_space() {
		int ndup = 0 ;
	  return ndup;
	}


	public static void main(String[] args) {
		//NOTHING CAN BE CHANGED HERE
		System.out.println("duplicateN problem STARTS");
		duplicateN m = new duplicateN() ;
		System.out.println("You now understand why we should reduce O(n^2) algorithm to O(n) algorithm");
		System.out.println("duplicateN problem ENDS");
	}
}