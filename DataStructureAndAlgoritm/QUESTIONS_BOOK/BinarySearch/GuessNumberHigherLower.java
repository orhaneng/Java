package BinarySearch;

public class GuessNumberHigherLower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(guessNumber(10));
	}

	public static int guessNumber(int n) {
		if (n < 1)
			return 0;
		int left = 1, right = n;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int g = guess(mid);
			if (g == 0)
				return mid;
			else if (g == 1) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

	private static int guess(int n) {
		int real = 6;
		if (n == real)
			return 0;
		else if (n > real)
			return -1;
		else
			return 1;
	}
}
