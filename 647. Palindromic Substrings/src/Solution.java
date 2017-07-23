public class Solution {
	public int countSubstrings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int n = s.length();

		int[][] dp = new int[n][n];

		boolean[][] isPal = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			dp[i][i] = 1;
			isPal[i][i] = true;
		}

		for (int i = 0; i < n - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				isPal[i][i + 1] = true;
				dp[i][i + 1] = 3;
			} else {
				dp[i][i+1] = 2;
			}
		}

		for (int step = 2; step < n; step++) {
			for (int i = 0; i < n - step; i++) {
				int j = step + i;
				
				if (s.charAt(i) == s.charAt(j) && isPal[i+1][j-1]) {
					isPal[i][j] = true;
				}
				
				if (isPal[i][j]) {
					dp[i][j] = dp[i][j-1] + dp[i+1][j] + 1 - dp[i+1][j-1];
				} else {
					dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
				}
			}
		}
		
		return dp[0][n-1];
	}
	public static void main(String[] args) {
		System.out.println(new Solution().countSubstrings("abc"));
	}
}
