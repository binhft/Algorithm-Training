public class Solution {
	public boolean isValidSudoku(char[][] board) {
		// check row
		for (int i = 0; i < 9; i++) {
			boolean[] mark = new boolean[10];
			for (int j = 0; j < 9; j++) {
				int val = board[i][j];
//				System.out.println(val);
				if (val != '.') {
					int valInt = val - '0';
					if (mark[valInt]) {
						return false;
					} else {
						mark[valInt] = true;
					}
				}
			}
		}
		
		// check column
		for (int i = 0; i < 9; i++) {
			boolean[] mark = new boolean[10];
			for (int j = 0; j < 9; j++) {
				int val = board[j][i];
				if (val != '.') {
					int valInt = val - '0';
					if (mark[valInt]) {
						return false;
					} else {
						mark[valInt] = true;
					}
				}
			}
		}
		
		// check square
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				boolean[] mark = new boolean[10];
				for (int row = 0; row < 3; row ++) {
					for (int col = 0; col < 3; col++) {
						int val = board[i*3 + row][j*3 + col];
						if (val != '.') {
							int valInt = val - '0';
							if (mark[valInt]) {
								return false;
							} else {
								mark[valInt] = true;
							}
						}
					}
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		char[][] input = new char[][] {
				".87654321".toCharArray(),
				"27.......".toCharArray(),
				"3........".toCharArray(),
				"4........".toCharArray(),
				"5........".toCharArray(),
				"6........".toCharArray(),
				"7........".toCharArray(),
				"8........".toCharArray(),
				"9........".toCharArray()
				
				
		};
		
		System.out.println(new Solution().isValidSudoku(input));
	}
}
