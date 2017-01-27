package Problem3;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		long mod = (long) (Math.pow(10, 9) + 7);
//		System.out.println(mod);
		for (int a0 = 0; a0 < s; a0++) {
			int n = in.nextInt();
			int e = in.nextInt();
			int[] b = new int[e];
			for (int b_i = 0; b_i < e; b_i++) {
				b[b_i] = in.nextInt();
				// System.out.println(b[b_i]);
			}

			// System.out.println(helper(0, b, -1, 0, n));
			// your code goes here

			long[][] dp = new long[n + 1][e + 1];
			long[] sum = new long[n + 1];
			sum[0] = 1;

			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < e; j++) {
					dp[i][j] = sum[i - 1];
					if (i > b[j]) {
						dp[i][j] = (dp[i][j] - sum[i - b[j] - 1]
								+ dp[i - b[j] - 1][j] + mod)
								% mod;
					}
					sum[i] = (sum[i] + dp[i][j]) % mod;
				}
			}
			System.out.println(sum[n]);
		}
	}

}
