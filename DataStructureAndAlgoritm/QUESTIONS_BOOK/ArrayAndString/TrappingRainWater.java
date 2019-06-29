/*https://leetcode.com/problems/trapping-rain-water/
 * 42. Trapping Rain Water
Hard

3724

68

Favorite

Share
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
 */
package ArrayAndString;

public class TrappingRainWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		Solution sool = new Solution();
		System.out.println(sool.trap2(arr));
	}

	static class Solution {
		public int trap(int[] height) {
			if (height == null)
				return 0;
			int ans = 0;
			int size = height.length;
			int[] leftmax = new int[size];
			int[] rightmax = new int[size];
			leftmax[0] = height[0];
			for (int i = 1; i < size; i++) {
				leftmax[i] = Math.max(height[i], leftmax[i - 1]);
			}
			rightmax[size - 1] = height[size - 1];
			for (int i = size - 2; i >= 0; i--) {
				rightmax[i] = Math.max(height[i], rightmax[i + 1]);
			}
			for (int i = 1; i < size - 1; i++) {
				ans += Math.min(leftmax[i], rightmax[i]) - height[i];
			}
			return ans;
		}
		
		public int trap2(int[] height) {
			int left=0,right=height.length-1;
			int ans=0;
			int left_max=0,right_max=0;
			while(left<right) {
				if(height[left]<height[right]) {
					if(height[left]>=left_max) {
						left_max=height[left];
					}else {
						ans+=(left_max-height[left]);
					}
					++left;
				}else {
					if(height[right]>=right_max) {
						right_max=height[right];
					}else {
						ans+=(right_max-height[right]);
					}
					--right;
				}
			}
			return ans;
		}
	}
}
