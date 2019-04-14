package homework1;

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
		boolean powerball = false;
		int count = 0;
		msg=null;
		if(ticketNumber.length!=6) {
			cash=0;
			msg="Ticket number is not valid";
			return;
		}
		int[] winningNumberSorted= new int[5];
		for(int i=0;i<winningNumber.length-1;i++) {
			winningNumberSorted[i]=winningNumber[i];
		}
		Arrays.sort(winningNumberSorted);
		int[] ticketNumberSorted= new int[5];
		for(int i=0;i<ticketNumber.length-1;i++) {
			ticketNumberSorted[i]=ticketNumber[i];
		}
		Arrays.sort(ticketNumberSorted);

		for (int i = 0; i < ticketNumberSorted.length; i++) {
			if (winningNumberSorted[i] == ticketNumberSorted[i]) {
				count++;
			}
		}
		if (winningNumber[5] == ticketNumber[5])
			powerball = true;
		if (count == 5 && powerball)
			cash = jackpot;
		else if (count == 5 && !powerball)
			cash = 1000000;
		else if (count == 4 && powerball)
			cash = 50000;
		else if (count == 4 && !powerball)
			cash = 100;
		else if (count == 3 && powerball)
			cash = 100;
		else if (count == 3 && !powerball)
			cash = 7;
		else if (count == 2 && powerball)
			cash = 7;
		else if (count == 1 && powerball)
			cash = 4;
		else if (count == 0 && powerball)
			cash = 4;
		else
			cash = 0;
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
