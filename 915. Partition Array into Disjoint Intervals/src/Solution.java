import java.util.Arrays;

public class Solution {
	public int partitionDisjoint(int[] A) {
		int n = A.length;
		int[] maxLeft = new int[n];
		int[] minRight = new int[n];
		maxLeft[0] = A[0];
		minRight[n - 1] = A[n - 1];

		for (int i = 1; i < n; i++) {
			maxLeft[i] = Math.max(maxLeft[i - 1], A[i]);
		}
		for (int i = n - 2; i >= 0; i--) {
			minRight[i] = Math.min(minRight[i + 1], A[i]);
		}
//		 System.out.println(Arrays.toString(maxLeft));
//		 System.out.println(Arrays.toString(minRight));

		for (int i = 0; i <= n - 1; i++) {
			if (i == 0 && A[i] <= minRight[i + 1]) {
				return i + 1;
			} else if (i == n - 1 && A[i] >= maxLeft[i - 1]) {
				return i + 1;
			} else if (maxLeft[i] <= minRight[i + 1]) {
				return i + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().partitionDisjoint(new int[] { 6, 0,
				8, 30, 37, 6, 75, 98, 39, 90, 63, 74, 52, 92, 64 }));
	}
}
