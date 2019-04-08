
/**
 * File Name: PowerBall.java
 * 
 * @author Jagadeesh Vasudevamurthy
 * @year 2019
 */
/*
 * To compile you require: IntUtil.java RandomInt.java PowerBall.java
 */
import java.util.Arrays;

class PowerBall extends PowerBallBase {

	PowerBall() {
		// NOTHING CAN BE CHANGED HERE
		testBench();
	}

	@Override
	protected void checkTicket() {
		// NOTHING CAN BE CHANGED HERE
		alg();
	}

	public void alg() {
		boolean winFlag=true;
		for (int i = 0; i < winningNumber.length; i++) {
			if (winningNumber[i] != ticketNumber[i]) {
				winFlag=false;
			}
		}
		
		if(winFlag) {
			cash=4;
		}
	}
	// You can have any number of private data structures and procedure
	// YOU WRITE YOUR CODE BELOW. DO NOT CRAM entire code in one procedure

	public static void main(String[] args) {
		System.out.println("PowerBall.java");
		PowerBall m = new PowerBall();
		m.checkTicket();
		System.out.println("PowerBall.javaDone");
	}
}
