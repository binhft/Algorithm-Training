public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}

		int m = matrix.length;
		int n = matrix[0].length;
		int low = 0;
		int high = m * n - 1;

		while (low <= high) {
		
			int mid = low + (high - low) / 2;
//			System.out.println(low + " " + high + " " + mid);
			int row = mid / n;
			int col = mid % n;
			int val = matrix[row][col];
			if (val == target) {
				return true;
			} else if (val > target) {
				high = row * n + col - 1;
			} else {
				low = row * n + col + 1;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] input = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
				{ 23, 30, 34, 50 }, };
//		int[][] input = new int[][] { {4} };
		
		System.out.println(new Solution().searchMatrix(input, 3));
	}
}
