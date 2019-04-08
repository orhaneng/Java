/**
 * File Name: PowerBallBase.java 
 * Sum of N base class
 * 
 * To Compile: IntUtil.java RandomInt.java PowerBallBase.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2019
 */

/*
 * YOU CANNOT CHANGE ANYTHING IN THIS FILE. READ ONLY
 */

abstract class PowerBallBase{
	protected int[] winningNumber ;
	protected int[] ticketNumber ;
	protected long cash ; //Populate cash
	protected String msg ; //Populate error meassage if any. Otherwise null
  static private boolean display = false ;
  static final long jackpot = 100000000;
	protected IntUtil u = new IntUtil();
	
	//I don't know how to write it
  //Override by the concrete class
  abstract void checkTicket() ;
  
  private void printNumbers() {
    if (display) {
      System.out.println("winningNumber ") ;
      u.pLn(winningNumber);
      System.out.println("ticketNumber  ") ;
      u.pLn(ticketNumber);
    }
  }
  
  private void message() {
    if (display) {
      if (cash == jackpot) {
        System.out.println("You won jackpot") ;
      }else if (cash != 0) {
        System.out.println("You won cash = " + cash) ;
      }else {
        System.out.println("You did not win") ;
      }
      if (msg != null) {
      	System.out.println(msg);
      }
    }
  }
  
  protected void testBench() {
		simpleTests() ;
		randomTests() ;
	}	

  
  private void test1(int[] w, int [] t) {
  	winningNumber = w ;
  	ticketNumber = t ;
  	printNumbers() ;
  	cash = 0 ;
  	checkTicket() ;
  	message() ;
  }
  
  private void simpleTests() {
  	display = true ;
    int[] w = {4,8,19,27,24,10} ;
    {
      int [] n= {4,8,19,27,24,10} ;
      test1(w,n);
      u.myassert(cash == jackpot);
    }
    {
      int [] n= {24,27,19,8,4,10} ;
      test1(w,n);
      u.myassert(cash == jackpot);
    }
    {
      int [] n= {24,27,19,8,4,5} ;
      test1(w,n);
      u.myassert(cash == 1000000) ;
    }
    {
      int [] n= {124,127,119,18,14,10} ;
      test1(w,n);
      u.myassert(cash == 4) ;
    }
    {
      int [] n= {124,127,119,18,14,5} ;
      test1(w,n);
      u.myassert(cash == 0) ;
    }
    {
      int [] n= {124,127,119,18,14} ;
      test1(w,n);
      u.myassert(cash == 0) ;
    }
    {
      int [] n= {124,124,19,119,18,14} ;
      test1(w,n);
      u.myassert(cash == 0) ;
    }  
  }
  
  private void randomTests() {
    System.out.println("----------testRandom()  starts-------------") ;
    display = false ;
    int[] w = {4,8,19,27,24,10} ;
    int max = 1000000 ;
    long c = 0 ;
    System.out.println("Buying " + max + " tickets of worth " + max * 2 +"$") ;
    for (int i = 0; i < max; ++i) {    
      int [] n = u.generateRandomNumber(6,true,1,50);
      test1(w,n);
      if (cash == jackpot) {
        System.out.println("Won Jacckpot") ;
      }
      c = c + cash ;
    }
    long p = (c -(max*2)) ;
    System.out.println("Out of " + max + " times you win " + c + "$") ;
    if (p > 0) {
      System.out.println("Profit = " + p) ;
    }else {
      System.out.println("Loss = " + p) ;
    }
    System.out.println("----------testRandom()  ends-------------") ;
  }
	
	public static void main(String[] args) {
		System.out.println("PowerBallBase.java STARTS");
		System.out.println("You cannot instantiate PowerBallBase class: PowerBallBase p = new PowerBallBase() ; ");
		//PowerBallBase p = new PowerBallBase() ;
		System.out.println("PowerBallBase.java ENDS");
	}
}