package dynamicProgramming;

public class RangeSumQueryImmutable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { -2, 0, 3, -5, 2, -1 };
		NumArray num = new NumArray(arr);
		System.out.println(num.sumRange(2, 5));
	}

	static class NumArray {

		int[] nums;

		public NumArray(int[] nums) {
			for (int i = 1; i < nums.length; i++)
				nums[i] += nums[i - 1];

			this.nums = nums;
		}

		public int sumRange(int i, int j) {
			if (i == 0)
				return nums[j];

			return nums[j] - nums[i - 1];
		}
	}

}
