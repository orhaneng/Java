package SortingAndSearching;

/*
 * Sorted Merge:Your are given two sorted arrays, A and B, where A has a large enough buffer 
 * at the end to hold B. Write a method to merge B into A in sorted order. 
 */
public class SortedMerge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1,  6, 7,25 };
		int[] b = { 3, 5 };
		int[] result = merge(a, b);

		for (int i : result) {
			System.out.println(i);
		}
	}

	public static int[] merge(int[] A, int[] B) {
		//brute force
		//used extra space. it is not efficent.
		// if you use A from back, you dont need to use extra space.
		int[] newarray = new int[A.length + B.length];
		int indexA = 0;
		int indexB = 0;
		for (int i = 0; i < newarray.length; i++) {
			if (indexB == B.length) {
				newarray[i] = A[indexA];
				indexA++;
				continue;
			}
			if (indexA == A.length) {
				newarray[i] = B[indexB];
				indexB++;
				continue;
			}
			if (A[indexA] < B[indexB]) {
				newarray[i] = A[indexA];
				indexA++;
			} else if (B[indexB] < A[indexA]) {
				newarray[i] = B[indexB];
				indexB++;
			} else {
				newarray[i] = A[indexA];
				i = i + 1;
				newarray[i] = B[indexB];
				indexA++;
				indexB++;
			}
		}
		return newarray;
	}

}
