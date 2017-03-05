import java.util.Arrays;

public class Solution {
	public int findLonelyPixel(char[][] picture) {
		int res = 0;
		if (picture == null || picture.length == 0 || picture[0].length == 0) {
			return 0;
		}

		int numRow = picture.length;
		int numCol = picture[0].length;

		boolean[] col = new boolean[numCol];
		boolean[] row = new boolean[numRow];

		 Arrays.fill(col, true);
		 Arrays.fill(row, true);

		for (int i = 0; i < numRow; i++) {
			for (int j = 0; j < numCol; j++) {
				if (!col[j]) {
					continue;
				}
				if (picture[i][j] == 'B') {
					boolean isValid = true;
					int checkRow = checkRow(picture, i);
					if (checkRow >= 2) {
						row[i] = false;
						isValid = false;
					}
					int checkCol = checkCol(picture, j);
					if (checkCol >= 2) {
						col[j] = false;
					}
//					System.out.println(checkRow + " " + checkCol);
					if (checkRow == 1 && checkCol == 1) {
						res += 1;
					}

					if (!isValid) {
						continue;
					}
				}
			}
		}

		return res;
	}

	private int checkRow(char[][] picture, int row) {
		int total = 0;
		for (int i = 0; i < picture[0].length; i++) {
			if (picture[row][i] == 'B') {
				total += 1;
			}
		}
		return total;
	}

	private int checkCol(char[][] picture, int col) {
		int total = 0;
		for (int i = 0; i < picture.length; i++) {
			if (picture[i][col] == 'B') {
				total += 1;
			}
		}
		return total;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s
				.findLonelyPixel(new char[][] { { 'W', 'W', 'B' }, {'W', 'B', 'B' }}));
	}
}
