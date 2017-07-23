import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	public int findLongestChain(int[][] pairs) {
		if (pairs == null || pairs.length == 0) {
			return 0;
		}

		Arrays.sort(pairs, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[1]) {
					return Integer.compare(o1[1], o2[1]);
				} else {
					return Integer.compare(o1[0], o2[0]);
				}
			}
		});

		int max = 0;
		int n = pairs.length;
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			dp[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (pairs[i][0] > pairs[j][1] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			max = Math.max(dp[i], max);
		}

		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(new Solution().findLongestChain(new int[][] {
				{1,2},
				{2,3},
				{3,4}
		}));
	}
}
