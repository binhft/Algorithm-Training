public class Solution {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int n = nums.length;
		int[] dp = new int[n];
		int max = 0;

		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().lengthOfLIS(new int[] { -2, -1 }));
	}
}
