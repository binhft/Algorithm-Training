public class Solution {
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		for (int i = 0; i < amount + 1; i++) {
			dp[i] = -1;
		}
		dp[0] = 0;

		for (int i = 1; i < amount + 1; i++) {
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= amount) {
					dp[coins[j]] = 1;
				}
				if (i >= coins[j] && dp[i - coins[j]] != -1) {
					if (dp[i] == -1) {
						dp[i] = 1 + dp[i - coins[j]];
					} else {
						dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
					}
				}
			}
		}

		return dp[amount];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().coinChange(new int[] { 1, 2, 5 }, 3));
	}
}
