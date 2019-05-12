
public class CoinChange {

	private static int n = 3; // amount for which change has to be given
	private static int[] d = { 1, 3, 4 }; // array of demonations {1,3,4}
	private static int sd; // size of array d
	private static int cn; // number of minimum coin required to solve the puzzle
	private static int[] m; // m(n) = minimum coin required to solve the puzzle
	private static int[] k; // keep array

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solve();

	}

	private void computeChange(int amount, int[] arrayOfCoinsAvailable) {

	}

	private static void solve() {
		sd = d.length;
		// allocate value array. It cannot be bigger than n
		m = new int[n + 1]; // 0 cents to N cents
		// allocate keep array. it cannot be bigger than n
		k = new int[n + 1];

		cn = 0;
		dp();

		System.out.println("Give minimum change for" + n + " cents using coins");
		// pa(sd,d);
		// pa("m array ",m);
		// pa("k array ", k);

		for (int i = 0; i <= n; i++) {
			System.out.println("minimum change for " + i + " cents can be achieved using " + m[i] + " coins");
			printSolution(i);
		}
	}

	private static void dp() {
		// base case 1: for 0 cent we need to give 0 cent
		m[0] = 0;
		k[0] = 0;

		// base case 1:for 1 cent we need give 1 cent
		m[1] = 1;
		k[1] = 1;

		for (int i = 2; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			int sel = -1;
			for (int j = 0; j < sd; j++) {
				int a = d[j];
				if (a > i) {
					break;
				}
				int v = 1 + m[i - a];
				if (v < min) {
					min = v;
					sel = a;
				}
			}
			if (sel == -1)
				throw new NullPointerException("sel != -1");
			m[i] = min;
			k[i] = sel;
		}
	}

	private static void printSolution(int p) {
		int c = p;
		int i = 1;
		int v = 0;
		while (c > 0) {
			int cv = k[c];
			v = v + cv;
			System.out.println(i + ":" + ":Pick Coin" + cv + "current val=" + v + "remaining value " + (c - cv));
			c = c - k[c];
			i++;
		}
	}

}
