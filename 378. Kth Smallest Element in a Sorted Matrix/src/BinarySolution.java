public class BinarySolution {
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;

		int low = matrix[0][0];
		int high = matrix[n - 1][n - 1];

		while (low <= high) {
			int mid = low + (high - low) / 2;
			int count = 0;
			int j = n - 1;

			for (int i = 0; i < n; i++) {
				while (j >= 0 && matrix[i][j] > mid) {
					j--;
				}
				count += (j + 1);
			}

			if (count < k) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return low;

	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 5, 9 }, { 10, 11, 13 },
				{ 12, 13, 15 } };
		System.out.println(new BinarySolution().kthSmallest(matrix, 3));
	}
}
