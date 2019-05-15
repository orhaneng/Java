/*
 * 1025. Divisor Game
Share
Alice and Bob take turns playing a game, with Alice starting first.

Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:

Choosing any x with 0 < x < N and N % x == 0.
Replacing the number N on the chalkboard with N - x.
Also, if a player cannot make a move, they lose the game.
Return True if and only if Alice wins the game, assuming both players play optimally.
Example 1:
Input: 2
Output: true
Explanation: Alice chooses 1, and Bob has no more moves.
Example 2:

Input: 3
Output: false
Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 */
package dynamicProgramming;

public class DivisorGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divisorGame(5));
	}

	public static boolean divisorGame(int N) {
		boolean[] wisdom = new boolean[N + 1];
		wisdom[0] = false;
		wisdom[1] = false;
		for (int i = 2; i <= N; i++) {
			boolean ans = false;
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					ans = ans || (!wisdom[i - j]);
				}
			}
			wisdom[i] = ans;
		}
		return wisdom[N];
	}

}
