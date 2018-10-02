public class Solution {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int[][] dp = new int[nums.length + 1][2];

		for (int i = 1; i <= nums.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
			dp[i][1] = dp[i - 1][0] + nums[i - 1];
		}
		return Math.max(dp[nums.length][0], dp[nums.length][1]);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().rob(new int[] { 2, 7, 9, 3, 1 }));
	}
}
