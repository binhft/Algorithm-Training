public class Solution {
	// Solution 1
	// public boolean PredictTheWinner(int[] nums) {
	// return helper(nums, 0, nums.length - 1,
	// new Integer[nums.length][nums.length]) >= 0;
	// }
	//
	// private int helper(int[] nums, int s, int e, Integer[][] cache) {
	// if (cache[s][e] == null) {
	// cache[s][e] = (s == e) ? nums[e] : Math.max(
	// nums[e] - helper(nums, s, e - 1, cache),
	// nums[s] - helper(nums, s + 1, e, cache));
	// }
	//
	// return cache[s][e];
	// }

	// Solution 2
	// public boolean PredictTheWinner(int[] nums) {
	// return first(0, 0, nums, 0, nums.length - 1);
	// }
	//
	// private boolean first(int s1, int s2, int[] nums, int start, int end) {
	// if (start >= end) {
	// if (s1 >= s2) {
	// return true;
	// }
	// return false;
	// }
	// return !second(s1 + nums[start], s2, nums, start + 1, end)
	// || !second(s1 + nums[end], s2, nums, start, end - 1);
	// }
	//
	// private boolean second(int s1, int s2, int[] nums, int start, int end) {
	// if (start >= end) {
	// if (s1 < s2) {
	// return true;
	// }
	// return false;
	// }
	// return !first(s1, s2 + nums[start], nums, start + 1, end)
	// || !first(s1, s2 + nums[end], nums, start, end - 1);
	// }

	// Solution 3
	public boolean PredictTheWinner(int[] nums) {
		int len = nums.length;
		int[][] dp = new int[len][len];

		for (int distance = 0; distance < nums.length; distance++) {
			for (int i = 0; i + distance < len; i++) {
				int j = i + distance;
				if (distance == 0) {
					dp[i][j] = len % 2 == 0 ? -nums[i] : nums[i];
				} else if ((len % 2 == 0 && distance % 2 == 0)
						|| (len % 2 == 1 && distance % 2 == 1)) {
					dp[i][j] = Math.min(-nums[i] + dp[i + 1][j], -nums[j]
							+ dp[i][j - 1]);
				} else {

					dp[i][j] = Math.max(nums[i] + dp[i + 1][j], nums[j]
							+ dp[i][j - 1]);
				}
			}
		}
		System.out.println(dp[0][len - 1]);
		System.out.println(dp[0][1]);
		return dp[0][len - 1] >= 0;
	}

	public static void main(String[] args) {
		System.out.println(new Solution()
				.PredictTheWinner(new int[] { 1, 3, 5, 2 }));
	}
}
