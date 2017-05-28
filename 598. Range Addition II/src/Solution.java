public class Solution {
	public int maxCount(int m, int n, int[][] ops) {
		if (ops == null || ops.length == 0) {
			return m * n;
		}

		int minX = ops[0][0];
		int minY = ops[0][1];
		for (int i = 1; i < ops.length; i++) {
			if (ops[i][0] < minX) {
				minX = ops[i][0];
			}
			if (ops[i][1] < minY) {
				minY = ops[i][1];
			}
		}

		if (minX > m) {
			minX = m;
		}
		if (minY > n) {
			minY = n;
		}
		return minX * minY;
	}

	public static void main(String[] args) {
		int[][] ops = new int[][] { { 2, 2 }, { 3, 3 } };

		System.out.println(new Solution().maxCount(3, 3, ops));
	}
}
