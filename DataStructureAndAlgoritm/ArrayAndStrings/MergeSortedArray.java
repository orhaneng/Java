/*https://leetcode.com/problems/merge-sorted-array/
 * 88. Merge Sorted Array
Easy
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
 */
public class MergeSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1= {1,2,4,5,6,0};
		int[] nums2= {3};

		int m=5,n=1;
		merge2(nums1, m, nums2, n);
		for (int i : nums1) {
			System.out.print(i+" ");
		}
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		if (m == 0) {
			for (int i = 0; i < nums1.length; i++) {
				nums1[i]=nums2[i];
			}
			nums1=nums2.clone();
			return;
		}
		int counter = m;
		int index1 = 0;
		int index2 = 0;
		while (counter <= nums1.length && index1 < nums1.length && index2 < nums2.length) {
			if (nums2[index2] < nums1[index1] || nums1[index1] == 0) {
				nums1[counter] = nums1[index1];
				nums1[index1] = nums2[index2];
				counter++;
				index2++;
			}
			index1++;
		}
	}
    public static void merge2(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >= 0 && j >= 0) {
            A[k--] = A[i] > B[j] ? A[i--] : B[j--];
        }
        while(j >= 0) {
            A[k--] = B[j--];
        }
    }

}
