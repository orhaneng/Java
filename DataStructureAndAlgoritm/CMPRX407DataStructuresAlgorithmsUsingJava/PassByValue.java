
public class PassByValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fail();
	}

	private static void X(int n, MyInt sum, MyInt square) {
		int x = (n * (n + 1)) / 2;
		sum.setInt(x);
		square.setInt(n * n);
		System.out.println(x);
	}

	private static void test() {
		MyInt sum = new MyInt(0);
		MyInt square = new MyInt(0);
		X(10, sum, square);
	}

	static class MyInt {
		MyInt(int x) {
			this.x = x;
		}

		void setInt(int x) {
			this.x = x;
		}

		int getInt() {
			return x;
		}

		private int x;
	}

	private static void fail() {
		int k = 0;
		while (true) {
			int[] a = null;
			System.out.println("fail k = " + (++k));
			a = new int[50000000 * 10];
		}
	}

}
