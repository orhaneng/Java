package homework2;

public class hometry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 1, 1 };
		int arr_size = arr.length;
		System.out.println(printRepeating(arr));

	}

	static int printRepeating(int arrA[]) {
		int count = 0;
		for (int i = 0; i < arrA.length; i++) {
			// check if element is negative, if yes the we have found the duplicate
			if (arrA[Math.abs(arrA[i])] < 0) {
			} else {
				arrA[Math.abs(arrA[i])] = arrA[Math.abs(arrA[i])] * -1;
				count++;
			}
		}

		for (int i = 0; i < arrA.length; i++) {
			arrA[i] = Math.abs(arrA[i]);
		}
		return count;
	}

	static int findduplicate(int[] arr) {
		int n = arr.length;
		// return -1 because in these cases
		// there can not be any repeated element
		if (n <= 1)
			return -1;

		// initialize fast and slow
		int slow = arr[0];
		int fast = arr[arr[0]];

		// loop to enter in the cycle
		while (fast != slow) {

			// move one step for slow
			slow = arr[slow];

			// move two step for fast
			fast = arr[arr[fast]];
		}

		// loop to find entry
		// point of the cycle
		fast = 0;
		while (slow != fast) {
			slow = arr[slow];
			fast = arr[fast];
		}
		return slow;
	}

}
