package SortingAndSearching;

/*
Search in Rotated Array: Given a sorted array of n integers that has been rotated 
an unknown number of times, write code to find an element in the array. 
You may assume that the array was originally sorted in increasing order.
EXAMPLE
Input:find 5 in{15, 16, 19, 20, 25, 1, 3 ,4 ,5 ,7 , 10, 14} 
Output: 8 (the index of 5 in the array)
 */
public class SearchInRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
		
		System.out.println(search(array,0,array.length-1,5));

	}

	static int search(int[] array, int left, int right, int x) {
		int mid = (left + right) / 2;

		if (x == array[mid]) {
			return mid;
		}

		if (left > right) {
			return -1;
		}

		if (array[left] < array[mid]) {
			if (x > array[left] && x < array[mid]) {
				return search(array, left, mid - 1, x);
			} else {
				return search(array, mid + 1, right, x);
			}

		} else if (array[left] > array[mid]) {
			if (x < array[left] && x > array[mid]) {
				return search(array, mid + 1, right, x);
			} else {
				return search(array, left, mid - 1, x);
			}

		} else if (array[left] == array[mid]) {
			if (array[mid] != array[right]) {
				search(array, mid + 1, right, x);
			} else {
				int result = search(array, left, mid - 1, x);

				if (result == -1) {
					return search(array, mid + 1, right, x);
				}
				else return -1;
			}
		}
		return -1;
	}

}
