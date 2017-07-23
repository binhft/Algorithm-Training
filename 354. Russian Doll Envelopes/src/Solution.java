import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes == null || envelopes.length == 0) {
			return 0;
		}

		Arrays.sort(envelopes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				} else {
					return Integer.compare(o1[0], o2[0]);
				}
			}
		});

		int max = 0;
		int n = envelopes.length;
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		for (int num : dp) {
			max = Math.max(max, num);
		}

		return max;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().maxEnvelopes(new int[][] { { 5, 4 },
				{ 6, 4 }, { 6, 7 }, { 2, 3 } }));
		System.out.println(new Solution().maxEnvelopes(new int[][] { { 4,5 },
				{ 4,6 }, { 6, 7 }, { 2, 3 }, {1,1} }));
	}
}
