import java.util.Arrays;

public class Solution {
	public void rotate(int[][] matrix) {
		int row = matrix.length;

		for (int i = 0; i < row/2; i++) {
			for (int j = i; j < row - i - 1; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[row - j - 1][i];
				matrix[row - j - 1][i] = matrix[row - i - 1][row - j - 1];
				matrix[row - i - 1][row - j - 1] = matrix[j][row - i - 1];
				matrix[j][row - i - 1] = tmp;
			}
		}

	}

	public static void main(String[] args) {
		int[][] input = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		new Solution().rotate(input);

		for (int[] row : input) {
			System.out.println(Arrays.toString(row));
		}
	}
}
