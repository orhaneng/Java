package SortingAndSearching;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution sol = new Solution();
		int[] arr = { 5, 2, 3, 1 };
		int[] res =sol.sortArray(arr);
		for (int i : res) {
			System.out.print(i + " ");
		}
	}

	static class Solution {
		public int[] sortArray(int[] nums) {
			if (nums.length == 1)
				return nums;
			int pivot = nums.length / 2;
			int[] left = sortArray(Arrays.copyOfRange(nums, 0, pivot));
			int[] right = sortArray(Arrays.copyOfRange(nums, pivot, nums.length));
			return merge(left, right);
		}

		private int[] merge(int[] leftList, int[] rightList) {
			int right = 0, left = 0, ret = 0;
			int[] retList = new int[leftList.length + rightList.length];
			while (left < leftList.length && rightList.length > right) {
				if (leftList[left] <= rightList[right]) {
					retList[ret++] = leftList[left++];
				} else if (leftList[left] > rightList[right]) {
					retList[ret++] = rightList[right++];
				}
			}

			while (left < leftList.length) {
				retList[ret++] = leftList[left++];
			}

			while (right < rightList.length) {
				retList[ret++] = rightList[right++];
			}

			return retList;
		}
	}

}
