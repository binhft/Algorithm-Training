public class Solution {
	public int maxSubArray(int[] nums) {
		
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int currentMax = nums[0];
		int totalMax = nums[0];
		for (int i = 1; i < nums.length; i++) {
			currentMax = Math.max(nums[i], currentMax + nums[i]);
			totalMax = Math.max(totalMax, currentMax);
//			System.out.println(i + " " + totalMax);
		}

		return totalMax;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().maxSubArray(new int[] { -2 }));
	}
}
