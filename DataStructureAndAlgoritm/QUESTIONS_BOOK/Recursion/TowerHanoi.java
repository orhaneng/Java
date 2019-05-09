package Recursion;

public class TowerHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TH(100,1,2,3);
	}

	static void  TH(int n, int s, int t, int d) {
		if (n != 0) {
			TH(n - 1, s, d, t);
			System.out.println("move disk " + s + " to " + d);
			TH(n - 1, t, s, d);
		}
	}
}
