public class Solution {
	public int getMoneyAmount(int n) {
		if (n == 1) {
			return 0;
		}

		int[][] dp = new int[n + 1][n + 1];
		for (int distance = 1; distance < n; distance++) {
			for (int i = 0; i + distance <= n; i++) {
				int j = i + distance;
				dp[i][j] = Integer.MAX_VALUE;
				for (int k = i; k <= j; k++) {
					dp[i][j] = Math.min(
							dp[i][j],
							k
									+ Math.max(k - 1 >= i ? dp[i][k - 1] : 0,
											k + 1 <= j ? dp[k + 1][j] : 0));
				}
			}
		}

		return dp[1][n];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().getMoneyAmount(5));
	}
}
